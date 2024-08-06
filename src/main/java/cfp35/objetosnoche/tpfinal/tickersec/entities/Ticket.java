package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.Duration;
import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    int id;
    Ticket_types type;
    String title;
    LocalDateTime createdAt;
    LocalDateTime lastUpdate;
    String resolution;
    Ticket_severities severity;
    Ticket_impacts impact;
    Integer category;
    Integer createdBy;
    Integer assignedTo;
    Ticket_status status;
    String resume;

    /**
     * @param id
     * @param type
     * @param title
     * @param createdAt
     * @param lastUpdate
     * @param resolution2
     * @param severity
     * @param impact
     * @param category
     * @param createdBy
     * @param assignedTo
     * @param status
     * @param resume
     */
    public Ticket(
            int id,
            Ticket_types type,
            String title,
            LocalDateTime createdAt,
            LocalDateTime lastUpdate,
            String resolution,
            Ticket_severities severity,
            Ticket_impacts impact,
            Integer category,
            Integer createdBy,
            Integer assignedTo,
            Ticket_status status,
            String resume) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.severity = severity;
        this.impact = impact;
        this.category = category;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.status = status;
        this.resume = resume;

        if (this.status == Ticket_status.CERRADO) {
            Long minutos, horas, dias;
            Duration resolucion = Duration.between(createdAt, lastUpdate);
            minutos = resolucion.getSeconds() / 60;
            horas = minutos / 60;
            minutos = minutos % 60;
            dias = horas / 24;
            horas = horas % 24;

            this.resolution = dias + "dias : " + horas + "horas : " + minutos + "minutos";
        }

        if (assignedTo == null) {
            this.assignedTo = this.createdBy;
        }
    }

    @Override
    public String toString() {
        return this.type.getDisplayName() + this.id + " | Creado: " + this.createdAt + " | Actualizado: "
                + this.lastUpdate + "\n" +
                this.title + " | Categoría: " + this.category + "\n" +
                "Severidad: " + this.severity + " | Impacto: " + this.impact + "\n" +
                "Estado: " + this.status + " | Resolución: " + this.resolution + "\n" +
                "Creado: " + this.createdBy + " | Asignado a: " + this.assignedTo + "\n" +
                "Resumen: " + this.resume + "\n";
    }
}
