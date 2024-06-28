package cfp35.objetosnoche.tpfinal.tickersec.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cfp35.objetosnoche.tpfinal.tickersec.connectors.Connector;
import cfp35.objetosnoche.tpfinal.tickersec.entities.User;
import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;

public class UserRepository {

    private Connection conn = Connector.getConnection();

    public void save(User user) {
        if (user == null)
            return;
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users (name,surname,email,role) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRole().toString());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                user.setId(rs.getInt(0));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<User> getAll() {
        List<User> list = new ArrayList();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from users")) {
            while (rs.next()) {
                list.add(new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("email"),
                    User_roles.valueOf(rs.getString("role"))
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}

// TODO "Metodo remove, getById, getLikeApellido, updateById"