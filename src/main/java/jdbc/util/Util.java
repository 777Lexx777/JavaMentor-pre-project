package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД



    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geodata?serverTimezone=Europe/Moscow",
                    "root", "root");
            System.out.println(" Connection - ok");
            //if(saveUser(String name, String lastName, byte age)
            //System.out.println(" User с именем – name добавлен в базу данных");
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong during establishing DB connection");
        }
        return connection;
    }

}
