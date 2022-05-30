# AWOKEN News Api

#### By **Maryanne Njuguna**

## Description
Awoken is a rest REST API for querying and retrieving scoped news and information.

## User Stories
As a user, you should be able to create the following objects:-
- Departments
- News:
    - General News (Information affecting the whole company)
    - Department news (Objects within Object)
- Users:
    - As a user you should see:
    - individual users, their details, i.e position in the company, their roles, which department(s) they are associated with etc
    - specific information such as the Departments name, description, number of employees in the department.
    - all users from a specific Department, the news relating to that department or a link to a page with said news (for tidiness).
    - As a user, you will be able to Post some news relating to a department.

## Known Bugs
Report any bugs by hovering to https://github.com/themaryanjuguna/Awoken/issues and create a new issue.

## Setup/Installation Requirements
* Internet connection
* access to a browser
* fork from https://github.com/themaryanjuguna/Awoken.git
* To use the postgres database run the create.sql script in the `create.sql` folder in the project directory or run the following:
* For testing use Postman desktop client to access the forked collection because their cloud client does not access local ports like `http://localhost:4567`.
* In postman replace where indicated :id the number with the id you want to use in the path variables
* Make sure you recreate the database in your local psql by running the psql commands above.

## In Terminal PSQL:
```
psql -U postgres
\l
\dt
* CREATE DATABASE awoken;
* \c awoken;
CREATE TABLE users(id serial PRIMARY KEY, name varchar, profile varchar, position varchar, role varchar);
CREATE TABLE news(id serial PRIMARY KEY, title varchar, content varchar);
CREATE TABLE departments(id serial PRIMARY KEY, name varchar, profile varchar);

CREATE DATABASE awoken_test WITH TEMPLATE awoken;
```

## Technologies Used
* IntelliJ IDEA
* Java
* Spark
* PostgreSql
* Postman:
    * Department
        * POST http://localhost:4567/department/new
        * GET http://localhost:4567/Department

    * User
        * POST http://localhost:4567/User/new
        * GET http://localhost:4567/User
    * News
        * POST http://localhost:4567/News/new
        * GET http://localhost:4567/News
        * DELETE http://localhost:4567/delete-News/:id

## Some sample endpoint responses using the News and user Objects

### Departments

```` 
#### Entry
{
"name":"HR",
"profile":"Manages Human Relations",
"deptId":id
}

#### Response
{"id":4,"name":"HR","profile":"Manages Human Relations","deptId":1}
````

### User
````
#### Entry
{
"employeeId":"1",
"name":"Tim",
"profile":"outspoken",
"position":"IT Manager",
"role":"Technician"
}

#### Response
{
"id": 1,
"employeeId": 1,
"name": "Tim",
"profile": "outspoken",
"position": "IT Manager",
"role": "Technician"
}
````

### News
````
#### Entry
`{
"id": 2,
"employeeId": 0,
"title": "Employee of the Month Award",
"content": "Award goes out to Tim"
}

#### Response
{
    "id": 3,
    "employeeId": 0,
    "title": "NHIF update",
    "content": "Award goes out to Tim"
}
````

## Author Details
Maryanne Njuguna [Linktree Profile](https://linktr.ee/themaryanjuguna)

### License
Licensed by MIT
Copyright (c) 2022 **themaryanjuguna**
