package cfp35.objetosnoche.tpfinal.tickersec.test.entities;

import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.entities.Ticket;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;

public class TestTicket {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test ticket Entity ---");
        System.out.println();

        Ticket ticket = new Ticket(
            6, 
            null, 
            null, 
            LocalDateTime.now(), 
            null, 
            Ticket_severities.MEDIA, 
            6, 
            Ticket_status.ABIERTO);
    }
}
