package cfp35.objetosnoche.tpfinal.tickersec.test;

import cfp35.objetosnoche.tpfinal.tickersec.entities.User;
import cfp35.objetosnoche.tpfinal.tickersec.enums.User_roles;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.UserRepository;

public class TestUserRepository {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println("--- Metodo getAll() ---");
        userRepository.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println("____ Metodo save() ____");
        userRepository.save(new User(0,"Bastian","Carneiro","bastian@gmail.com",User_roles.ADMINISTRADOR));
        System.out.println("Se registro el usuario:");
        userRepository.save(new User(0,"Guadalupe","Acosta","gacosta@gmail.com",User_roles.OPERADOR));
        System.out.println("Se registro el usuario:");
        System.out.println(userRepository.getAll().getLast());
        System.out.println();
        
        System.out.println();
        System.out.println("____ Metodo getById() ____");
        System.out.println(userRepository.getById(2));
        System.out.println();
        System.out.println("____ Metodo remove() ____");
        System.out.println("    -> para la prueba se obtiene el id del ultimo objeto de la tabla user 'userRepository.getAll().getLast().getId()'\n");
        System.out.println("Se eliminó el usuario:");
        System.out.println(userRepository.getById(userRepository.getAll().getLast().getId()));
        userRepository.remove(userRepository.getAll().getLast().getId());
        System.out.println();
        System.out.println("____ Lista Users actualizada ____");
        userRepository.getAll().forEach(System.out::println);
    }
}