package cfp35.objetosnoche.tpfinal.tickersec.test.entities;

import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategory;

public class TestTicketCategory {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test Ticker Categorie Entity ---");
        System.out.println();

        TicketCategory ticketCategorie38 = new TicketCategory(
            38, 
            "Test Entity", 
            "Ticket Category Test",
                
            "Probando entidad TicketCategory", 
            true);

        System.out.println(ticketCategorie38);
        System.out.println(ticketCategorie38.getCategory() + " | " + ticketCategorie38.getType());
    }
}
