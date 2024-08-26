package comercial.model.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominioRepository  extends JpaRepository<Dominio, Integer> {
    Dominio findByCdDominio(int cdDominio);
}