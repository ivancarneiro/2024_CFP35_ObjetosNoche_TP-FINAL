package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import cfp35.objetosnoche.tpfinal.tickersec.repositories.IncidentRepository;

public class TestIncidentRepository {
    public static void main(String[] args) {
        IncidentRepository incidentRepository = new IncidentRepository();

        System.out.println("--- Metodo getAll() ---");
        incidentRepository.getAll().forEach(System.out::println);
        System.out.println();
    }
}
