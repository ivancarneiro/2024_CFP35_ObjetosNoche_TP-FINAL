package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import java.time.LocalDateTime;

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
        System.out.println();

        System.out.println("--- Metodo getById() ---");
        System.out.println(ticketRepository.getById(3));
        System.out.println(ticketRepository.getById(4));
        System.out.println();

        System.out.println("--- Metodo getLikeTitulo() ---");
        System.out.println(ticketRepository.getLikeTitulo("esca"));
        System.out.println();

        System.out.println("--- Metodo save() ---");
        ticketRepository.save(new Ticket(
            6,
            "Pureba metodo save() de TicketRepository",
            Ticket_types.EVE,
            LocalDateTime.now().minusMinutes(68),
            LocalDateTime.now(),
            Ticket_severities.MEDIA,
            Ticket_impacts.BAJO,
            1,
            2,
            2,
            Ticket_status.TRAMITADO,
            "Resumen del ticket de prueba"
        ));
        System.out.println(ticketRepository.getAll().getLast());
        System.out.println();
    }
}
