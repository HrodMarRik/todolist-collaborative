-- Empty database initialization script
-- This script creates an empty database for ToDoList Collaborative Application

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS todolist_db;
USE todolist_db;

-- Database is ready for development
-- Tables and data will be added by the development team
CREATE TABLE users(
   id_users INT AUTO_INCREMENT,
   LastName VARCHAR(50) NOT NULL,
   firstName VARCHAR(50) NOT NULL,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(50) NOT NULL,
   role VARCHAR(50) NOT NULL,
   avatar VARCHAR(250),
   PRIMARY KEY(id_users),
   UNIQUE(email)
);

CREATE TABLE List(
   id_list INT AUTO_INCREMENT,
   title VARCHAR(50) NOT NULL,
   listType VARCHAR(25) NOT NULL,
   listScope VARCHAR(25),
   PRIMARY KEY(id_list)
);

CREATE TABLE ListColumn(
   id_column INT AUTO_INCREMENT,
   title VARCHAR(50) NOT NULL,
   id_list INT NOT NULL,
   PRIMARY KEY(id_column),
   FOREIGN KEY(id_list) REFERENCES List(id_list)
);

CREATE TABLE listRoles(
   id_roles INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_roles)
);

CREATE TABLE task(
   id_task INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   description TEXT,
   endDate DATE,
   creationDate DATE NOT NULL,
   status VARCHAR(50) NOT NULL,
   priority VARCHAR(50),
   id_column INT NOT NULL,
   id_users INT NOT NULL,
   PRIMARY KEY(id_task),
   FOREIGN KEY(id_column) REFERENCES ListColumn(id_column),
   FOREIGN KEY(id_users) REFERENCES users(id_users)
);

CREATE TABLE comment(
   id_comment VARCHAR(50) AUTO_INCREMENT,
   content TEXT NOT NULL,
   id_task INT NOT NULL,
   id_users INT NOT NULL,
   PRIMARY KEY(id_comment),
   FOREIGN KEY(id_task) REFERENCES task(id_task),
   FOREIGN KEY(id_users) REFERENCES users(id_users)
);

CREATE TABLE belong(
   id_users INT,
   id_list INT,
   PRIMARY KEY(id_users, id_list),
   FOREIGN KEY(id_users) REFERENCES users(id_users),
   FOREIGN KEY(id_list) REFERENCES List(id_list)
);

CREATE TABLE have2(
   id_list INT,
   id_roles INT,
   PRIMARY KEY(id_list, id_roles),
   FOREIGN KEY(id_list) REFERENCES List(id_list),
   FOREIGN KEY(id_roles) REFERENCES listRoles(id_roles)
);

CREATE TABLE assigned2(
   id_users INT,
   id_roles INT,
   PRIMARY KEY(id_users, id_roles),
   FOREIGN KEY(id_users) REFERENCES users(id_users),
   FOREIGN KEY(id_roles) REFERENCES listRoles(id_roles)
);

