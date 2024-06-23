package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("fragments/menu")
    public String getMenu() {
        return "fragments/menu.html";
    }
}
