package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private Integer id;
    private String title;
    private LocalDateTime createdAt;
    private User createdBy;
    private String description;
}
