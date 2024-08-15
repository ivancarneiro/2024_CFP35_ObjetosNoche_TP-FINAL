package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import cfp35.objetosnoche.tpfinal.tickersec.entities.FilterCategory;
import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategory;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategoryRepository;

public class TestTicketCategoryRepository {
    public static void main(String[] args) {
        TicketCategoryRepository categoryRepository = new TicketCategoryRepository();

        // System.out.println("--- Metodo getAll() ---");
        // categoryRepository.getAll().forEach(System.out::println);
        // System.out.println();

        // System.out.println("--- Metodo save() ---");
        // categoryRepository.save(
        //         new TicketCategory(38, "Test Entity", "Test Ticket Categorie", "Probando entidad Ticket Categorie", true));
        // System.out.println("---> se registro la categoria de ticket: " + categoryRepository.getById(38));
        // System.out.println();

        // System.out.println("--- Metodo getById() ---");
        // System.out.println(categoryRepository.getById(38));
        // System.out.println();

        // System.out.println("--- Metodo remove() ---");
        // System.out.println("---> se elimino la categoría de ticket : *** (" + categoryRepository.getById(38) + ") ***");
        // categoryRepository.removeCategory(38);
        // System.out.println("---> lista actualizada de categorias (últimos 5 elementos):\n");
        // categoryRepository.getAll().reversed().subList(0, 5).forEach(System.out::println);
        // System.out.println();

        // System.out.println("--- Metodo update() ---");
        // System.out.println();

        System.out.println("--- Metodo getCategoryFiltered() ---");
        categoryRepository.getCategoryFiltered(
            new FilterCategory(
                "Intrusion",
                "Explotación de vulnerabilidades"
            )).forEach(System.out::println);
    }
}
