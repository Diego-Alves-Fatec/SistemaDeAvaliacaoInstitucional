package comercial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manutencao")
public class manutencaoController {
    @GetMapping("/incluir")
    public String incluir() {
        return "manutencao/incluir";
    }

    @GetMapping("/consultar")
    public String consultar() {
        return "manutencao/consultar";
    }

    @GetMapping("/alterar")
    public String alterar() {
        return "manutencao/alterar";
    }

    @GetMapping("/excluir")
    public String excluir() {
        return "manutencao/excluir";
    }

    @PostMapping("/consultar-resultados")
    public String consultarResultados() {
        return "manutencao/consultar-resultados";
    }
}
