--// add_data_to_books
-- Migration SQL that makes the change goes here.
INSERT INTO books(bookname,author,publish_year)
VALUES ('Harry Potter','J.K.Rowling', '1997');
INSERT INTO books(bookname,author,publish_year)
VALUES ('A Song of Ice and Fire','George R. R. Martin', '1996');


--//@UNDO
-- SQL to undo the change goes here.


