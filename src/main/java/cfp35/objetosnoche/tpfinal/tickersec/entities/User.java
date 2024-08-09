package cfp35.objetosnoche.tpfinal.tickersec.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    @NotNull
    @Size(min=3, max=50, message="Debe conetener entre 3 y 50 caracteres.")
    private String name;
    @NotNull
    @Size(min=3, max=50, message="Debe conetener entre 3 y 50 caracteres.")
    private String surname;
    @NotNull
    @Email
    @Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    private User_roles role;
    private Boolean activo;

    @Override
    public String toString() {
        return  "id: "+this.id+
                " | Nombre y Apellido: "+this.name+" "+this.surname+
                " | Email: "+this.email+
                " | Rol: "+this.role+
                " | Estado: "+this.activo;
    }
}

