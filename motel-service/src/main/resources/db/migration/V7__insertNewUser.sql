INSERT INTO user(email, password, full_name, block) VALUES ("mod@gmail.com", "$2a$10$9D5L/eHfHgJAK8G/gMCcU.sRtpWQvK9K7aq3LyOau4PgI3HkZZycK", "Mod", 0);

INSERT INTO user_roles(user_id, role_id) VALUES(5, 1);
INSERT INTO user_roles(user_id, role_id) VALUES(5, 3);