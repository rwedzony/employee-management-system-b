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

--Delete Tables to have new fresh data (It need to be done in particular ORDER!)

-- first delete TASK table
DROP TABLE IF EXISTS task;

-- THAN delete employee table
DROP TABLE IF EXISTS employee;



-- CREATE TYPE auth_level AS ENUM ('ADMIN', 'USER');

CREATE TABLE employee
(
    id SERIAL  PRIMARY KEY,
    first_name varchar(255)    NOT NULL,
    last_name  varchar(255)    NOT NULL,
    email      varchar(255)    NOT NULL,
    password   varchar(255)    NOT NULL,
    salary      integer        NOT NULL,
    occupation       varchar(255)    NOT NULL,
    emp_auth_level  varchar(255)    NOT NULL,
    current_month_working_hours       integer   NOT NULL DEFAULT 168,
    remaining_day_offs              integer NOT NULL DEFAULT 26
);

CREATE TABLE task
(
    id SERIAL  PRIMARY KEY,
    description varchar(255)    NOT NULL,
    status varchar(255)    NOT NULL,
    start_date date   NOT NULL,
    end_date date  NOT NULL,
    employee_id integer not null references employee(id)
);



-- fill employee table with sample data

Insert into employee (first_name,
                      last_name,
                      email,
                      password,
                      salary,
                      occupation,
                      emp_auth_level,
                      current_month_working_hours,
                      remaining_day_offs)
values ('Janina',
        'Nowak',
        'janinanowak@wp.pl',
        '$2y$12$TYzxgKmV6zVzyJo.Gu7GyurGDtsFdqet54EFx.EJaCcqA8wiE3oya',
        7500,
        'managing board',
        'ROLE_ADMIN',
        168,
        22
        );
Insert into employee (first_name,
                      last_name,
                      email,
                      password,
                      salary,
                      occupation,
                      emp_auth_level,
                      current_month_working_hours,
                      remaining_day_offs)
values ('Marek',
        'Gladysz',
        'marekgladysz@onet.pl',
        '$2y$12$alREWZMc23cs8vVHr/N5OOcBcJhRr8XsuzGqT5Fq1U0EQNmE1wrgK',
        2000,
        'cleaner',
        'ROLE_USER',
        155,
        10);

INSERT INTO task(description,
                 status,
                 start_date,
                 end_date,
                 employee_id)
values('Meeting with Important person',
       'NEW',
       '2020-08-28',
       '2020-08-29',
       1
      );

INSERT INTO task(description,
                 status,
                 start_date,
                 end_date,
                 employee_id)
 values('Clean the office floor',
          'NEW',
         '2020-08-28',
         '2020-08-29',
        2
         );
INSERT INTO task(description,
                 status,
                 start_date,
                 end_date,
                 employee_id)
values('Take out the rubbish',
       'NEW',
       '2020-09-01',
       '2020-09-02',
       2
      );