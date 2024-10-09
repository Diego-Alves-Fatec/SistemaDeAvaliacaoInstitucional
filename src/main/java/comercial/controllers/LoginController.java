package comercial.controllers;

import comercial.model.vo.UsuarioVO;
import comercial.service.QuestaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.Cookie;

import java.util.Arrays;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    QuestaoService questaoService;

    @PostMapping("/loginController")
    public String ValidaLogin(@RequestParam Map<String, String> formParams, Model model, HttpServletResponse response) {
        String login = formParams.get("login");
        UsuarioVO usuario = questaoService.buscarUsuarioPorEmail(login);

        questaoService.geraCookies(formParams,response);

        if (usuario == null) {
            model.addAttribute("erro", true);
            return "index";
        } else {
            model.addAttribute("criptografia", true);
            return "index";
        }
    }

    @PostMapping("/criptografiaController")
    public String ValidaCriptografia(@RequestParam Map<String, String> formParams, HttpServletResponse response, HttpServletRequest request) {
        try {

            String login = null;
            if (request.getCookies() != null) {

                login = Arrays.stream(request.getCookies())
                        .filter(cookie -> "login".equals(cookie.getName()))
                        .map(Cookie::getValue)
                        .distinct()
                        .findFirst()
                        .orElse(null);
            }

            String criptografia = formParams.get("criptografia");

            if (login == null || criptografia == null) {
                return "index";
            }

            String concatenacao = login + criptografia;
            String valorCriptografado = questaoService.criptografar(concatenacao);
            formParams.put("login", valorCriptografado);
            formParams.put("criptografia", "");

            questaoService.geraCookies(formParams, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/exibirForm";
    }


}
