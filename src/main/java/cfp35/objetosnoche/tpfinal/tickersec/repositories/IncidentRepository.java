package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.Incident;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;

public class IncidentRepository {

    private final Connection conn = Connector.getConnection();

    /**
     * @return Devuelve una lista de todos los tickets incidentes.
     */
    public List<Incident> getAll() {
        List<Incident> list = new ArrayList<>();
        String selectIncidents = "select * from incidents join tickets on incidents.ticketId = tickets.id";
        try (ResultSet rs = conn.createStatement().executeQuery(selectIncidents)) {
            while (rs.next()) {
                list.add(new Incident(
                    rs.getInt("id"),
                    Ticket_types.valueOf(rs.getString("type")),
                    rs.getString("title"),
                    rs.getTimestamp("createdAt").toLocalDateTime(),
                    rs.getTimestamp("lastUpdate").toLocalDateTime(),
                    rs.getString("resolution"),
                    Ticket_severities.valueOf(rs.getString("severity")),
                    Ticket_impacts.valueOf(rs.getString("impact")),
                    rs.getInt("category"),
                    rs.getString("srcip"),
                    rs.getString("dstip"),
                    rs.getString("srcport"),
                    rs.getString("dstport"),
                    rs.getInt("createdBy"),
                    rs.getInt("assignedTo"),
                    Ticket_status.valueOf(rs.getString("status")),
                    rs.getString("resume"),
                    rs.getInt("reportId")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * @param id
     * @return Devuelve un objeto Ticket Incident cuyo incidentId es igual al valor pasado como parámetro.
     */
    public Incident getById(String incidentId) {
        return getAll()
                .stream()
                .filter(incident -> (incident.getType().getDisplayName()+incident.getId()).equals(incidentId))
                .findAny()
                .orElseThrow();
    }
}
