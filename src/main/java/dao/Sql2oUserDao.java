package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    //
    private Sql2oUserDao userDao;
    private Connection conn;
    private Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(User users) {
        String sql = "INSERT INTO users (name, profile, position, role) VALUES (:name, :profile, :position, :role)";
        try (Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException e) {
            System.out.println("user");
        }
    }



    public List<User> findAll() {

        String sql = "SELECT * FROM users";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User findById(int id) {

        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM users")
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public User allUsersInADepartment(int Id) {

        try (Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM users WHERE Id = :Id")
                    .addParameter("Id",Id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println("e");
        }

    }

    @Override
    public void clearAll(){
        String sql = "DELETE FROM users";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println("e");
        }

    }
}

