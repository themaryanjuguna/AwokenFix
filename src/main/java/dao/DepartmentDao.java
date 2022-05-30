package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {

    //CREATE: save department information


    void save(Department department);

    // list all departments
    List<Department> findAll();


    //delete a department
    void delete(int id);

    //delete all departments
    void clearAll();

}
