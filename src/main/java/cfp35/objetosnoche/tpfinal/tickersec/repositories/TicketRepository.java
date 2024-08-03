package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.Ticket;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;

public class TicketRepository {
    private final Connection conn = Connector.getConnection();

    /**
     * @return Devuelve una lista de todos los tickets.
     */
    public List<Ticket> getAll() {
        List<Ticket> list = new ArrayList<>();
        String selectTickets = "select * from tickets";
        try (ResultSet rs = conn.createStatement().executeQuery(selectTickets)) {
            while (rs.next()) {
                list.add(new Ticket(
                    rs.getInt("id"),
                    rs.getString("title"),
                    Ticket_types.valueOf(rs.getString("type")),
                    rs.getTimestamp("createdAt").toLocalDateTime(),
                    rs.getTimestamp("lastUpdate").toLocalDateTime(),
                    Ticket_severities.valueOf(rs.getString("severity")),
                    Ticket_impacts.valueOf(rs.getString("impact")),
                    rs.getInt("category"),
                    rs.getInt("createdBy"),
                    rs.getInt("assignedTo"),
                    Ticket_status.valueOf(rs.getString("status")),
                    rs.getString("resume")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Ticket getById(int id) {
        return getAll()
                        .stream()
                        .filter(ticket -> ticket.getId() == id)
                        .findAny()
                        .orElseThrow();
    }

    
}
