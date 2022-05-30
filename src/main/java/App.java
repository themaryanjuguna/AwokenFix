import com.google.gson.Gson;
import dao.*;
import models.Department;
import models.News;
import models.User;

import static spark.Spark.*;


public class App {

    public static void main(String[] args) {

        Gson gson = new Gson();
        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(DB.sql2o);
        Sql2oUserDao sql2oUserDao= new Sql2oUserDao(DB.sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(DB.sql2o);

        //add new Department
        post("/department/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            sql2oDepartmentDao.save(department);
            res.status(201);
            return gson.toJson(department);
        });

        //get department
        get("/Department", "application/json", (req, res) -> {
            return gson.toJson(sql2oDepartmentDao.findAll());
        });

        //add new User
        post("/User/new", "application/json", (req, res) -> {
            User user= gson.fromJson(req.body(), User.class);
            sql2oUserDao.save(user);
            res.status(201);
            return gson.toJson(user);
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });





    }

}
