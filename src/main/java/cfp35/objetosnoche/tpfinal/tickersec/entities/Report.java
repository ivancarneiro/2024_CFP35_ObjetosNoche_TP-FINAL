package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Report {
    private Integer id;
    private String title;
    private Date createdAt;
    private User createdBy;
    private String description;
}
