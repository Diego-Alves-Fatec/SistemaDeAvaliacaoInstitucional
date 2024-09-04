package comercial.model.manutencao.questoes.questoes_multiplaescolha;

import comercial.model.manutencao.questoes.Questoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestoesMultiplaEscolhaRepository extends JpaRepository<QuestoesMultiplaEscolha, Integer> {
    QuestoesMultiplaEscolha findById(int id);
    QuestoesMultiplaEscolha findByQuestoes(Questoes questoes);

}
