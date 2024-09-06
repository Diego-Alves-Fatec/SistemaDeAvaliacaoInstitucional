package comercial.model.manutencao.questoes;

import ch.qos.logback.core.util.StringUtil;
import comercial.Utilitarios.DominioConstantesCombos;
import comercial.model.dominio.Dominio;
import comercial.model.dominio.DominioRepository;
import comercial.model.manutencao.item_dominio.ItemDominio;
import comercial.model.manutencao.item_dominio.ItemDominioDAO;
import comercial.model.manutencao.questoes.questoes_multiplaescolha.QuestoesMultiplaEscolha;
import comercial.model.manutencao.questoes.questoes_multiplaescolha.QuestoesMultiplaEscolhaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class QuestoesService {

    @Autowired
    QuestoesDAO questoesDAO;

    @Autowired
    ItemDominioDAO itemDominioDAO;

    @Autowired
    private DominioRepository dominioRepository;

    @Autowired
    private QuestoesMultiplaEscolhaDAO questoesMultiplaEscolhaDAO;

    public void carregarCombo(Map formData) {

        List<ItemDominio> combosQuestoes = questoesDAO.carregarCombosItemDominio();

        setTipoAvaliacao(combosQuestoes, formData);
        setTipoQuestao(combosQuestoes, formData);
        setTipoPerfil(combosQuestoes, formData);
        setCategoriaQuestao(combosQuestoes, formData);

    }

    private void setCategoriaQuestao(List<ItemDominio> combosQuestoes, Map<String, List<ItemDominio>> formData) {
        List<ItemDominio> categoriaQuestao = combosQuestoes.stream()
                .filter(item -> item.getFkCdDominio() != null && item.getFkCdDominio().getCdDominio() == DominioConstantesCombos.FLAG_CATEGORIA_QUESTAO)
                .toList();
        formData.put("categoriaQuestao", categoriaQuestao);
    }

    private void setTipoPerfil(List<ItemDominio> combosQuestoes, Map<String, List<ItemDominio>> formData) {
        List<ItemDominio> tipoPerfil = combosQuestoes.stream()
                .filter(item -> item.getFkCdDominio() != null && item.getFkCdDominio().getCdDominio() == DominioConstantesCombos.FLAG_PERFIL)
                .toList();
        formData.put("tipoPerfil", tipoPerfil);
    }

    private void setTipoQuestao(List<ItemDominio> combosQuestoes, Map<String, List<ItemDominio>> formData) {
        List<ItemDominio> tipoQuestao = combosQuestoes
                .stream()
                .filter(item -> item.getFkCdDominio() != null &&
                        item.getFkCdDominio().getCdDominio() == DominioConstantesCombos.FLAG_TIPO_QUESTAO)
                .toList();
        formData.put("tipoQuestao", tipoQuestao);
    }

    private void setTipoAvaliacao(List<ItemDominio> combosQuestoes, Map<String, List<ItemDominio>> formData) {
        List<ItemDominio> tipoAvaliacao = combosQuestoes
                .stream()
                .filter(item -> item.getFkCdDominio() != null && item.getFkCdDominio().getCdDominio() == DominioConstantesCombos.FLAG_TIPO_AVALIACAO)
                .toList();
        formData.put("tipoAvaliacao", tipoAvaliacao);
    }

    public void incluir(Map<String, String> formData) {

        validaCampos(formData);

        Questoes questoes = setCamposForm(formData);

        questoesDAO.incluirQuestao(questoes);

        if(Integer.parseInt(formData.get("tipoQuestao")) == 2) {
            setQuestaoMultiplaEscolha(formData, questoes);
        }
    }

    private Questoes setCamposForm(Map<String, String> formData) {
        Questoes questoes = new Questoes();

        List<Dominio> dominios = dominioRepository.findAll();

        questoes.setCdQuestao(Integer.parseInt(formData.get("numeroQuestao")));
        questoes.setDsQuestao(formData.get("dsQuestao"));

        questoes.setFlagTipoAvaliacao(getTipoAvaliacao(formData, dominios));
        questoes.setFlagCategoriaQuestao(getCategoriaQuestao(formData, dominios));
        questoes.setFlagTipoQuestao(getTipoQuestao(formData, dominios));

        return questoes;
    }

    private void setQuestaoMultiplaEscolha(Map<String, String> formData, Questoes questoes) {
        QuestoesMultiplaEscolha dto = new QuestoesMultiplaEscolha();

        dto.setQuestoes(questoes);

        dto.setResposta1(formData.get("resposta1"));
        dto.setResposta2(formData.get("resposta2"));
        dto.setResposta3(formData.get("resposta3"));
        dto.setResposta4(formData.get("resposta4"));
        dto.setResposta5(formData.get("resposta5"));
        dto.setResposta6(formData.get("resposta6"));
        dto.setResposta7(formData.get("resposta7"));
        dto.setResposta8(formData.get("resposta8"));
        dto.setResposta9(formData.get("resposta9"));
        dto.setResposta10(formData.get("resposta10"));

        questoesMultiplaEscolhaDAO.incluir(dto);
    }

    private ItemDominio getTipoQuestao(Map<String, String> formData, List<Dominio> dominios) {
        return getTiposQuestao(dominios)
                .stream()
                .filter(item -> item.getCdDominio() == Integer.parseInt(formData.get("tipoQuestao")))
                .findFirst()
                .orElse(null);
    }

    private ItemDominio getTipoQuestao(Questoes questoes, List<Dominio> dominios) {
        return getTiposQuestao(dominios)
                .stream()
                .filter(item -> item.getCdDominio() == questoes.getFlagTipoQuestao().getCdDominio())
                .findFirst()
                .orElse(null);
    }

    private List<ItemDominio> getTiposQuestao(List<Dominio> dominios) {
        return itemDominioDAO.carregarItemDominioPorCd(dominios
                .stream()
                .filter(item -> item.getCdDominio() == DominioConstantesCombos.FLAG_TIPO_QUESTAO)
                .findFirst()
                .orElse(null));
    }

    private ItemDominio getCategoriaQuestao(Map<String, String> formData, List<Dominio> dominios) {
        return getCategoriasQuestao(dominios)
                .stream()
                .filter(item -> item.getCdDominio() == Integer.parseInt(formData.get("categoriaQuestao")))
                .findFirst()
                .orElse(null);
    }

    private List<ItemDominio> getCategoriasQuestao(List<Dominio> dominios) {
        return itemDominioDAO.carregarItemDominioPorCd(dominios
                .stream()
                .filter(item -> item.getCdDominio() == DominioConstantesCombos.FLAG_CATEGORIA_QUESTAO)
                .findFirst()
                .orElse(null));
    }

    private ItemDominio getTipoAvaliacao(Map<String, String> formData, List<Dominio> dominios) {
        return getTiposAvaliacao(dominios)
                .stream()
                .filter(item -> item.getCdDominio() == Integer.parseInt(formData.get("tipoAvaliacao"))).findFirst().orElse(null);
    }

    private List<ItemDominio> getTiposAvaliacao(List<Dominio> dominios) {
        return itemDominioDAO.carregarItemDominioPorCd(dominios
                .stream()
                .filter(item -> item.getCdDominio() == DominioConstantesCombos.FLAG_TIPO_AVALIACAO)
                .findFirst()
                .orElse(null));
    }

    private void validaCampos(Map<String, String> formData) {

        try {
            int numeroQuestao = Integer.parseInt(formData.get("numeroQuestao"));
            String dsQuestao = formData.get("dsQuestao");
            int tipoAvaliacao = Integer.parseInt(formData.get("tipoAvaliacao"));
            int categoriaQuestao = Integer.parseInt(formData.get("categoriaQuestao"));
            int tipoQuestao = Integer.parseInt(formData.get("tipoQuestao"));

        } catch (NumberFormatException e) {
            throw new RuntimeException("Ocorreu um erro nos valores fornecidos pelo formulário");
        }

    }

    public Questoes consultar(Map<String, String> formData) {
        List<Dominio> dominios = dominioRepository.findAll();

        ItemDominio tipoAvaliacao = getTipoAvaliacao(formData, dominios);

        int numeroQuestao = Integer.parseInt(formData.get("numeroQuestao"));

        Questoes questoes = questoesDAO.consultar(numeroQuestao,tipoAvaliacao);

        ItemDominio tipoQuestao = getTipoQuestao(questoes, dominios);

        if(questoes != null) {
            if(questoes.getFlagTipoQuestao().getCdDominio() == 1) {
                formData.put("multiplaEscolha","false");
            } else if(questoes.getFlagTipoQuestao().getCdDominio() == 2) {
                formData.put("multiplaEscolha","true");
            }
        }

        return questoes;

    }

    public List<String> consultarQuestoesMultiplaEscolha(Questoes questoes) {
        return extrairFlags(questoesMultiplaEscolhaDAO.consultarQuestaoMultiplaEscolha(questoes));
    }

    public List<String> extrairFlags(QuestoesMultiplaEscolha questoesMultiplaEscolha) {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> "getResposta" + i)
                .map(methodName -> {
                    try {
                        Method method = questoesMultiplaEscolha.getClass().getMethod(methodName);
                        return (String) method.invoke(questoesMultiplaEscolha);
                    } catch (Exception e) {
                        throw new RuntimeException("Erro ao extrair resposta: " + methodName, e);
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    public boolean validaCarregar(Map<String, String> formData) {
        return formData.containsKey("tipoAvaliacao") && formData.containsKey("numeroQuestao") &&
                !StringUtil.isNullOrEmpty(formData.get("tipoAvaliacao")) &&
                !StringUtil.isNullOrEmpty(formData.get("numeroQuestao"));
    }
}
