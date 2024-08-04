package cfp35.objetosnoche.tpfinal.tickersec.entities;


import java.time.Duration;
import java.time.LocalDateTime;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategoryRepository;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    Integer id;
    String title;
    Ticket_types type;
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
     * @param title
     * @param type
     * @param createdAt
     * @param lastUpdate
     * @param severity
     * @param impact
     * @param category
     * @param createdBy
     * @param assignedTo
     * @param status
     * @param resume
     */
    public Ticket(Integer id, String title, Ticket_types type, LocalDateTime createdAt, LocalDateTime lastUpdate,
            Ticket_severities severity, Ticket_impacts impact, Integer category,
            Integer createdBy, Integer assignedTo, Ticket_status status, String resume) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.severity = severity;
        this.impact = impact;
        this.category = category;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.status = status;
        this.resume = resume;
        
        if(this.status == Ticket_status.CERRADO){
            Long minutos, horas, dias;
            Duration resolucion = Duration.between(createdAt, lastUpdate);
            minutos = resolucion.getSeconds()/60;
            horas = minutos /60;
            minutos = minutos % 60;
            dias = horas / 24;
            horas = horas % 24;

            this.resolution = dias + "dias : " + horas+ "horas : " + minutos + "minutos"; 
        }

        if (assignedTo == null){this.assignedTo = this.createdBy;}
    }

    private UserRepository userRepository = new UserRepository();
    private TicketCategoryRepository categoryRepository = new TicketCategoryRepository();
    @Override
    public String toString() {
        return  this.id + " | Tipo: " + this.type.getDisplayName() + " | Creado: " + this.createdAt + " | Actualizado: " + this.lastUpdate + "\n" +
                this.title  + " | Categoría: " + categoryRepository.getById(this.category).getCategory() +" - "+ categoryRepository.getById(this.category).getType() + "\n" +
                "Severidad: " + this.severity + " | Impacto: " + this.impact + "\n" +
                "Estado: " + this.status + " | Resolución: " + this.resolution + "\n" +
                "Creado: " + userRepository.getById(this.createdBy).getSurname() + " | Asignado a: " + userRepository.getById(this.assignedTo).getSurname() + "\n" +
                "Resumen: " + this.resume + "\n";
    }
}



