package comercial.controllers;

import ch.qos.logback.core.util.StringUtil;
import comercial.Utilitarios.BaseController;
import comercial.Utilitarios.DominioTipoOperacao;
import comercial.model.manutencao.item_dominio.ItemDominio;
import comercial.model.manutencao.questoes.Questoes;
import comercial.model.manutencao.questoes.QuestoesService;
import comercial.model.manutencao.questoes.questoes_multiplaescolha.QuestoesMultiplaEscolha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manutencao")
public class ManutencaoController extends BaseController {

    @Autowired
    private QuestoesService questoesService;

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String exibirHome(@ModelAttribute("formData") Map<String, String> formMap, Model model) {

        return "manutencao/home";
    }

    @GetMapping("/exibirIncluir")
    public String exibirIncluir(Model model) {

        Map<String, ?> formData = new HashMap<>();
        questoesService.carregarCombo(formData);
        model.addAttribute("formData", formData);
        return "manutencao/incluir";
    }

    @PostMapping("/incluir")
    public String incluir(@ModelAttribute("formData") Map<String, String> formData, Model model) {
        questoesService.incluir(formData);
        return "redirect:/manutencao/exibirIncluir";
    }

    @GetMapping("/exibirConsultar")
    public String exibirConsultar() {
        return "manutencao/consultar";
    }

    @PostMapping("/consultar")
    public String consultar(@ModelAttribute("formData") Map<String, String> formData, Model model) {
        try {
            Questoes questoes = questoesService.consultar(formData);
            model.addAttribute("questoes", questoes);
            if (formData.get("multiplaEscolha").equals("true")) {
                model.addAttribute("multiplaEscolha", true);
                List<String> respostas = questoesService.consultarQuestoesMultiplaEscolha(questoes);
                model.addAttribute("respostas", respostas);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        if (formData.containsKey("operacao") && formData.get("operacao").equals("alterar")) {
            questoesService.carregarCombo(formData);
            return "manutencao/alterar_resultados";
        } else if (formData.containsKey("operacao") && formData.get("operacao").equals("excluir")) {
            return "manutencao/excluir_resultados";
        } else {
            return "manutencao/consultar_resultados";
        }

    }

    @RequestMapping(value = "/exibirAlterar", method = {RequestMethod.GET, RequestMethod.POST})
    public String exibirAlterar(@ModelAttribute("formData") Map<String, String> formMap, Model model) {

        Map<String, ?> formData = new HashMap<>();
        questoesService.carregarCombo(formData);
        model.addAttribute("formData", formData);
        return "manutencao/alterar";

    }

    @PostMapping("/alterar")
    public String alterar(@ModelAttribute("formData") Map<String, String> formData, Model model) {
        questoesService.alterar(formData);
        return "redirect:/manutencao/exibirAlterar";
    }

    @RequestMapping(value = "/exibirExcluir", method = {RequestMethod.GET, RequestMethod.POST})
    public String exibirExcluir(@ModelAttribute("formData") Map<String, String> formMap, Model model) {
        Map<String, ?> formData = new HashMap<>();
        questoesService.carregarCombo(formData);
        model.addAttribute("formData", formData);
        return "manutencao/excluir";
    }

    @PostMapping("/excluir")
    public String excluir(@ModelAttribute("formData") Map<String, String> formData, Model model) {
        questoesService.excluir(formData);
        return "redirect:/manutencao/exibirExcluir";
    }

    @GetMapping("/construcao")
    public String construcao() {
        return "manutencao/construcao";
    }

}
