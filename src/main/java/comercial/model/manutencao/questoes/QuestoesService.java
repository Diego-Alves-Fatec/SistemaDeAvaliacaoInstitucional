package comercial.model.manutencao.questoes;

import comercial.Utilitarios.DominioConstantesCombos;
import comercial.model.dominio.Dominio;
import comercial.model.dominio.DominioRepository;
import comercial.model.manutencao.item_dominio.ItemDominio;
import comercial.model.manutencao.item_dominio.ItemDominioDAO;
import comercial.model.manutencao.questoes.questoes_multiplaescolha.QuestoesMultiplaEscolha;
import comercial.model.manutencao.questoes.questoes_multiplaescolha.QuestoesMultiplaEscolhaDAO;
import comercial.model.manutencao.questoes.questoes_multiplaescolha.QuestoesMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

        dto.setFlag1(formData.get("flag1"));
        dto.setFlag2(formData.get("flag2"));
        dto.setFlag3(formData.get("flag3"));
        dto.setFlag4(formData.get("flag4"));
        dto.setFlag5(formData.get("flag5"));
        dto.setFlag6(formData.get("flag6"));
        dto.setFlag7(formData.get("flag7"));
        dto.setFlag8(formData.get("flag8"));
        dto.setFlag9(formData.get("flag9"));
        dto.setFlag10(formData.get("flag10"));

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

    public QuestoesMultiplaEscolha consultarQuestoesMultiplaEscolha(int id) {
        return questoesMultiplaEscolhaDAO.consultarQuestaoMultiplaEscolha(id);
    }

}
