package comercial.controllers;

import comercial.model.Util.Paginador;
import comercial.model.vo.QuestaoVO;
import comercial.service.QuestaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class FormController {

    @Autowired
    QuestaoService questaoService;

    @GetMapping("/exibirForm")
    public String exibirForm(Model model,@RequestParam Map<String, String> formParams, HttpServletResponse response) {

        List<QuestaoVO> questoes = questaoService.buscarQuestoesInstituicao();

        model.addAttribute("questoes", questoes);

        return "questionario/instituicao";
    }


    @PostMapping(value = "/formController")
    public String FormController(Model model, @RequestParam Map<String, String> formParams, HttpServletResponse response, HttpServletRequest request) {



        return "instituicao";
    }

}
