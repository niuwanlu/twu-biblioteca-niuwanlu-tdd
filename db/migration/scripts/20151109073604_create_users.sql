--// create_users
-- Migration SQL that makes the change goes here.
 CREATE TABLE users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);


--//@UNDO
-- SQL to undo the change goes here.
 DROP TABLE users;

