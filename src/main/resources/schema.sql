-- DROP TABLE USER;
-- DROP TABLE TRANSACTIONS;
-- CREATE TABLE IF NOT EXISTS USER (ID INT PRIMARY KEY, USERNAME VARCHAR(30), EMAIL VARCHAR(30),PASSWORD VARCHAR(30) );
drop table IF EXISTS USERS;
drop table IF EXISTS authorities ;
drop table IF EXISTS TRANSACTIONS;
-- create table IF NOT EXISTS USERS(
-- 	username varchar_ignorecase(50) not null primary key,
-- 	password varchar_ignorecase(50) not null,
-- 	email varchar(100) not null,
-- 	enabled boolean not null
-- );
--
-- create table IF NOT EXISTS authorities (
-- 	username varchar_ignorecase(50) not null,
-- 	authority varchar_ignorecase(50) not null,
-- 	constraint fk_authorities_users foreign key(username) references users(username)
-- );
-- create unique index ix_auth_username on authorities (username,authority);
CREATE TABLE IF NOT EXISTS TRANSACTIONS (ID INT PRIMARY KEY, USERNAME VARCHAR(30), COIN VARCHAR(3),TYPE VARCHAR(5), QUANTITY DECIMAL, PRICE DECIMAL );
