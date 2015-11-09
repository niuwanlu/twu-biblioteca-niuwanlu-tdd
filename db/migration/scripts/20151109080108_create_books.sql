--// create_books
-- Migration SQL that makes the change goes here.
 CREATE TABLE books(
      bookname varchar(50) not null primary key,
      author varchar(50) not null,
      publish_year varchar(50) not null);


--//@UNDO
-- SQL to undo the change goes here.
 DROP TABLE books;

