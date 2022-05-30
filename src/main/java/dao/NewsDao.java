package dao;

import models.News;

import java.util.List;

public interface NewsDao {
    //create news
    void save(News news);

    List<News> allNews();

    News findById(int id);
    List<News> allDepartmentNews(int Id);

    void delete(int id);
    void deleteAll();
}
