package comercial.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

    @Autowired
    private LoginRepository loginRepository;

    public Login consultaLoginValido(String login, String senha) {
        return loginRepository.findByLoginAndSenha(login, senha);
    }
}
