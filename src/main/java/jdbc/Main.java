package jdbc;

import jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        //метод удаления таблицы
        userServiceImpl.dropUsersTable();

        //метод добавления таблицы
        userServiceImpl.createUsersTable();

        //методы записи users в созданную таблицу
        userServiceImpl.saveUser("Tim", "Tog", (byte) 20);
        userServiceImpl.saveUser("Tom", "Tog", (byte) 20);
        userServiceImpl.saveUser("Toni", "Tog", (byte) 20);
        userServiceImpl.saveUser("Timi", "Tog", (byte) 20);

        // Метод получения всех данных из таблицы
        for (int i = 0; i < userServiceImpl.getAllUsers().size(); i++) {
            System.out.println(userServiceImpl.getAllUsers().get(i));
        }
        // метод удаления user по Id
        userServiceImpl.removeUserById(2);

        // метод удвления данных из таблицы
        userServiceImpl.cleanUsersTable();

    }
}
