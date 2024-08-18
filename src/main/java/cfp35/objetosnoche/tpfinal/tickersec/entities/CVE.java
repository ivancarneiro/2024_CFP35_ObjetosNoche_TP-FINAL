package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDate;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVE implements Comparable<CVE>{
    private int id;
    private String cveId;
    private LocalDate publishedDate;
    private LocalDate lastModified;
    private Ticket_severities severity;
    private Float cvss;
    private String description;
    private String urlRef;

    @Override
    public String toString() {
        return  this.cveId+ " - Publicado: "+this.publishedDate+ " - Actualizado: "+this.lastModified+
                "\nSeveridad: "+this.severity.name()+
                " - "+this.cvss+
                "\nDescripción: "+this.description+
                "\nReferencia: "+this.urlRef +"\n";
    }

    @Override
    public int compareTo(CVE o) {
        return -1 * this.publishedDate.compareTo(o.publishedDate);
    }
}