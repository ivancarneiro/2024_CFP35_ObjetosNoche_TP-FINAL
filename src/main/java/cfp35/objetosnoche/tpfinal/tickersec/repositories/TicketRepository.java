package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                    Ticket_types.valueOf(rs.getString("type")),
                    rs.getString("title"),
                    rs.getTimestamp("createdAt").toLocalDateTime(),
                    rs.getTimestamp("lastUpdate").toLocalDateTime(),
                    rs.getString("resolution"),
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

    public void save(Ticket ticket){
        if(ticket==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "INSERT INTO tickets (title, type, createdAt, lastUpdate, severity, impact, category, createdBy, assignedTo, status, resume) VALUES (?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, ticket.getTitle());
            ps.setString(2, ticket.getType().name());
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(ticket.getCreatedAt()));
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(ticket.getLastUpdate()));
            ps.setString(5, ticket.getSeverity().name());
            ps.setString(6, ticket.getImpact().name());
            ps.setInt(7, ticket.getCategory());
            ps.setInt(8, ticket.getCreatedBy());
            ps.setInt(9, ticket.getAssignedTo());
            ps.setString(10, ticket.getStatus().name());
            ps.setString(11, ticket.getResume());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) ticket.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Ticket getById(int id) {
        return getAll()
                        .stream()
                        .filter(ticket -> ticket.getId() == id)
                        .findAny()
                        .orElse(new Ticket());
    }

    public List<Ticket> getLikeTitulo(String titulo) {
        if (titulo == null) return new ArrayList<>();
        return getAll()
                .stream()
                .filter(ticket -> ticket.getTitle().toLowerCase().contains(titulo.toLowerCase()))
                .toList();
    }
}