package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.entities.Ticket;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategoryRepository;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketRepository;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.UserRepository;

@Controller
public class IndexController {

    private String mensaje = "Mensaje de IndexController";
    private final TicketRepository ticketRepository = new TicketRepository();
    private final UserRepository userRepository = new UserRepository();
    private final TicketCategoryRepository categoryRepository = new TicketCategoryRepository();

    @GetMapping("/")
    public String getIndex(Model model, @RequestParam(name = "buscar", defaultValue = "")String buscar){
        model.addAttribute("titulo", "TickerSec");
        model.addAttribute("mensaje", mensaje);
        // model.addAttribute("tickets", ticketRepository.getAll());
        model.addAttribute("getLikeTitulo", ticketRepository.getLikeTitulo(buscar));
        model.addAttribute("ticketRepo", ticketRepository);
        model.addAttribute("categoryRepo", categoryRepository);
        model.addAttribute("userRepo", userRepository);
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("tipos", Ticket_types.values());
        model.addAttribute("severidades", Ticket_severities.values());
        model.addAttribute("impactos", Ticket_impacts.values());
        model.addAttribute("estados", Ticket_status.values());
        return "index";
    }

    @PostMapping("/crearTicket")
    public String crearTicket(@ModelAttribute Ticket ticket) {
        System.out.println();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setLastUpdate(LocalDateTime.now());
        ticket.setStatus(Ticket_status.ABIERTO);
        ticketRepository.save(ticket);
        if(ticket.getId()>0){
            mensaje = "Se guardo el ticket "+ticket.getType()+ticket.getId();
        } else {
            mensaje = "Hubo un error al guardar el ticket";
        }
        return "redirect:/";
    }
}