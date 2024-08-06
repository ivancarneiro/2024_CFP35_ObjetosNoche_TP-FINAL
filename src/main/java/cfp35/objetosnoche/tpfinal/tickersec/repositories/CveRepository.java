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
        String selectCves = "select * from cves";
        try (ResultSet rs = conn.createStatement().executeQuery(selectCves)) {
        while (rs.next()) {
            list.add(new CVE(
                rs.getInt("id"),
                rs.getString("cveId"),
                rs.getString("publishedDate"),
                rs.getString("lastUpdate"),
                Ticket_severities.valueOf(rs.getString("severity")),
                Float.valueOf(rs.getString("cvss")),
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
        String saveSql = "insert into cves (cveId,publishedDate,lastUpdate,severity,cvss,description,urlRef) values (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(saveSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cve.getCveId());
            ps.setString(2, cve.getPublishedDate());
            ps.setString(3, cve.getLastUpdate());
            ps.setString(4,cve.getSeverity().toString());
            ps.setString(5, cve.getCvss().toString());
            ps.setString(6, cve.getDescription());
            ps.setString(7, cve.getUrlRef());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) cve.setId(rs.getInt("id"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// TODO crear metodo para mapear json-cves y grabarlos en la DB.