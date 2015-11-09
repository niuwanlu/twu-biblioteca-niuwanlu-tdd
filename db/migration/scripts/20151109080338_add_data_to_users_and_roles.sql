--// add_data_to_users_and_roles
-- Migration SQL that makes the change goes here.
INSERT INTO users(username,password,enabled)
VALUES ('user','1234', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('mousse','1234', TRUE);

INSERT INTO user_roles (username, authority)
VALUES ('mousse', 'ROLE_USER');
INSERT INTO user_roles (username, authority)
VALUES ('mousse', 'ROLE_ADMIN');
INSERT INTO user_roles (username, authority)
VALUES ('user', 'ROLE_USER');


--//@UNDO
-- SQL to undo the change goes here.


