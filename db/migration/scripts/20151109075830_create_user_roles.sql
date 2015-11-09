--// create_user_roles
-- Migration SQL that makes the change goes here.
  CREATE TABLE user_roles (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on user_roles (username,authority);


--//@UNDO
-- SQL to undo the change goes here.
 DROP TABLE user_roles;

