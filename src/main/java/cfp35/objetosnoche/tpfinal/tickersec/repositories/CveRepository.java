package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;


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
                rs.getString("severity"),
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
}

// TODO crear metodo save() y un metodo para mapear un json-cves y grabarlos en la DB.