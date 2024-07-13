package cfp35.objetosnoche.tpfinal.tickersec.test.repositories;

import cfp35.objetosnoche.tpfinal.tickersec.repositories.UserRepository;

public class TestUserRepository {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println("--- Metodo getAll() ---");
        userRepository.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("____ Metodo save() ____");
        // userRepository.save(new User(0,"Bastian","Carneiro","bastian@gmail.com",User_roles.ADMINISTRADOR,Entity_status.HABILITADO));
        // userRepository.save(new User(0,"Guadalupe","Acosta","gacosta@gmail.com",User_roles.OPERADOR,Entity_status.HABILITADO));
        System.out.println();
        
        System.out.println("____ Metodo getById() ____");
        // System.out.println("--> obtenemos usuario con id=2");
        System.out.println(userRepository.getById(5));
        System.out.println();

        System.out.println("____ Metodo remove() ____");
        System.out.println("-> para la prueba se obtiene el id del ultimo usurio de la tabla users mediante 'userRepository.getAll().getLast().getId()'\n");
        System.out.println("Se eliminó el usuario:");
        userRepository.remove(userRepository.getAll().getLast().getId());
        System.out.println(userRepository.getById(userRepository.getAll().getLast().getId()));
        System.out.println("--> los usuarios no se eliminan de la BD solo se deshabilitan, ya que la restricción de ForeingKey está habilitada y generária un error de lo contrario");
        System.out.println();

        System.out.println("____ Lista Users actualizada ____");
        userRepository.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("____ Metodo getLikeApellido() ____");
        userRepository.getLikeApellido("car").forEach(System.out::println);
        System.out.println();

        System.out.println("____ Metodo update() ____");
        // userRepository.update(null, null, null, null);
        userRepository.update(5, null, "OPERADOR", "HABILITADO");
        System.out.println();

        System.out.println("____ Lista Users actualizada ____");
        userRepository.getAll().forEach(System.out::println);
        System.out.println();
    }
}