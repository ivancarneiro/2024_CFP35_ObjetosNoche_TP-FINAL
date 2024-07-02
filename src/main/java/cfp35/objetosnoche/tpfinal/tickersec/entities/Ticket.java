package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategorie;


@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Integer id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
    private LocalDateTime resolution;
    private Ticket_severities severity;
    private Ticket_impacts impact;
    private Integer category;
    private Integer createdBy;
    private Integer assignedTo;
    
    @Override
    public String toString() {
        return "Ticket Nro.: " + this.id +
                "\n" + this.title +
                "\nCreado: " + this.createdAt +
                "\nÚltima actualización: " + this.lastUpdate +
                "\nResolución: " + this.resolution +
                "\nSeveridad: " + this.severity +
                "\nImpacto: " + this.impact +
                "\nCategoría: " + this.category +
                "\nCreado por: " + this.createdBy +
                "\nAsignado a: " + this.assignedTo;
    }
}



