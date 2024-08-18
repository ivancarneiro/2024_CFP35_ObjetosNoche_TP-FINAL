package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.entities.FilterTicket;
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

    private String mensaje = "";
    private final TicketRepository ticketRepository = new TicketRepository();
    private final UserRepository userRepository = new UserRepository();
    private final TicketCategoryRepository categoryRepository = new TicketCategoryRepository();

    @GetMapping("/")
    public String getIndex(Model model,
            @RequestParam(name = "buscar", required = false) String buscar,
            @RequestParam(name = "typeFilter", required = false) Ticket_types typeFilter,
            @RequestParam(name = "severityFilter", required = false) Ticket_severities severityFilter,
            @RequestParam(name = "impactFilter", required = false) Ticket_impacts impactFilter,
            @RequestParam(name = "statusFilter", required = false) Ticket_status statusFilter,
            @RequestParam(name = "categoryFilter", required = false) Integer categoryFilter,
            @RequestParam(name = "createdByFilter", required = false) Integer createdByFilter,
            @RequestParam(name = "assignedToFilter", required = false) Integer assignedToFilter) {
                System.out.println();
                System.out.println("****************************************");
                System.out.println("buscar: " + buscar);
                System.out.println("typeFilter: " + typeFilter);
                System.out.println("severityFilter: " + severityFilter);
                System.out.println("impactFilter: " + impactFilter);
                System.out.println("statusFilter: " + statusFilter);
                System.out.println("categoryFilter: " + categoryFilter);
                System.out.println("createdByFilter: " + createdByFilter);
                System.out.println("assignedToFilter: " + assignedToFilter);
                System.out.println("****************************************");

        model.addAttribute("titulo", "TickerSec");
        model.addAttribute("buscarPlaceholder", "buscar por titulo del ticket");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("ticketsFiltered", ticketRepository.getTicketsFiltered(new FilterTicket(buscar,typeFilter,severityFilter,impactFilter,statusFilter,categoryFilter,createdByFilter,assignedToFilter)));
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
        if (ticket.getId() > 0) {
            mensaje = "Se guardo el ticket " + ticket.getType() + ticket.getId();
        } else {
            mensaje = "Hubo un error al guardar el ticket";
        }
        return "redirect:/";
    }
}

// TODO Aplicar paginación