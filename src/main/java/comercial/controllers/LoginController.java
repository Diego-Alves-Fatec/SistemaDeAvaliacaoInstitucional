package comercial.controllers;

import comercial.model.repository.ItemDominioRepository;
import comercial.model.repository.QuestaoRepository;
import comercial.model.repository.UsuarioRepository;
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

    @Autowired
    ItemDominioRepository itemDominioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/loginController")
    public String ValidaLogin(@RequestParam Map<String, String> formParams, Model model, HttpServletResponse response) {

        String login = formParams.get("login");
        UsuarioVO usuario = questaoService.buscarUsuarioPorEmail(login);

        if (usuario == null) {
            model.addAttribute("erro", true);
            return "index";
        } else if(usuario.getFlagSimeNao().getIdItemDominio() == 1) {
            model.addAttribute("respondido", true);
            return "index";
        } else {
            usuario.setFlagSimeNao(itemDominioRepository.findById(1).orElse(null));
            usuarioRepository.save(usuario);
            questaoService.geraCookies(formParams,response);
            model.addAttribute("criptografia", true);
            return "index";
        }

    }

    @PostMapping("/criptografiaController")
    public String ValidaCriptografia(@RequestParam Map<String, String> formParams, HttpServletResponse response, HttpServletRequest request) {
        try {

            String index = questaoService.criptografar(formParams, request);

            if (index != null) return index;

            questaoService.geraCookies(formParams, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/exibirForm";
    }
}
