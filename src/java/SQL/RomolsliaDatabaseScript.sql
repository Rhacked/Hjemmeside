DROP TABLE users;

CREATE TABLE users(
user_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
username VARCHAR(45) NOT NULL,
first_name VARCHAR(20);
last_name VARCHAR(20);
password CHAR NOT NULL,
)

CREATE TABLE groups (
group_id INT(20) NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
group_name VARCHAR(20) NOT NULL,
group_desc VARCHAR(200) DEFAULT NULL
)

CREATE TABLE user_groups(
user_id INT(10) NOT NULL,
group_id INT(10) NOT NULL,
PRIMARY KEY(user_id, group_id),
KEY fk_users_has_groups_groups1 (group_id),
KEY fk_users_has_groups_users (user_id),
CONSTRAINT fk_groups FOREIGN KEY(group_id) REFERENCES groups (group_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT fk_users FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)

CREATE VIEW v_user_role
AS
SELECT u.username, u.password, g.group_name
FROM user_groups ug
INNER JOIN users u ON u.user_id = ug.user_id
INNER JOIN groups g ON g.group_id = ug.group_id;

INSERT INTO groups(group_name,group_desc) VALUE ('USER','Regular user'), ('ADMIN','Administration users');

INSERT INTO users(username, first_name, last_name, password) VALUES ('rubenhag','ruben','hagen','3318ruben')

INSERT INTO user_groups(user_id, group_id) VALUES (1,2);
INSERT INTO user_groups(user_id, group_id) VALUE(2,2);

CREATE TABLE movie(
movie_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
movie_name VARCHAR(255) NOT NULL,
kategori VARCHAR(255) NOT NULL,
runtime INTEGER NOT NULL
)

