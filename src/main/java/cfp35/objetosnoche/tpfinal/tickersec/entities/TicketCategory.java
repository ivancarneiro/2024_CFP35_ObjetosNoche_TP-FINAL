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
    private Boolean activo;

    @Override
    public String toString() {
        return this.id + " | Categoría: " + this.category + " | Tipo: " + this.type + "\n Descripción: " + this.description + "\n";
    }
}
