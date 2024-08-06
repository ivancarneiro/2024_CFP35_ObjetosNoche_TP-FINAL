package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;

public class TestCveRepository {
    public static void main(String[] args) {

        CveRepository cveRepository = new CveRepository();

        System.out.println("--- TEST getAll() CveRepository ---");
        cveRepository.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("--- TEST save() CveRepository ---");
        cveRepository.save(new CVE(
                2,
                "CVE-2024-38089",
                "2024-07-09",
                "2024-07-12",
                Ticket_severities.CRITICA,
                9.9f,
                "Vulnerabilidad de elevación de privilegios de Microsoft Defender para IoT",
                "https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-38089"));
        System.out.println(cveRepository.getAll());
        System.out.println();
    }
}