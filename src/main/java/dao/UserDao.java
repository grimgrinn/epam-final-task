package dao;

import entity.*;
import connectionPool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
public class UserDao implements InterfaceDao<User>{
    public static final Logger MEGALOG = LogManager.getLogger(UserDao.class);

    @Override
    public List<User> get() { throw new NotImplementedException();    }

    @Override
    public void update(final User item) { throw new NotImplementedException(); }

    /**
     * Пользователь по id
     * @param id пользователя
     * @return пользователь
     */

    @Override
    public User getById(final int id){
        String select = "SELECT id, email, last_name, first_name, password WHERE id = ? LIMIT 1";
        ConnectionPool pool = ConnectionPool.getInstance();
        User result = null;

        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(
                     select,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY
             )
        ){
            ps.setInt(1, id);

            ArrayList<User> users = getUsers(ps);
            if(users.size() > 0){
                result = users.get(0);
            }
        } catch (SQLException e) {
            MEGALOG.error("connection error",e);
        }
        return result;
    }

    /**
     * Пользователь по логину
     * @param email пользователя
     * @return пользователь или null
     */
    public User getByEmail(final String email) {
        String select = "SELECT id, email, last_name, first_name, password FROM users WHERE email = ? LIMIT 1";
        ConnectionPool pool = ConnectionPool.getInstance();
        User result =  null;
        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(
                     select,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY
             )
        ){
            ps.setString(1, email);
            System.out.println("this is prepared statement -> "+ ps);

            ArrayList<User> users = getUsers(ps);
            if (users.size() > 0) {
                result = users.get(0);
            }
        } catch (SQLException e) {
            MEGALOG.error("connection error", e);
        }
        return result;
    }


    @Override
    public User create(final User item) {
        User newUser = null;
        String insert = "INSERT INTO users (email, last_name, first_name, password) VALUES (?, ?, ?, ?)";
        ConnectionPool pool = ConnectionPool.getInstance();
        try(Connection connection = pool.takeConnection();
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, item.getEmail());
            ps.setString(2, item.getLastName());
            ps.setString(3, item.getFirstName());
            ps.setString(4, item.getPassword());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int newId = rs.getInt(1);
                    newUser = new User(newId, item.getFirstName(), item.getLastName(), item.getPassword(), item.getEmail());
                }
            }

        } catch (SQLException e) {
            MEGALOG.error("connection error", e);
        }
        return newUser;
    }

    /**
     * Удаляет пользователя
     * @param id пользователя
     */
    @Override
    public void delete(final int id) {
        throw new NotImplementedException();
    }

    /**
     * Заполняет коллекцию объектов из PreparedStatement
     * @param ps PreparedStatement
     * @return массив юзеров
     * @throws SQLException
     */
    private ArrayList<User> getUsers(PreparedStatement ps) throws SQLException {
        ArrayList<User> result = new ArrayList<>();

        System.out.println("trying to execute sql query SELECT id, email, last_name, first_name, password WHERE email = ? LIMIT 1 where prepared statement is -> " + ps );
        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("now in th try block, this is id, that database returns -> " + id);
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                //int groupId = rs.getInt("group_id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                //GroupDao groupDao = new GroupDao();
                //Group group = groupDao.getById(groupId);
                result.add(new User(id, email, last_name, first_name, password ));
            }
        }
        System.out.println("if we here everything ok and this is result -> " + result);
        return result;
    }




}
