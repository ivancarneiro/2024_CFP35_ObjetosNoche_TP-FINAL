package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategorie;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategorieRepository;

public class TestTicketCategorieRepository {
    public static void main(String[] args) {
        TicketCategorieRepository tkCategorieRepo = new TicketCategorieRepository();

        System.out.println("--- Metodo getAll() ---");
        tkCategorieRepo.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("--- Metodo save() ---");
        tkCategorieRepo.save(
                new TicketCategorie(38, "Test Entity", "Test Ticket Categorie", "Probando entidad Ticket Categorie"));
        System.out.println("---> se registro la categoria de ticket: " + tkCategorieRepo.getById(38));
        System.out.println();

        System.out.println("--- Metodo getById() ---");
        System.out.println(tkCategorieRepo.getById(38));
        System.out.println();

        System.out.println("--- Metodo getLikeType() ---");
        System.out.println("---> lista de categorias relacionadas a 'malware'\n");
        tkCategorieRepo.getLikeType("malware").forEach(System.out::println);
        System.out.println();

        System.out.println("--- Metodo remove() ---");
        System.out.println("---> se elimino la categoría de ticket : *** (" + tkCategorieRepo.getById(38) + ") ***");
        tkCategorieRepo.remove(38);
        System.out.println("---> lista actualizada de categorias (últimos 5 elementos):\n");
        tkCategorieRepo.getAll().reversed().subList(0, 5).forEach(System.out::println);
        System.out.println();

        System.out.println("--- Metodo update() ---");
        System.out.println();
    }
}
