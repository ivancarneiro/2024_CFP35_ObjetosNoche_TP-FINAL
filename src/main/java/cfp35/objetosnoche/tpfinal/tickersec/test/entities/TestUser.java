package cfp35.objetosnoche.tpfinal.tickersec.test.entities;

import cfp35.objetosnoche.tpfinal.tickersec.entities.User;
import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;

public class TestUser {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Test User Entity ---");
        System.out.println();

        User user5 = new User(5, "Guadalupe","Acosta","gacosta@gmail",User_roles.OPERADOR,true);
        System.out.println(user5);
        System.out.println();

        System.out.println("-- Update User Role ---");
        user5.setRole(User_roles.ADMINISTRADOR);
        System.out.println(user5);
        System.out.println();

        System.out.println("-- Get User Email ---");
        System.out.println(user5.getEmail());

        System.out.println("-- Get User Role ---");
        System.out.println(user5.getRole());
    }
}
