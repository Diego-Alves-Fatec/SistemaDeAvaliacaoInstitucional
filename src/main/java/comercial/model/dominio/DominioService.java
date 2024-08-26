package comercial.model.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DominioService {

    private DominioDAO dominioDAO;

    public Dominio getDominioByCd(int cd) {
        try {
            Dominio dominio = dominioDAO.consultaDominioValido(cd);
            return dominio;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
