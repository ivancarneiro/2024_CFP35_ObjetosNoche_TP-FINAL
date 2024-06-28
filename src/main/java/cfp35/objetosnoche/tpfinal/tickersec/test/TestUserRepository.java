package cfp35.objetosnoche.tpfinal.tickersec.test;

import cfp35.objetosnoche.tpfinal.tickersec.entities.User;
import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.UserRepository;

public class TestUserRepository {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println();
        // System.out.println("--- Metodo save() ---");
        // User user6 = new User(0,"Bastian","Carneiro","bastian@gmail.com",User_roles.ADMINISTRADOR);
        // userRepository.save(user6);
        // System.out.println(user6);

        System.out.println("--- Metodo getAll() ---");
        userRepository.getAll().forEach(System.out::println);
    }
}