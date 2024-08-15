package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.FilterCategory;
import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategory;

/**
 * Repositorio para administrar las categorías de ticket.
 */
public class TicketCategoryRepository {

    private final Connection conn = Connector.getConnection();

    /**
     * @return Devuelve una lista de todas las categorías de ticket registradas.
     */
    public List<TicketCategory> getAll() {
        List<TicketCategory> list = new ArrayList<>();
        String selectCategories = "select * from ticket_categories where activo=true";
        try (ResultSet rs = conn.createStatement().executeQuery(selectCategories)) {
            while (rs.next()) {
                list.add(new TicketCategory(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("type"),
                        rs.getString("description"),
                        rs.getBoolean("activo")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void save(TicketCategory tkCategory) {
        if (tkCategory == null)
            return;
        String saveCategory = "insert into ticket_categories (category, type, description, activo) values (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(saveCategory, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, tkCategory.getCategory());
            ps.setString(2, tkCategory.getType());
            ps.setString(3, tkCategory.getDescription());
            ps.setBoolean(4, tkCategory.getActivo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                tkCategory.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println("*** NO SE PUDO REGSITRAR LA NUEVA CATEGORÍA DE TICKET ***");
            System.out.println(e);
        }
    }

    public void removeCategory(Integer categoryId) {
        if (categoryId != null) {
            getById(categoryId).setActivo(false);
        }
    }

    /**
     * @param id
     * @return Devuelve un objeto TicketCategory cuyo id es igual al valor pasado
     *         como parámetro.
     */
    public TicketCategory getById(int id) {
        return getAll()
                .stream()
                .filter(tkCategory -> tkCategory.getId() == id)
                .findAny()
                .orElseThrow();
    }

    public List<TicketCategory> getCategoryFiltered(FilterCategory filter) {
        return getAll()
                .stream()
                .filter(category -> 
                    ((filter.getCategory() == null || filter.getCategory().isEmpty())|| category.getCategory().equals(filter.getCategory())) &&
                    ((filter.getType() == null || filter.getType().isEmpty()) || category.getType().equals(filter.getType())))
                .collect(Collectors.toList());
    }
}
