package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;


import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;

public class TestCveRepository {
    public static void main(String[] args) {
    
        CveRepository cveRepository = new CveRepository();

        System.out.println("---- TEST CVE getAll() ----");
        cveRepository.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("---- TEST CVE getByCveId() ----");
        System.out.println(cveRepository.getLikeCveId("45590"));
    }
}