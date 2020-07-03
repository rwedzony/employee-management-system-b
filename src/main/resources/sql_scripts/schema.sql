-- create database for system
-- drop if exist
--DROP DATABASE ems;

-- CREATE DATABASE ems
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Polish_Poland.1250'
--     LC_CTYPE = 'Polish_Poland.1250'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1;

-- create table employee for system

DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    id SERIAL  PRIMARY KEY,
    first_name varchar(255)    NOT NULL,
    last_name  varchar(255)    NOT NULL,
    email      varchar(255)    NOT NULL,
    role       varchar(255)    NOT NULL
);

-- fill employee table with sample data

Insert into employee (first_name, last_name, email, role)
values ('Janina', 'Nowak', 'janinanowak@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Marek', 'Gladysz', 'marekgladysz@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Dominika', 'Paradowska', 'dominikaparadowska@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Marek', 'Jakubiak', 'marekJakubiak@interia.pl', 'barista');