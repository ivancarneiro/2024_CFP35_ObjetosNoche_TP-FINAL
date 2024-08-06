package cfp35.objetosnoche.tpfinal.tickersec.test.entities;

import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.entities.Incident;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;

public class TestIncident {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test Incident Entity ---");
        System.out.println();

        Incident incidente1 = new Incident(
            6, 
            Ticket_types.INC, 
            "Escaneo de red", 
            LocalDateTime.parse("2024-07-30T16:28:17"), 
            LocalDateTime.parse("2024-07-31T21:45:00"), 
            null,
            Ticket_severities.MEDIA,
            Ticket_impacts.BAJO,
            8,
            "203.0.113.42, 198.51.100.20, 200,4.54.123",
            "192.168.1.10, 10.34.3.56",
            "10567, 10565, 10566",
            "22, 1336, 3306",
            2,
            null,
            Ticket_status.CERRADO,
            "Resumen del ticket...",
            null
        );

        System.out.println(incidente1);
    }
}
