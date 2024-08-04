package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;


import java.time.LocalDateTime;
import java.time.Duration;

import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;

public class TestCveRepository {
    public static void main(String[] args) {
    
        CveRepository cveRepository = new CveRepository();

        // System.out.println("____ TEST CVE getAll() ____");
        // cveRepository.getAll().forEach(System.out::println);

        LocalDateTime ahora = LocalDateTime.now();
        System.out.println(ahora);
        LocalDateTime start = LocalDateTime.parse("2024-07-13T15:48:36");
        System.out.println(start);

        Duration duracion = Duration.between(start, ahora);
        System.out.println(duracion.getSeconds());

    }
}