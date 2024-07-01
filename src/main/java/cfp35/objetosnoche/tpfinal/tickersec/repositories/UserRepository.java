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

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from users")) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        User_roles.valueOf(rs.getString("role"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void save(User user) {
        if (user == null)
            return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into users (name,surname,email,role) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRole().toString());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) user.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Integer id){
        try (PreparedStatement ps=conn.prepareStatement("delete from users where id=?")){
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public User getById(int id){
        return getAll()
                        .stream()
                        .filter(user->user.getId()==id)
                        .findAny()
                        .orElse(new User());
    }
}

// TODO "Metodo delete, getLikeApellido, update"