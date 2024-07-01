package cfp35.objetosnoche.tpfinal.tickersec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCategorie {
    private Integer id;
    private String clasification;
    private String category;
    private String description;
}
