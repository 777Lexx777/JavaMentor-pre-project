package jdbc;

import jdbc.service.UserServiceImpl;
import jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        //метод добавления таблицы
        userServiceImpl.createUsersTable();

        //метод удаления таблицы
        userServiceImpl.dropUsersTable();

        //методы записи users в созданную таблицу
        userServiceImpl.saveUser("Tim", "Tog", (byte) 20);
        userServiceImpl.saveUser("Tom", "Tog", (byte) 20);
        userServiceImpl.saveUser("Toni", "Tog", (byte) 20);
        userServiceImpl.saveUser("Timi", "Tog", (byte) 20);

        //метод удаления user по Id
        userServiceImpl.removeUserById(20);

        // Метод получения всех данных из таблицы
        System.out.println(userServiceImpl.getAllUsers());

        //метод удвления данных из таблицы
        userServiceImpl.cleanUsersTable();

    }
}
