import com.google.gson.Gson;
import dao.*;
import models.ApiException;
import models.Department;
import models.News;
import models.User;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {

    public static void main(String[] args) {

        Gson gson = new Gson();
        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(DB.sql2o);
        Sql2oUserDao sql2oUserDao= new Sql2oUserDao(DB.sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(DB.sql2o);


      /*  Department hr = new Department("hr","mange",1);
        sql2oDepartmentDao.save(hr);

        System.out.println(hr);
*/


        //add new Department
        post("/department/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            if (department.getName().equals("") || department.getProfile().equals("") || department.getDeptId()<=0){
                throw new ApiException(404,"The fields Cannot be Empty");
            }
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

        //get User
        get("/User", "application/json", (req, res) -> {
            return gson.toJson(sql2oUserDao.findAll());
        });

        //add new News
        post("/News/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            sql2oNewsDao.save(news);
            res.status(201);
            return gson.toJson(news);
        });

        //get News
        get("/News", "application/json", (req, res) -> {
            return gson.toJson(sql2oNewsDao.allNews());
        });

        get("/delete-News/:id", (req, res) -> {
            int News_id = Integer.parseInt(req.params(":id"));
            sql2oNewsDao.delete(News_id);
            return gson.toJson(sql2oNewsDao.allNews());
        });



        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

    }

}
