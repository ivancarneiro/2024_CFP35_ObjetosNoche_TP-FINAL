package cfp35.objetosnoche.tpfinal.tickersec.test.entities;


import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.entities.Ticket;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;

public class TestTicket {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test ticket Entity ---");
        System.out.println();

        Ticket ticket = new Ticket(
            6, 
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
            "Resumen del ticket...");

        System.out.println(ticket);
    }

}
