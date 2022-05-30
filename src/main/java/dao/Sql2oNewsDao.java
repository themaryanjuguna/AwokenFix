package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    private Sql2oNewsDao newsDao;
    private Connection conn;

    private static Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void save(News news){
        String sql = "INSERT INTO news (title, content) VALUES (:title, :content)";
        try (Connection connection = sql2o.open()){
            int id = (int)connection.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException e) { System.out.println("save news");}
    }

    public List<News> allNews(){
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(News.class);
        }
    }

    public News findById(int id){
        String sql = "SELECT * FROM news WHERE id = :id";
        try(Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public List<News> allDepartmentNews(int Id){
        try (Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM news")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void delete(int id){
        String sql = "DELETE FROM news WHERE id = :id";
        try (Connection connection = sql2o.open()){
            connection.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {System.out.println("e"); }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM news";
        try (Connection connection = sql2o.open()){
            connection.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){ System.out.println("e");}
    }
}