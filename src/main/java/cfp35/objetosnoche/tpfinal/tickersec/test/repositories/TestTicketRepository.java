package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

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
    }
}
