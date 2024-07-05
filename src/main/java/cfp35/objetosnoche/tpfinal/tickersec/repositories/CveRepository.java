package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;


public class CveRepository {
    private final Connection conn = Connector.getConnection();

    public List<CVE> getAll() {
        List<CVE> list = new ArrayList<>();

        try (ResultSet rs = conn.createStatement().executeQuery("select * from cves")) {
        while (rs.next()) {
            list.add(new CVE(
                rs.getInt("id"),
                rs.getString("cveId"),
                rs.getDate("publishedDate").toLocalDate(),
                rs.getDate("lastUpdate").toLocalDate(),
                Ticket_severities.valueOf(rs.getString("severity")),
                rs.getFloat("cvss"),
                rs.getString("description"),
                rs.getString("urlRef")
            ));
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void save(CVE cve) {
        if (cve == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into cves (cveId,publishedDate,lastUpdate,severity,cvss,description,urlRef) values (?,?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) cve.setId(rs.getInt("id"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// TODO crear metodo save() y un metodo para mapear un json-cves y grabarlos en la DB.