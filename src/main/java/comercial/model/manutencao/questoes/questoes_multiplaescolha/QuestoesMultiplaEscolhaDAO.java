package comercial.model.manutencao.questoes.questoes_multiplaescolha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestoesMultiplaEscolhaDAO {

    @Autowired
    QuestoesMultiplaEscolhaRepository questoesMultiplaEscolhaRepository;

    public void incluir(QuestoesMultiplaEscolha dto) {
        questoesMultiplaEscolhaRepository.save(dto);
    }

    public QuestoesMultiplaEscolha consultarQuestaoMultiplaEscolha(int questoesID) {
        return questoesMultiplaEscolhaRepository.findById(questoesID);
    }
}
