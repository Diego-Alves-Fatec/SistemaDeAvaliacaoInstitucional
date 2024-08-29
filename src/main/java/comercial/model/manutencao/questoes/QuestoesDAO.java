package comercial.model.manutencao.questoes;

import comercial.model.manutencao.item_dominio.ItemDominio;
import comercial.model.manutencao.item_dominio.ItemDominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestoesDAO {

    @Autowired
    QuestoesRepository questoesRepository;

    @Autowired
    ItemDominioRepository itemDominioRepository;


//    @Autowired
//    DominioRepository dominioRepository;

//    public List<ItemDominio> carregarTiposAvaliacao() {
//        Dominio dominio = dominioRepository.findById(1).orElse(null);
//        return itemDominioRepository.findItemDominiosByFkCdDominio(dominio);
//    }

    public List<ItemDominio> carregarCombosItemDominio() {
        return itemDominioRepository.findAll();
    }




    public void incluirQuestao(Questoes questoes) {
        questoesRepository.save(questoes);
    }

    public Questoes consultar(int numeroQuestao, ItemDominio tipoAvaliacao) {
        return questoesRepository.findQuestoesByCdQuestaoAndFlagTipoAvaliacao(numeroQuestao, tipoAvaliacao);
    }
}
