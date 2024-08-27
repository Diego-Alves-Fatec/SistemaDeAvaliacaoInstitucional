package comercial.model.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DominioDAO {

    @Autowired
    private DominioRepository dominioRepository;

    public Dominio consultaDominioValido(int cd_dominio) {
        return dominioRepository.findByCdDominio(cd_dominio);
    }
}
