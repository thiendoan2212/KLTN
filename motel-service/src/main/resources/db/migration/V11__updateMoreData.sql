-- Create Criteria
INSERT INTO criteria(district_id, user_id, motel, stop, price_start, price_end, acreage_start, acreage_end, create_at)
VALUES (1, 3, 1, 0, 1000000, 4000000, 10, 30, '2019-06-01 00:00:00'),
       (13, 2, 0, 0, 10000000, 15000000, 50, 150, '2019-06-3 20:00:00'),
       (15, 2, 0, 0, 10000000, 15000000, 50, 150, '2019-06-3 20:00:00');


-- Update time for all post
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=1;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=2;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=3;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=4;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=5;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=6;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=9;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=10;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=11;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=12;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=13;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=16;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=17;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=18;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=19;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=20;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=21;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=22;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=23;
UPDATE `post` SET `create_at`='2019-05-15 03:00:00', `last_update`='2019-05-15 03:00:00' WHERE id=24;


-- Create Action And Notification
UPDATE `post` SET `create_at`='2019-06-01 03:00:00', `last_update`='2019-06-01 03:00:00' WHERE id=7;
INSERT INTO `action`(post_id, user_id, `action`, `time`)
VALUES (7, 2, 'CREATE', '2019-06-01 03:00:00'),
       (7, 1, 'APPROVE', '2019-06-01 05:00:00');
INSERT INTO `notification`(post_id, user_id, criteria_id, seen, create_at, notification_name)
VALUES (7, 3, 1, 0, '2019-06-01 05:00:00', 'NOTIFICATION'),
       (7, 2, null, 1, '2019-06-01 05:00:00', 'APPROVE');

UPDATE `post` SET `create_at`='2019-06-01 03:10:00', `last_update`='2019-06-01 03:10:00' WHERE id=8;
INSERT INTO `action`(post_id, user_id, `action`, `time`)
VALUES (8, 2, 'CREATE', '2019-06-01 03:10:00'),
       (8, 1, 'APPROVE', '2019-06-01 05:01:00');
INSERT INTO `notification`(post_id, user_id, criteria_id, seen, create_at, notification_name)
VALUES (8, 3, 1, 0, '2019-06-01 05:01:00', 'NOTIFICATION'),
       (8, 2, null, 1, '2019-06-01 05:01:00', 'APPROVE');

UPDATE `post` SET `create_at`='2019-06-03 03:00:00', `last_update`='2019-06-03 03:00:00' WHERE id=14;
INSERT INTO `action`(post_id, user_id, `action`, `time`)
VALUES (14, 3, 'CREATE', '2019-06-03 03:00:00'),
       (14, 1, 'APPROVE', '2019-06-03 03:05:00');
INSERT INTO `notification`(post_id, user_id, criteria_id, seen, create_at, notification_name)
VALUES (14, 2, 1, 0, '2019-06-03 03:05:00', 'NOTIFICATION'),
       (14, 3, null, 1, '2019-06-03 03:05:00', 'APPROVE');

UPDATE `post` SET `create_at`='2019-06-03 03:00:00', `last_update`='2019-06-03 03:00:00' WHERE id=15;
INSERT INTO `action`(post_id, user_id, `action`, `time`)
VALUES (15, 3, 'CREATE', '2019-06-03 03:30:00'),
       (15, 1, 'APPROVE', '2019-06-03 03:35:00');
INSERT INTO `notification`(post_id, user_id, criteria_id, seen, create_at, notification_name)
VALUES (15, 2, 1, 0, '2019-06-03 03:35:00', 'NOTIFICATION'),
       (15, 3, null, 1, '2019-06-03 03:35:00', 'APPROVE');

UPDATE `post` SET `create_at`='2019-06-03 03:00:00', `last_update`='2019-06-03 03:00:00' WHERE id=4;
INSERT INTO `action`(post_id, user_id, `action`, `time`)
VALUES (4, 1, 'CREATE', '2019-06-03 03:30:00'),
       (4, 1, 'APPROVE', '2019-06-03 03:35:00');
INSERT INTO `notification`(post_id, user_id, criteria_id, seen, create_at, notification_name)
VALUES (4, 2, 1, 0, '2019-06-03 03:35:00', 'NOTIFICATION'),
       (4, 1, null, 1, '2019-06-03 03:35:00', 'APPROVE');


-- Add new post and accomodation
INSERT INTO post(title, content, create_at, last_update, approved, not_approved, del, user_id)
VALUES ("Cho thuê phòng trọ tại 95/4 Nguyễn Thái Học, P.Cầu Ông Lãnh, Q1", "<p>Ph&ograve;ng cho thu&ecirc; diện t&iacute;ch 6m2, gi&aacute; 1tr5/ th&aacute;ng.<br />Diện t&iacute;ch 12m2, 2tr8/ th&aacute;ng, c&oacute; chỗ để xe, giờ giấc tự do, ngay trung t&acirc;m th&agrave;nh phố tiện đi lại , an ninh ...&nbsp;<br />Địa chỉ: 95/4 Nguyễn Th&aacute;i Học, phường Cầu &Ocirc;ng L&atilde;nh, quận 1<br />Lh chị Như 0913477115</p>", '2019-06-08 15:30:00', '2019-06-08 15:30:00', 0, 1, 0, 2);
INSERT INTO accomodation(acreage, address, air_conditioner, cabletv, electric_price, heater, internet, motel, parking, price, status, toilet, tv, water_price, x_coordinate, y_coordinate, district_id, post_id)
VALUES (12, "95/4, Đường Nguyễn Thái Học, Phường Cầu Ông Lãnh, Quận 1, Hồ Chí Minh", 0, 0, 0, 0, 1, 1, 1, 2800000, 1, "KHEP_KIN", 0, 0, 10.766461, 106.696409, 1, 25);


-- Block post above
INSERT INTO `action`(post_id, user_id, `action`, `time`)
VALUES (25, 2, 'CREATE', '2019-06-08 15:30:00'),
       (25, 1, 'BLOCK', '2019-06-08 20:18:14');
INSERT INTO `notification`(post_id, user_id, criteria_id, seen, create_at, notification_name)
VALUES (25, 2, null, 1, '2019-06-08 20:18:14', 'BLOCK');