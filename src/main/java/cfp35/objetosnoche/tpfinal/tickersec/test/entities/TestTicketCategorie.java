package cfp35.objetosnoche.tpfinal.tickersec.test.entities;

import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategorie;


public class TestTicketCategorie {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test Ticker Categorie Entity ---");
        System.out.println();

        TicketCategorie ticketCategorie38 = new TicketCategorie(38, "Test Entity", "Ticket Category Test", "Probando entidad Ticket Categorie");

        System.out.println(ticketCategorie38.toString());
        System.out.println(ticketCategorie38.getCategory() + " | " + ticketCategorie38.getType());
    }
}
