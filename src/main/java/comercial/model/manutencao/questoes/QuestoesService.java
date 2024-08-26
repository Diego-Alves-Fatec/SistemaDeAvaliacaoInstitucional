package comercial.model.manutencao.questoes;

import comercial.Utilitarios.DominioConstantesCombos;
import comercial.model.manutencao.item_dominio.ItemDominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestoesService {

    @Autowired
    QuestoesDAO questoesDAO;

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
                        item.getFkCdDominio().getCdDominio() == DominioConstantesCombos.FLAG_QUESTAO)
                .toList();
        formData.put("tipoQuestao", tipoQuestao);
    }

    private void setTipoAvaliacao(List<ItemDominio> combosQuestoes, Map<String, List<ItemDominio>> formData) {
        List<ItemDominio> tipoAvaliacao = combosQuestoes
                .stream()
                .filter(item -> item.getFkCdDominio() != null && item.getFkCdDominio().getCdDominio() == DominioConstantesCombos.FLAG_AVALIACAO)
                .toList();
        formData.put("tipoAvaliacao", tipoAvaliacao);
    }

    public void incluir(Map<String, String> formData) {
        formData.get("");
    }
}
