package cfp35.objetosnoche.tpfinal.tickersec.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class BusquedaTicket {
    String id;
    String type;
    String title;
    String createdAt;
    String severity;
    String impact;
    String category;
    String createdBy;
    String assignedTo;
    String status;
}
