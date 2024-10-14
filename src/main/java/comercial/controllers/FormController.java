package comercial.controllers;

import comercial.model.vo.QuestaoVO;
import comercial.model.vo.DisciplinasVO;
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
    public String exibirForm(Model model, @RequestParam Map<String, String> formParams, HttpServletResponse response) {

        questaoService.geraCookies(formParams, response);
        List<QuestaoVO> questoes = questaoService.buscarQuestoesInstituicao();

        model.addAttribute("questoes", questoes);

        return "questionario/instituicao";
    }

    @GetMapping("/exibirFormProfessores")
    public String exibirFormProfessores(Model model, @RequestParam Map<String, String> formParams, HttpServletResponse response) {

        questaoService.geraCookies(formParams, response);
        List<QuestaoVO> questoes = questaoService.buscarQuestoesProfessores();
        List<DisciplinasVO> disciplinas = questaoService.buscarDisciplinas();

        model.addAttribute("questoes", questoes);
        model.addAttribute("disciplinas", disciplinas);

        return "questionario/professores";
    }


    @PostMapping("/formInstituicao")
    public String formInstituicao(Model model, @RequestParam Map<String, String> formParams, HttpServletRequest request) {

        questaoService.persistirRespostasInstituicao(formParams, request);

        return "redirect:/exibirFormProfessores";
    }

    @PostMapping("/formProfessores")
    public String formProfessores(Model model, @RequestParam Map<String, String> formParams, HttpServletRequest request) {

        questaoService.persistirRespostasProfessores(formParams, request);

        return "questionario/agradecimento";
    }
}
