package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.User;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Entity_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;

public class UserRepository {

    private final Connection conn = Connector.getConnection();

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String selectUsers = "select * from users";
        try (ResultSet rs = conn.createStatement().executeQuery(selectUsers)) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        User_roles.valueOf(rs.getString("role")),
                        Entity_status.valueOf(rs.getString("status"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<User> usuariosHabilitados() {
        List<User> list = new ArrayList<>();
        String selectHabilitado = "select * from users where status='HABILITADO";
        try (ResultSet rs = conn.createStatement().executeQuery(selectHabilitado)) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        User_roles.valueOf(rs.getString("role")),
                        Entity_status.valueOf(rs.getString("status"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void save(User user) {
        if (user == null)
            return;
        String saveUser = "insert into users (name,surname,email,role) values (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(saveUser, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRole().toString());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                user.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println("*** NO SE PUDO REGSITRAR EL USURAIO ***");
            System.out.println(e);
        }
    }

    public void remove(Integer id) {
        // El metodo remove() no elimina al usuario sino que lo deshabilita de la vista
        // normal.
        // Por cuestiones de auditoria ningun usuario creado se eliminará una vez
        // creado.
        String removeUser = "update users set status='NOHABILITADO' where id=?";
        try (PreparedStatement ps = conn.prepareStatement(removeUser)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param id
     * @return Devuelve un objeto User cuyo id es igual al valor pasado como parámetro.
     */
    public User getById(int id) {
        return getAll()
                .stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(new User());
    }

    /**
     * @param apellido
     * @return Devuelve una lista de usuarios cuyo apellido contiene el valor pasado como parámetro.
     */
    public List<User> getLikeApellido(String apellido) {
        if (apellido == null)
            return new ArrayList<>();
        return getAll()
                .stream()
                .filter(user -> user.getSurname().toLowerCase().contains(apellido.toLowerCase()))
                .toList();
    }

    /**
     * Permite actualizar los valores de los atributos (email, role o status).
     * Se debe proporcionar de forma obligatoria el id y al menos un valor de algún atribut
     * @param id
     * @param email
    * @param role -> Enun (ADMINISTRADOR, OPERADOR, VEEDOR)
     * @param status -> Enun (HABILITADO, NOHABILITADO)
     */
    public void update(Integer id, String email, String role, String status) {
        
        if ((email == null || "".equals(email)) && (role == null || "".equals(role)) && (status == null || "".equals(status))) {
            System.out.println("Error: Debes proporcionar al menos un atributo para actualizar.");
            return;
        }

        StringBuilder updateQuery = new StringBuilder("UPDATE users SET ");
        List<String> updateColumns = new ArrayList<>();

        if (email != null) {
            updateColumns.add("email = ?");
        }
        if (role != null) {
            updateColumns.add("role = ?");
        }
        if (status != null) {
            updateColumns.add("status = ?");
        }

        updateQuery.append(String.join(", ", updateColumns));
        updateQuery.append(" WHERE id = ?");

        try (PreparedStatement ps = conn.prepareStatement(updateQuery.toString())) {
            int paramIndex = 1;

            if (email != null) {
                ps.setString(paramIndex++, email);
            }
            if (role != null) {
                ps.setString(paramIndex++, role);
            }
            if (status != null) {
                ps.setString(paramIndex++, status);
            }

            ps.setInt(paramIndex, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado correctamente.");
                System.out.println(getById(id));
            } else {
                System.out.println("Error al actualizar el usuario o usuario no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta de actualización.");
            System.out.println(e);
        }
    }

}