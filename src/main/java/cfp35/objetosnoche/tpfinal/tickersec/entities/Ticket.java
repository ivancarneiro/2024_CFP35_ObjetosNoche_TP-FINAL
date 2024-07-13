package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDateTime;

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
    private Ticket_severities severity;
    private Integer category;
    private Ticket_status status;
    
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



