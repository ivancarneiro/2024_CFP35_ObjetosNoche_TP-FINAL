package cfp35.objetosnoche.tpfinal.tickersec.entities;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Entity_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;
import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private User_roles role;
    private Entity_status status;

    public User(int id, String name, String surname, String email, User_roles role) {
        this.id = id;
        this.name = name ;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.status = Entity_status.ENABLED;
    }

    @Override
    public String toString() {
        return  "id: "+this.id+
                " | Nombre y Apellido: "+this.name+" "+this.surname+
                " | Email: "+this.email+
                " | Rol: "+this.role+
                " | Estado: "+this.status.name();
    }
}

