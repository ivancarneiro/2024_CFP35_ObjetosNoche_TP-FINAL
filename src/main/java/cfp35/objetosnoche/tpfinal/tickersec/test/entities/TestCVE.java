package cfp35.objetosnoche.tpfinal.tickersec.test.entities;

import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;

public class TestCVE {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test CVE Entity ---");
        System.out.println();

        CVE cve = new CVE(
                            2,
                            "CVE-2024-6387",
                            "2024-07-01",
                            null,
                            Ticket_severities.ALTA,
                            8.1f,
                            "Se descubrió una regresión de seguridad (CVE-2006-5051) en el servidor de OpenSSH (sshd). Hay una condición de carrera que puede llevar a sshd a manejar algunas señales de manera insegura. Un atacante remoto no autenticado puede activarlo si no se autentica dentro de un período de tiempo establecido.",
                            "https://nvd.nist.gov/vuln/detail/CVE-2024-6387"
                        );

        System.out.println(cve);
        System.out.println("****************************************************************");
        System.out.println();
        cve.setLastUpdate("2024-07-04");
        System.out.println(cve);
    }
}
