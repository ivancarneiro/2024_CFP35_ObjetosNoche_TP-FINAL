package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.CVE;
import cfp35.objetosnoche.tpfinal.tickersec.entities.FilterCVE;
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
                        LocalDate.parse(rs.getString("publishedDate")),
                        LocalDate.parse(rs.getString("lastModified")),
                        // null,
                        Ticket_severities.valueOf(rs.getString("severity")),
                        Float.valueOf(rs.getString("cvss")),
                        rs.getString("description"),
                        rs.getString("urlRef")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Collections.sort(list);

        return list;
    }

    public void save(CVE cve) {
        if (cve == null)
            return;
        String saveSql = "insert into cves (cveId,publishedDate,lastModified,severity,cvss,description,urlRef) values (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(saveSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cve.getCveId());
            ps.setString(2, cve.getPublishedDate().toString());
            ps.setString(3, cve.getLastModified().toString());
            ps.setString(4, cve.getSeverity().toString());
            ps.setString(5, cve.getCvss().toString());
            ps.setString(6, cve.getDescription());
            ps.setString(7, cve.getUrlRef());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                cve.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<CVE> getLikeCveId(String cveId) {
        if (cveId == null)
            return new ArrayList<>();
        return getAll()
                .stream()
                .filter(cve -> cve.getCveId().toUpperCase().contains(cveId.toUpperCase()))
                .toList();
    }

    public CVE getByCveId(String cveId) {
        return getAll()
                .stream()
                .filter(cve -> cve.getCveId().equals(cveId))
                .findAny()
                .orElse(new CVE());
    }

    public List<CVE> getCvesFiltered(FilterCVE filter) {
        return getAll().stream()
                .filter(cve -> ((filter.getBuscar() == null || filter.getBuscar().isEmpty()) || cve.getCveId().toLowerCase().contains(filter.getBuscar().toLowerCase())))
                .collect(Collectors.toList());
    }
}