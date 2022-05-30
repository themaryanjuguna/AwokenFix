package models;

import java.util.Objects;

public class User {
    public int id;
    private int employeeId;
    private String name;
    private String profile;
    private String position;
    private String role;

    //constructor id not included
    public User(int employeeId, String name, String profile, String position, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.profile = profile;
        this.position = position;
        this.role = role;
    }
    //constructor id included
    public User(int id, int employeeId, String name, String profile, String position, String role) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.profile = profile;
        this.position = position;
        this.role = role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
