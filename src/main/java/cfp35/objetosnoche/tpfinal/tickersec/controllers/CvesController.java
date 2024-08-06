package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;


@Controller
public class CvesController {

    private final String mensaje = "Mensaje de CvesController";
    private final CveRepository cveRepository = new CveRepository();

    @GetMapping("/cves")
    public String getCves(Model model, @RequestParam(name = "buscar", defaultValue = "")String buscar) {
        System.out.println("****************************************************************");
        System.out.println(buscar);
        System.out.println("****************************************************************");

        model.addAttribute("titulo", "CVEs");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("cve", new CVE());
        // model.addAttribute("cves", cveRepository.getAll());
        model.addAttribute("getLikeCveId", cveRepository.getLikeCveId(buscar));
        return "cves";
    }

}
