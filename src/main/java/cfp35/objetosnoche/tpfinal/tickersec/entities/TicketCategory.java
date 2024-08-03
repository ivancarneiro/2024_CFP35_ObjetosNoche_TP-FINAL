package cfp35.objetosnoche.tpfinal.tickersec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCategory {
    private int id;
    private String category;
    private String type;
    private String description;

    @Override
    public String toString() {
        return this.id + " | " + this.category + " | " + this.type + " | " + this.description;
    }
}
