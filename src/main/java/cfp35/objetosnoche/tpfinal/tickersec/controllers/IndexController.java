package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategoryRepository;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketRepository;

@Controller
public class IndexController {

    private final TicketRepository ticketRepository = new TicketRepository();
    private final TicketCategoryRepository tkCategoryRepository = new TicketCategoryRepository();

    @GetMapping("/")
    public String getIndex(Model model, @RequestParam(name = "buscar", defaultValue = "")String buscar){
        model.addAttribute("titulo", "TickerSec");
        model.addAttribute("tickets", ticketRepository.getAll());
        return "index";
    }
}