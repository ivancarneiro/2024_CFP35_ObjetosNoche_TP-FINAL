package cfp35.objetosnoche.tpfinal.tickersec.entities;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterTicket {
    Ticket_types type;
    Ticket_severities severity;
    Ticket_impacts impact;
    Integer category;
    Integer createdBy;
    Integer assignedTo;
    Ticket_status status;
}