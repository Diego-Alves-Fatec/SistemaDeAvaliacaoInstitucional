package comercial.model.manutencao.questoes;

import comercial.model.manutencao.item_dominio.ItemDominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestoesRepository extends JpaRepository<Questoes, Integer> {
    Questoes findQuestoesByCdQuestaoAndFlagTipoAvaliacao(int cdQuestao, ItemDominio flagTipoAvaliacao);

}
