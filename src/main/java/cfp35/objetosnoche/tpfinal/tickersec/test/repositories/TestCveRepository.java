package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;


import java.time.LocalDate;

import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.CveRepository;

public class TestCveRepository {
    public static void main(String[] args) {
    
        CveRepository cveRepository = new CveRepository();

        System.out.println("---- TEST CVE getAll() ----");
        cveRepository.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("---- TEST CVE getByCveId() ----");
        System.out.println(cveRepository.getLikeCveId("45590"));

        System.out.println();
        System.out.println("---- TEST CVE save() ----");
        cveRepository.save(new CVE(
            0,
            "CVE-2024-20450",
            LocalDate.parse("2024-08-07"),
            LocalDate.parse("2024-08-07"),
            Ticket_severities.CRITICA,
            9.8f,
            "Múltiples vulnerabilidades en la interfaz de administración basada en web de los teléfonos IP de la serie SPA300 de Cisco Small Business y los teléfonos IP de la serie SPA500 de Cisco Small Business podrían permitir que un atacante remoto no autenticado ejecute comandos arbitrarios en el sistema operativo subyacente con privilegios de root. Estas vulnerabilidades existen porque los paquetes HTTP entrantes no se comprueban correctamente en busca de errores, lo que podría provocar un desbordamiento del búfer. Un atacante podría aprovechar esta vulnerabilidad enviando una solicitud HTTP diseñada a un dispositivo afectado. Un exploit exitoso podría permitir que el atacante desborde un búfer interno y ejecute comandos arbitrarios en el nivel de privilegio raíz.",
            "https://sec.cloudapps.cisco.com/security/center/content/CiscoSecurityAdvisory/cisco-sa-spa-http-vulns-RJZmX2Xz"
        ));
        System.out.println(cveRepository.getAll().getLast());
    }
}