package comercial.model.repository;

import comercial.model.vo.DisciplinasVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<DisciplinasVO,Integer> {
}
