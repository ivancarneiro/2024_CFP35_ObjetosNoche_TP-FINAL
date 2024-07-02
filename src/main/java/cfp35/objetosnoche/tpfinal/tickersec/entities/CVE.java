package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVE {
    private int id;
    private String cveId;
    private LocalDate publishedDate;
    private LocalDate lastUpdate;
    private String severity;
    private Float cvss;
    private String description;
    private String urlRef;
}