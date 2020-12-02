package jdbc.dao;

import jdbc.model.User;
import jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    Transaction transaction = null;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE if not exists user"
                + "  (id           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + "   name         VARCHAR(45) NOT NULL,"
                + "   lastName     VARCHAR(45) NOT NULL,"
                + "   age          INT NOT NULL)";
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        System.out.println("Таблица создана");
        session.close();
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE if exists user";
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        System.out.println("Таблица удалена");
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        System.out.println("Юзер" + name + "Добавлен");
        session.save(new User(name, lastName, age));
        transaction.commit();
        session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        return session.createQuery("FROM User", User.class).list();
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("DELETE FROM user").executeUpdate();
        transaction.commit();
        System.out.println("Таблица очищена");
        session.close();
    }
}
