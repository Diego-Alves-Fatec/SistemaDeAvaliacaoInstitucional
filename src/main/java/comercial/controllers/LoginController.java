package comercial.controllers;

import comercial.Utilitarios.BaseController;
import comercial.model.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/formIndex")
    public String ValidaLogin(@ModelAttribute("formData") Map<String, String> formData, Model model) {
        String login = formData.get("login");
        String senha = formData.get("senha");

        boolean isValid = loginService.validaUsuario(login, senha);

        String boasVindas = "Seja bem vindo(a)" + login + "!";

        if ("1".equals(login)) {
            return "manutencao/incluir";
        } else {
            return "questionario/perguntas";
        }

//        if (isValid) {
//            model.addAttribute("mensagem", "Login bem-sucedido!");
//            return "dashboard";
//        } else {
//            String mensagemDinamica = "Login ou Senha incorreta!";
//            model.addAttribute("mensagem", mensagemDinamica);
//            return "index";
//        }
    }


}
