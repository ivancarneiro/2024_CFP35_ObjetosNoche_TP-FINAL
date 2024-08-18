package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.entities.FilterTicket;
import cfp35.objetosnoche.tpfinal.tickersec.entities.Ticket;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketRepository;

public class TestTicketRepository {
    public static void main(String[] args) {
        TicketRepository ticketRepository = new TicketRepository();

        System.out.println("--- Metodo getAll() ---");
        ticketRepository.getAll().forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();

        System.out.println("--- Metodo getById() ---");
        System.out.println(ticketRepository.getById(3));
        System.out.println(ticketRepository.getById(4));
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getLikeTitulo() ---");
        System.out.println(ticketRepository.getLikeTitulo("esca"));
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo save() ---");
        ticketRepository.save(
            new Ticket(
            0, 
            Ticket_types.INC, 
            "Escaneo de red", 
            LocalDateTime.parse("2024-07-12T16:28:17"), 
            LocalDateTime.parse("2024-07-15T21:45:00"), 
            null,
            Ticket_severities.MEDIA,
            Ticket_impacts.BAJO,
            8,
            2,
            null,
            Ticket_status.CERRADO,
            "Resumen del ticket...")
        );
        System.out.println(ticketRepository.getAll().getLast());
        System.out.println("****************************************************************");
        
        System.out.println();
        System.out.println("--- Metodo getLikeCategory() ---");
        ticketRepository.getLikeCategory(19).forEach(System.out::println);
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getLikeTicketType() ---");
        ticketRepository.getLikeTiketType(Ticket_types.EVE).forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        System.out.println("--- Metodo getLikeSeverity() ---");
        ticketRepository.getLikeSeverity(Ticket_severities.ALTA).forEach(System.out::println);
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getLikeImpact() ---");
        ticketRepository.getLikeImpact(Ticket_impacts.IMPORTANTE).forEach(System.out::println);
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getLikeCreatedBy() ---");
        ticketRepository.getLikeCreatedBy(1).forEach(System.out::println);
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getLikeAssigned() ---");
        ticketRepository.getLikeAssigned(2).forEach(System.out::println);
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getLikeStatus() ---");
        ticketRepository.getLikeStatus(Ticket_status.CERRADO).forEach(System.out::println);
        System.out.println("****************************************************************");

        System.out.println();
        System.out.println("--- Metodo getTicketsFiltered() ---");
        ticketRepository.getTicketsFiltered(new FilterTicket(
            "forti",
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )).forEach(System.out::println);
        System.out.println("****************************************************************");
    }
}
