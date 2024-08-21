package comercial.model.login;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

    private LoginRepository loginRepository;

    public Login consultaLoginValido(String login, String senha) {
        return loginRepository.findByLoginAndSenha(login, senha);
    }
}
