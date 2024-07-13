package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;

public class TestCveRepository {
    public static void main(String[] args) {
    
        CveRepository cveRepository = new CveRepository();

        System.out.println("____ TEST CVE getAll() ____");
        cveRepository.getAll().forEach(System.out::println);
    }
}