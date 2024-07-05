package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDate;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVE {
    private int id;
    private String cveId;
    private LocalDate publishedDate;
    private LocalDate lastUpdate;
    private Ticket_severities severity;
    private Float cvss;
    private String description;
    private String urlRef;

    @Override
    public String toString() {
        return  this.cveId+ " - Publicado: "+this.publishedDate+ " - Actualizado: "+this.lastUpdate+
                "\nSeveridad: "+this.severity.name()+
                " - "+this.cvss+
                "\n\nDescripción:\n"+this.description+
                "\n\nReferencia: "+this.urlRef;
    }
}