package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Incident extends Ticket {
    private String srcips;
    private String dstips;
    private String srcports;
    private String dstports;
    private Integer reportId;

    public Incident(
            int id,
            Ticket_types type,
            String title,
            LocalDateTime createdAt,
            LocalDateTime lastUpdate,
            String resolution,
            Ticket_severities severity,
            Ticket_impacts impact,
            Integer category,
            String srcIPs,
            String dstIPs,
            String srcPorts,
            String dstPorts,
            Integer createdBy,
            Integer assignedTo,
            Ticket_status status,
            String resume,
            Integer reportId) {
        super(id, type, title, createdAt, lastUpdate, resolution, severity, impact, category, createdBy, assignedTo, status, resume);
        this.srcips = srcIPs;
        this.dstips = dstIPs;
        this.srcports = srcPorts;
        this.dstports = dstPorts;
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return this.type.getDisplayName() + this.id + " | Titulo: " + this.title + " | " + " | Categoría: "
                + this.category + "\n" +
                "Creación: " + this.createdAt + " | Actualizado: " + this.lastUpdate + " | Resolución: "
                + this.resolution + "\n" +
                "Severidad: " + this.severity + "| Impacto: " + this.impact + "\n" +
                "IPs de Origen: " + this.srcips + "\n" +
                "IPs de destino: " + this.dstips + "\n" +
                "Puertos de origen: " + this.srcports + "\n" +
                "Puertos de destino: " + this.dstports + "\n" +
                "Creado por: " + this.createdBy + " | Asignado a: " + this.assignedTo + " | Estado: " + this.status
                + "\n" +
                "ID de reporte: " + this.reportId + "\nResumen: " + this.resume + "\n";
    }
}