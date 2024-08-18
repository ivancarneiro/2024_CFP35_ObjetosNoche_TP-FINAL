package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.time.LocalDate;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterCVE {
    private String buscar;
    private String cveId;
    private LocalDate publishedDate;
    private LocalDate lastModified;
    private Ticket_severities severity;
    private Float cvss;
}
