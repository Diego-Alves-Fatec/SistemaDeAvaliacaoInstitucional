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

    @PostMapping("/formLogin")
    public String ValidaLogin(@ModelAttribute("formData") Map<String, String> formData, Model model) throws Exception {

        boolean isValid = loginService.validaUsuario(formData);

        if (isValid) {
            model.addAttribute("mensagem", "Login bem-sucedido!");
            return "redirect:/manutencao/exibirIncluir";
        } else {
            model.addAttribute("mensagem", "Login ou Senha incorreta!");
            return "questionario/perguntas";
        }
    }


}
