


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

CREATE TABLE employee(
   id INT PRIMARY KEY     NOT NULL,
   first_name           varchar(255)    NOT NULL,
   last_name            varchar(255)     NOT NULL,
   email        varchar(255)     NOT NULL
);

-- fill employee table with sample data

Insert into employee values ('1', 'Janina','Nowak','janinanowak@wp.pl');
Insert into employee values ('2', 'Marek','Gladysz','marekgladysz@onet.pl');
Insert into employee values ('3', 'Dominika','Paradowska','dominikaparadowska@interia.pl');