package comercial.controllers;

import comercial.Utilitarios.BaseController;
import comercial.Utilitarios.DominioTipoOperacao;
import comercial.model.manutencao.item_dominio.ItemDominio;
import comercial.model.manutencao.questoes.Questoes;
import comercial.model.manutencao.questoes.QuestoesService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/exibirIncluir")
    public String exibirIncluir(Model model) {

        Map<String,?> formData = new HashMap<>();
//        formData.put("operacao",DominioTipoOperacao.INCLUIR);
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
        Questoes questoes = questoesService.consultar(formData);
        model.addAttribute("questoes", questoes);
        return "manutencao/consultar_resultados";
    }

    @GetMapping("/alterar")
    public String alterar() {
        return "manutencao/alterar";
    }

    @GetMapping("/excluir")
    public String excluir() {
        return "manutencao/excluir";
    }

}
