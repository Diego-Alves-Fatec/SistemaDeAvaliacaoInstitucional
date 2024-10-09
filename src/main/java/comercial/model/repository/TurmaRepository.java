package comercial.model.repository;

import comercial.model.vo.QuestaoVO;
import comercial.model.vo.TurmasVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<TurmasVO,Integer> {
}
