package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;

@Controller
public class CvesController {

    private String mensaje = "";
    private final CveRepository cveRepository = new CveRepository();

    @GetMapping("/cves")
    public String getCves(Model model, @RequestParam(defaultValue = "") String buscar) {

        model.addAttribute("titulo", "CVEs");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("cve", new CVE());
        // model.addAttribute("cves", cveRepository.getAll());
        model.addAttribute("getLikeCveId", cveRepository.getLikeCveId(buscar));
        model.addAttribute("severidades", Ticket_severities.values());
        return "cves";
    }

    @PostMapping("/registrarCve")
    public String registrarCve(@ModelAttribute CVE cve) {
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println(cve);
        System.out.println("****************************************************************");
        System.out.println();

        if (cve.getId() > 0) {
            cveRepository.save(cve);
            mensaje = "Se registró un nuevo cve: " + cve.getCveId();
        } else {
            mensaje = "Hubo un error al guardar el cve";
        }
        return "redirect:cves";
    }

}
