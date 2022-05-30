package models;

public class News {
    private int id;
    private int employeeId;
    private String title;
    private String content;


    public News() {
    }

    public News(int employeeId, String title, String content) {
        this.employeeId = employeeId;
        this.title = title;
        this.content = content;
    }

    public News(int id, int employeeId, String title, String content) {
        this.id = id;
        this.employeeId = employeeId;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
