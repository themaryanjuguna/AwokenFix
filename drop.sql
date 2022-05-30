psql -U postgres
\l
\c awoken
\dt

SELECT * FROM departments;
SELECT * FROM news;
SELECT * FROM users;

DROP TABLE departments;
DROP TABLE news;
DROP TABLE users;