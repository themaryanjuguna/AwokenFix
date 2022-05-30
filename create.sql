CREATE DATABASE awoken;
\c awoken;

CREATE TABLE users(id serial PRIMARY KEY, name varchar, profile varchar, position varchar, role varchar);

CREATE TABLE news(id serial PRIMARY KEY, title varchar, content varchar);

CREATE TABLE departments(id serial PRIMARY KEY, name varchar, profile varchar);

CREATE DATABASE awoken_test WITH TEMPLATE awoken;
