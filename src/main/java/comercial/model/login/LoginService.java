package comercial.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public boolean validaUsuario(Map<String,String> formData) throws Exception {

        String login = formData.get("login");
        String senha = formData.get("senha");

        validaCampos(login,senha);

        try {
            Login loginEntity = loginDAO.consultaLoginValido(login, senha);
            return loginEntity != null;
        } catch (Exception e) {
            return false;
        }

    }

    private void validaCampos(String login, String senha) throws Exception {

        if(login.isBlank()) {
            throw new Exception("O campo de login é obrigatório");
        }

        if(senha.isBlank()) {
            throw new Exception("O campo de senha é obrigatório");
        }

    }
}
