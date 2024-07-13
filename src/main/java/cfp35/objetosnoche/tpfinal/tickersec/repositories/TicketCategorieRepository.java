package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategorie;

/**
 * Repositorio para administrar las categorías de ticket.
 */
public class TicketCategorieRepository {

    private final Connection conn = Connector.getConnection();

    /**
     * @return Devuelve una lista de todas las categorías de ticket registradas.
     */
    public List<TicketCategorie> getAll() {
        List<TicketCategorie> list = new ArrayList<>();
        String selectCategories = "select * from ticket_categories";
        try (ResultSet rs = conn.createStatement().executeQuery(selectCategories)) {
            while (rs.next()) {
                list.add(new TicketCategorie(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("type"),
                        rs.getString("description")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * @param id
     * @return Devuelve un objeto TicketCategorie cuyo id es igual al valor pasado como parámetro.
     */
    public TicketCategorie getById(int id) {
        return getAll()
                .stream()
                .filter(tkCategory -> tkCategory.getId() == id)
                .findAny()
                .orElseThrow();
    }

    /**
     * @param tipo
     * @return Devuelve una lista de categorias de ticket donde el tipo contiene el valor pasado como parámetro.
     */
    public List<TicketCategorie> getLikeType(String tipo) {
        return getAll()
                .stream()
                .filter(tkCategory -> tkCategory.getType().toLowerCase().contains(tipo.toLowerCase()))
                .toList();
    }


    public void save(TicketCategorie tkCategory) {
        if (tkCategory == null) return;
        String saveCategory = "insert into ticket_categories (category, type, description) values (?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(saveCategory, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, tkCategory.getCategory());
            ps.setString(2, tkCategory.getType());
            ps.setString(3, tkCategory.getDescription());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                tkCategory.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println("*** NO SE PUDO REGSITRAR EL LA NUEVA CATEGORÍA DE TICKET ***");
            System.out.println(e);
        }
    }

    public void remove(Integer id) {
        String removeCategory = "delete from ticket_categories where id=?";
        try (PreparedStatement ps = conn.prepareStatement(removeCategory)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("*** NO SE PUDO ELIMINAR LA CATEGORÍA DE TICKET ***");
            System.out.println(e);
        }
    }
}
