package cfp35.objetosnoche.tpfinal.tickersec.entities;


import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVE {
    private Integer id;
    private String cveId;
    private String publishedDate;
    private String lastUpdate;
    private Ticket_severities severity;
    private Float cvss;
    private String description;
    private String urlRef;

    @Override
    public String toString() {
        return  this.cveId+ " - Publicado: "+this.publishedDate+ " - Actualizado: "+this.lastUpdate+
                "\nSeveridad: "+this.severity.name()+
                " - "+this.cvss+
                "\nDescripción:\n"+this.description+
                "\nReferencias: \n"+this.urlRef + "\n";
    }
}