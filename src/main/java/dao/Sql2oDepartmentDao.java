package dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {

    private Sql2oDepartmentDao departmentsDao;
    private Connection conn;
    private Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(Department departments){
        String sql = "INSERT INTO departments (name, profile) VALUES (:name, :profile)";
        try (Connection connection = sql2o.open()){
            int id = (int)connection.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException e) { System.out.println("e"); }
    }

    @Override
    public List<Department> findAll(){
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM departments")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Department.class);
        }
    }

}