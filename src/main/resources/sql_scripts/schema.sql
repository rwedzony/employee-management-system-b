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
DROP TYPE IF EXISTS auth_level;


-- CREATE TYPE auth_level AS ENUM ('ADMIN', 'USER');

CREATE TABLE employee
(
    id SERIAL  PRIMARY KEY,
    first_name varchar(255)    NOT NULL,
    last_name  varchar(255)    NOT NULL,
    email      varchar(255)    NOT NULL,
    password   varchar(255)    NOT NULL,
    role       varchar(255)    NOT NULL,
    emp_auth_level  varchar(255)    NOT NULL,
    current_month_working_hours       integer   NOT NULL DEFAULT 168
);



-- fill employee table with sample data

Insert into employee (first_name, last_name, email,password,role,emp_auth_level)
values ('Janina', 'Nowak', 'janinanowak@wp.pl',
        'janina',
        'barista','ADMIN');
Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
values ('Marek', 'Gladysz', 'marekgladysz@onet.pl',
        'marek',
        'kitchen chef','USER');
--
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Dominika', 'Paradowska', 'dominikaparadowska@interia.pl',
--         'dominika'
--         'cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Monika', 'Gerwazy', 'monika.gerwazy@interia.pl',
--         'monika','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Janina', 'Paulus', 'janinapaulus@wp.pl',
--         'janina','barista','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Grzegorz', 'Piechocinski', 'grzegorzpiechociniski@onet.pl','grzegorz','kitchen chef','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Martyna', 'Zyczkowska', 'martynazyczkowska@interia.pl','grzegorz','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Dariusz', 'Rezner', 'dariuszrezner@interia.pl','dariusz','barista','USER');
--
--
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Bartlomiej', 'Grzeda', 'bartlomiejgrzeda@wp.pl','bartlomiej','barista','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Milan', 'Janik', 'milanjanik@onet.pl', 'kitchen chef','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Genowefa', 'Nowak', 'genowefanowak@interia.pl','genowefa','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Piotr', 'Jastrzebski', 'piotrjastrzebski@interia.pl', 'cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Daria', 'Kowalski', 'daria.kowalski@wp.pl','daria','barista','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Zaneta', 'Biegun', 'zanetabiegun@onet.pl','zaneta','kitchen chef','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Teodora', 'Nowak', 'teodoranowak@interia.pl','teodora','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Marek', 'Jerzy', 'dmarekjerzy@interia.pl','marek','barista','USER');
--
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Maciej', 'Matys', 'macejmatys@wp.pl','maciej','barista','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Michalina', 'Rozmus', 'michalinarozmus@onet.pl','michalina','kitchen chef','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Dariusz', 'Filip', 'dariuszfilip@interia.pl','dariusz','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Dagmara', 'Strzelecka', 'dagmarastrzelecka@interia.pl','dagmara','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Milena', 'Jarek', 'milenajarek@wp.pl','milena','barista','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Maciej', 'Biegun', 'maciejbiegun@onet.pl','maciej','kitchen chef','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Katarzyna', 'Suder', 'katarzynasuder@interia.pl','katarzyna','cleaner','USER');
-- Insert into employee (first_name, last_name, email, password,role,emp_auth_level)
-- values ('Krzysztof', 'Kulej', 'krzysztofkulej@interia.pl','krzysztof','barista','USER');
--
