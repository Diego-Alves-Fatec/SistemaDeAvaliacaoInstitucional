package comercial.Utilitarios;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    @ModelAttribute("formData")
    public Map<String, String> encapsulaFormData(@RequestParam Map<String, String> formData) {

        Map<String, String> dataMap = new HashMap<>(formData);
        return dataMap;
    }
}
