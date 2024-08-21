package comercial.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public boolean validaUsuario(String login, String senha) {

        try {
            Login loginEntity = loginDAO.consultaLoginValido(login, senha);
            return loginEntity != null;
        } catch (Exception e) {
            return false;
        }

    }
}
