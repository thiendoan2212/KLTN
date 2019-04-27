ALTER TABLE `user` ADD email varchar(255);

UPDATE `user` SET email="admin@gmail.com", password="$2a$10$9D5L/eHfHgJAK8G/gMCcU.sRtpWQvK9K7aq3LyOau4PgI3HkZZycK" WHERE id =1;
UPDATE `user` SET email="user@gmail.com", password="$2a$10$9D5L/eHfHgJAK8G/gMCcU.sRtpWQvK9K7aq3LyOau4PgI3HkZZycK" WHERE id =2;
UPDATE `user` SET email="thiendoan@gmail.com", password="$2a$10$9D5L/eHfHgJAK8G/gMCcU.sRtpWQvK9K7aq3LyOau4PgI3HkZZycK" WHERE id =3;
UPDATE `user` SET email="doanthien@gmail.com", password="$2a$10$9D5L/eHfHgJAK8G/gMCcU.sRtpWQvK9K7aq3LyOau4PgI3HkZZycK" WHERE id =4;
