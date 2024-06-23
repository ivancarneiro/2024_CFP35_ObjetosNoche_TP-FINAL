package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.utils.SystemProperties;


@Controller
public class ConfiguracionController {
    @GetMapping("/configuracion")
    public String getConfiguracion(Model model) {
        String so=SystemProperties.getSO();
        String java=SystemProperties.getJava();
        String user=SystemProperties.getUser();
        String location=SystemProperties.getLocation();
        String ip=SystemProperties.getIP();
        String date=SystemProperties.getDate();
        String language=SystemProperties.getLanguage();
        String url = Connector.getUrl();

        //model.addAttribute("valor", valor);
        model.addAttribute("so", so);
        model.addAttribute("java", java);
        model.addAttribute("user", user);
        model.addAttribute("location", location);
        model.addAttribute("ip", ip);
        model.addAttribute("language", language);
        model.addAttribute("date", date);
        model.addAttribute("jdbc", url);

        return "configuracion";
    }
}
