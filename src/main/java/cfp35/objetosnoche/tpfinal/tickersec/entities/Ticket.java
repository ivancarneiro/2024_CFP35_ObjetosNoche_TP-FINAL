package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Integer id;
    private String title;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
    private LocalDateTime resolution;
    private Ticket_severities severity;
    private Ticket_impacts impact;
    private Integer category;
    private Integer createdBy;
    private Integer assignedTo;
    private Ticket_status status;
    private String resume;
    
    @Override
    public String toString() {
        return "Ticket Nro.: " + this.type + this.id +
                " | " + this.title +
                " | Categoría: " + this.category +
                " | Severidad: " + this.severity +
                " | Creado: " + this.createdAt +
                " | Actualizado: " + this.lastUpdate +
                " | Estado: " + this.status;
    }
}



