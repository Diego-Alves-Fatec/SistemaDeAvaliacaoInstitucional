package comercial.model.repository;

import comercial.model.vo.DimensaoVO;
import comercial.model.vo.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioVO,Integer> {
    UsuarioVO findByEmail(String email);

}
