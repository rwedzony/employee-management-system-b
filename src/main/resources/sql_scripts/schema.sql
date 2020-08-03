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
    role       varchar(255)    NOT NULL,
    current_month_working_hours       integer   NOT NULL DEFAULT 168
);

-- fill employee table with sample data

Insert into employee (first_name, last_name, email, role)
values ('Janina', 'Nowak', 'janinanowak@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Marek', 'Gladysz', 'marekgladysz@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Dominika', 'Paradowska', 'dominikaparadowska@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Monika', 'Gerwazy', 'monika.gerwazy@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Janina', 'Paulus', 'janinapaulus@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Grzegorz', 'Piechocinski', 'grzegorzpiechociniski@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Martyna', 'Zyczkowska', 'martynazyczkowska@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Dariusz', 'Rezner', 'dariuszrezner@interia.pl', 'barista');


Insert into employee (first_name, last_name, email, role)
values ('Bartlomiej', 'Grzeda', 'bartlomiejgrzeda@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Milan', 'Janik', 'milanjanik@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Genowefa', 'Nowak', 'genowefanowak@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Piotr', 'Jastrzebski', 'piotrjastrzebski@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Daria', 'Kowalski', 'daria.kowalski@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Zaneta', 'Biegun', 'zanetabiegun@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Teodora', 'Nowak', 'teodoranowak@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Marek', 'Jerzy', 'dmarekjerzy@interia.pl', 'barista');

Insert into employee (first_name, last_name, email, role)
values ('Maciej', 'Matys', 'macejmatys@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Michalina', 'Rozmus', 'michalinarozmus@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Dariusz', 'Filip', 'dariuszfilip@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Dagmara', 'Strzelecka', 'dagmarastrzelecka@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Milena', 'Jarek', 'milenajarek@wp.pl', 'barista');
Insert into employee (first_name, last_name, email, role)
values ('Maciej', 'Biegun', 'maciejbiegun@onet.pl', 'kitchen chef');
Insert into employee (first_name, last_name, email, role)
values ('Katarzyna', 'Suder', 'katarzynasuder@interia.pl', 'cleaner');
Insert into employee (first_name, last_name, email, role)
values ('Krzysztof', 'Kulej', 'krzysztofkulej@interia.pl', 'barista');

