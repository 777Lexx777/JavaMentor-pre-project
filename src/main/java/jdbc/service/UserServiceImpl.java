package jdbc.service;

import jdbc.dao.UserDaoJDBCImpl;
import jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        new UserDaoJDBCImpl().createUsersTable();
    }

    public void dropUsersTable() {
        new UserDaoJDBCImpl().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        new UserDaoJDBCImpl().saveUser( name,  lastName, age);
    }

    public void removeUserById(long id) {
        new UserDaoJDBCImpl().removeUserById(id);
    }

    public List<User> getAllUsers() {
        return new UserDaoJDBCImpl().getAllUsers();

    }

    public void cleanUsersTable() {
        new UserDaoJDBCImpl().cleanUsersTable();
    }
}
