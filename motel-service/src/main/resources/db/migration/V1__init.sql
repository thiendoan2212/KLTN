-- -- Insert User
-- INSERT INTO user(username, password, phone, address, block) VALUES ("admin", "$10$SRS5JnmocyxjDzXkTKxzl.MXeDYqLtGGKqLnUE6QfxQwU4WmWgMaK", "0784553008", "97 đường số 6 khu phố 4 phường Tam Phú quận Thủ Đức", 0),
--                                                                    ("user", "$10$SRS5JnmocyxjDzXkTKxzl.MXeDYqLtGGKqLnUE6QfxQwU4WmWgMaK", "0784553008", "97 đường số 6 khu phố 4 phường Tam Phú quận Thủ Đức", 0);
--
-- -- Insert Role
-- INSERT INTO role(name) VALUES ("ROLE_USER"), ("ROLE_ADMIN");
--
-- -- Insert User_Roles
-- INSERT INTO user_roles(user_id, role_id) VALUES (1, 1), (1, 2), (2, 1);
--
-- -- Insert District
-- INSERT INTO district(name, x_coordinate, y_coordinate) VALUES ("Quận 1", 10.7756587, 106.7004238),
--                                                               ("Quận 2", 10.7872729, 106.7498105),
--                                                               ("Quận 3", 10.7843695, 106.6844089),
--                                                               ("Quận 4", 10.7578263, 106.7012968),
--                                                               ("Quận 5", 10.7540279, 106.6633746),
--                                                               ("Quận 6", 10.7480929, 106.6352362),
--                                                               ("Quận 7", 10.7340344, 106.7215787),
--                                                               ("Quận 8", 10.7240878, 106.6286259),
--                                                               ("Quận 9", 10.8428402, 106.8286851),
--                                                               ("Quận 10", 10.7745965, 106.6679542),
--                                                               ("Quận 11", 10.7629739, 106.650084),
--                                                               ("Quận 12", 10.8671531, 106.6413322),
--                                                               ("Quận Thủ Đức", 10.8494094, 106.7537055),
--                                                               ("Quận Gò Vấp", 10.8386779, 106.6652904),
--                                                               ("Quận Bình Thạnh", 10.8105831, 106.7091422),
--                                                               ("Quận Tân Bình", 10.8014659, 106.6525974),
--                                                               ("Quận Tân Phú", 10.7900517, 106.6281901),
--                                                               ("Quận Phú Nhuận", 10.7991944, 106.6802639),
--                                                               ("Huyện Củ Chi", 11.0066683, 106.5131967),
--                                                               ("Huyện Hóc Môn", 10.8839675, 106.5870611),
--                                                               ("Huyện Bình Chánh", 10.687392, 106.5938538),
--                                                               ("Huyện Nhà Bè", 10.6952642, 106.704874),
--                                                               ("Huyện Cần Giờ", 10.5083266, 106.8635004);
-- Insert User
INSERT INTO user(username, password, phone, address, block)
VALUES ("admin", "$10$SRS5JnmocyxjDzXkTKxzl.MXeDYqLtGGKqLnUE6QfxQwU4WmWgMaK", "0784553008", "97 đường số 6 khu phố 4 phường Tam Phú quận Thủ Đức", 0),
       ("user", "$10$SRS5JnmocyxjDzXkTKxzl.MXeDYqLtGGKqLnUE6QfxQwU4WmWgMaK", "0784553008", "97 đường số 6 khu phố 4 phường Tam Phú quận Thủ Đức", 0),
       ("thiendoan", "$10$SRS5JnmocyxjDzXkTKxzl.MXeDYqLtGGKqLnUE6QfxQwU4WmWgMaK", "0934665901", "15 đường số 6 khu phố 4 phường Tam Phú quận Thủ Đức", 0),
       ("doanthien", "$10$SRS5JnmocyxjDzXkTKxzl.MXeDYqLtGGKqLnUE6QfxQwU4WmWgMaK", "0934665901", "15 đường số 6 khu phố 4 phường Tam Phú quận Thủ Đức", 0);

-- Insert Role
INSERT INTO role(name) VALUES ("ROLE_USER"), ("ROLE_ADMIN");

-- Insert User_Roles
INSERT INTO user_roles(user_id, role_id) VALUES (1, 1), (1, 2), (2, 1), (3, 1), (4,1);

-- Insert District
INSERT INTO district(name, x_coordinate, y_coordinate) VALUES ("Quận 1", 10.7756587, 106.7004238),
                                                              ("Quận 2", 10.7872729, 106.7498105),
                                                              ("Quận 3", 10.7843695, 106.6844089),
                                                              ("Quận 4", 10.7578263, 106.7012968),
                                                              ("Quận 5", 10.7540279, 106.6633746),
                                                              ("Quận 6", 10.7480929, 106.6352362),
                                                              ("Quận 7", 10.7340344, 106.7215787),
                                                              ("Quận 8", 10.7240878, 106.6286259),
                                                              ("Quận 9", 10.8428402, 106.8286851),
                                                              ("Quận 10", 10.7745965, 106.6679542),
                                                              ("Quận 11", 10.7629739, 106.650084),
                                                              ("Quận 12", 10.8671531, 106.6413322),
                                                              ("Quận Thủ Đức", 10.8494094, 106.7537055),
                                                              ("Quận Gò Vấp", 10.8386779, 106.6652904),
                                                              ("Quận Bình Thạnh", 10.8105831, 106.7091422),
                                                              ("Quận Tân Bình", 10.8014659, 106.6525974),
                                                              ("Quận Tân Phú", 10.7900517, 106.6281901),
                                                              ("Quận Phú Nhuận", 10.7991944, 106.6802639),
                                                              ("Huyện Củ Chi", 11.0066683, 106.5131967),
                                                              ("Huyện Hóc Môn", 10.8839675, 106.5870611),
                                                              ("Huyện Bình Chánh", 10.687392, 106.5938538),
                                                              ("Huyện Nhà Bè", 10.6952642, 106.704874),
                                                              ("Huyện Cần Giờ", 10.5083266, 106.8635004);

-- Insert Post và Accomodation và Image
-- -- user_id 1 - Quận Bình Thạnh
INSERT INTO post(title, content, create_at, last_update, approved, not_approved, del, user_id)
VALUES ("phòng trọ giá rẻ đường Nguyễn Hữu Cảnh - Bình Thạnh", "<p>Ph&ograve;ng trọ đường Nguyễn Hữu Cảnh gi&aacute; rẻ, gần H&agrave;ng Xanh, ĐH Hutech, GTVT. Giờ giấc tự do, được nấu ăn. Điện, nước, wifi t&iacute;nh theo h&oacute;a đơn gi&aacute; nh&agrave; nước. Th&iacute;ch hợp cho nh&acirc;n vi&ecirc;n văn ph&ograve;ng, sinh vi&ecirc;n ở l&acirc;u d&agrave;i. LH c&ocirc; Thoa 0961583572.</p>", now(), now(), 1, 0, 0, 1),
       ("KHU CĂN HỘ MINI ,PHÒNG ĐẸP SẠCH SẼ ,ĐẦY ĐỦ NỘI THẤT", "<p>Ch&agrave;o mọi người ,m&igrave;nh cho thu&ecirc; căn hộ mini đầy đủ tiện nghi ở quận B&igrave;nh Thạnh.<br />Ph&ograve;ng rộng 20m2 ,sạch sẽ được trang bị đầy đủ c&aacute;c thi&ecirc;t bị hiện đại, tiết kiệm điện nước tối đa. Đồng hồ điện ri&ecirc;ng cho từng ph&ograve;ng .<br />C&aacute;c tiện ich k&egrave;m theo:<br />1. M&aacute;y lạnh<br />2. M&aacute;y giặt<br />3. WC trong ph&ograve;ng.<br />4. Tủ lạnh<br />6. Giuong nệm<br />7. Tủ quần &aacute;o<br />8. Kệ bếp<br />9. M&aacute;y n&oacute;ng lạnh<br />10 .TI VI<br />11.Miễn ph&iacute; d&ugrave;ng Wifi ,c&oacute; chỗ để xe an to&agrave;n , An ninh ,giờ giấc tự do ,c&oacute; cửa sổ tho&aacute;ng m&aacute;t.....<br />M&ocirc;i trường sống hiện đại - văn minh lịch sự.<br />Giao th&ocirc;ng tiện lợi gần quận 1 c&aacute;ch 500m.<br />Ngay tring t&acirc;m B&igrave;nh Thạnh ,gần chợ Thị Nghề , gần khu ăn uống,...<br />Địa chỉ :220/76B X&Ocirc; VIẾT NGHỆ TĨNH P21 ,B&Igrave;NH THẠNH.TPHCM<br />Mọi người vui l&ograve;ng li&ecirc;n hệ Cường 0937499202-Th&uacute;y 0398769308<br />Tin đăng l&agrave; chủ nh&agrave; kh&ocirc;ng th&ocirc;ng qua m&ocirc;i giới</p>", now(), now(), 1, 0, 0, 1),
       ("Ở ghép tổng 2 phòng riêng đầy đủ 35 m2, nguyễn văn đậu, bình thạnh", "<p>10 ng&agrave;y nữa bạn ở chung nh&agrave; nguy&ecirc;n căn chuyển đi, n&ecirc;n cần 1 bạn ở gh&eacute;p/<br />nh&agrave; đầy đủ tủ lạnh, m&aacute;y giặt, tivi, wifi, điện 3500đ/kw, nước cao lắm 40k/người. bếp đầy đủ<br />Hẻm cực an ninh, tho&aacute;ng m&aacute;t tho&atilde;i m&aacute;i cực kỳ,<br />Đảm bảo ở 2 người với gi&aacute; n&agrave;y khỏi ch&ecirc;.<br />th&iacute;ch th&igrave; v&agrave;o ở lu&ocirc;n b&acirc;y giờ cũng đc, gi&aacute; 500k, sau bạn kia chuyển đi th&igrave; gi&aacute; 1,5tr, cọc 1,5tr.<br />Ngay trung t&acirc;m, đi đ&acirc;u cũng tiện.<br />sdt: khong ch&iacute;n ba tam hai ba s&aacute;u bốn kh&ocirc;ng năm.</p>", now(), now(), 1, 0, 0, 1),
       ("nhà nguyên căn 58sqr, 13trieu, 1 lầu", "<p>148/14 Nguyễn L&acirc;m, phường 3, B&igrave;nh Thạnh c&oacute; thể v&agrave;o hẻm 214 Vạn Kiếp ngay khu Phan X&iacute;ch Long, chỉ 3 ph&uacute;t đến Q1. Diện t&iacute;ch 4x14, 1 trệt, 1 lầu, 2 ph&ograve;ng ngủ, 2 tolet. Nh&agrave; mới v&agrave;o ở ngay, gi&aacute; cho thu&ecirc; 14 triệu/th&aacute;ng.</p>", now(), now(), 1, 0, 0, 1),
       ("Tìm 1 nữ nhân viên văn phòng ở ghép", "<p>- cần t&igrave;m 1 nữ nh&acirc;n vi&ecirc;n văn ph&ograve;ng giờ h&agrave;nh ch&iacute;nh ở gh&eacute;p ở sạch sẽ, gọn g&agrave;ng, &iacute;t đồ, &iacute;t nấu ăn, ở đ&agrave;ng ho&agrave;ng, ở chung để share tiền ph&ograve;ng v&igrave; hiện tại m&igrave;nh ở 1m&igrave;nh n&ecirc;n ph&ograve;ng c&ograve;n hơi rộng, v&agrave; đi l&agrave;m giờ h&agrave;nh ch&iacute;nh từ s&aacute;ng tới tối mới về.<br />- ph&ograve;ng sạch, đẹp, toilet trong ph&ograve;ng, khu d&acirc;n cư tri thức, y&ecirc;n tĩnh, đường nhựa th&ocirc;ng tho&aacute;ng để chạy xe hơi, m&aacute;t mẻ.<br />- gi&aacute; 1 người: khoảng 1.2 triệu/ th&aacute;ng cho tất cả c&aacute;c chi ph&iacute; bao gồm tiền nh&agrave;, điện, internet, nước. Qu&aacute; rẻ để ở khu n&agrave;y nha.<br />- li&ecirc;n hệ m&igrave;nh: Ms Ho&agrave;ng- 0937248407 để coi ph&ograve;ng trực tiếp</p>", now(), now(), 1, 0, 0, 1),
       ("Phòng Ký Túc xá cho thuê ở ghép (Bao điện nước)", "<p>K&yacute; T&uacute;c x&aacute; cho thu&ecirc; B&igrave;nh Thạnh với vị tr&iacute; đẹp, với c&aacute;c quận l&acirc;n c&acirc;n như Q1, Q2 &amp; Q3<br /><br />Đến với ch&uacute;ng t&ocirc;i, c&aacute;c bạn sẽ nhận được những tiện &iacute;ch v&agrave; dịch vụ như sau:<br />☘️ Wifi miễn ph&iacute; ...<br />☘️ Dịch vụ dọn vệ sinh sạch sẽ&nbsp;<br />☘️ Bảo vệ an ninh c&ugrave;ng Camera 24/24h<br />☘️ M&aacute;y giặt v&agrave; s&acirc;n phơi<br />☘️ Nh&agrave; bếp&nbsp;<br />☘️ Tủ lạnh<br />☘️ Tủ ri&ecirc;ng đựng đồ v&agrave; vật dụng<br />☘️ M&aacute;y lạnh&nbsp;<br /><br />Ch&uacute;ng t&ocirc;i cung cấp ph&ograve;ng k&yacute; t&uacute;c x&aacute; ở 3 chi nh&aacute;nh ch&iacute;nh:</p>", now(), now(), 1, 0, 0, 1);

INSERT INTO accomodation(acreage, address, air_conditioner, cabletv, electric_price, heater, internet, motel, parking, price, status, toilet, tv, upstair, water_price, x_coordinate, y_coordinate, district_id, post_id)
VALUES (22, "135 nguyễn hữu cảnh, 22, Bình Thạnh, Hồ Chí Minh", 1, 1, 0, 0, 1, 1, 0, 5000000, 1, "KHEP_KIN", 1, 0, 0, 10.796200, 106.718502, 15, 1),
       (20, "220/76B XÔ VIẾT NGHỆ TĨNH P21 BÌNH THẠNH, Phường 1, Bình Thạnh, Hồ Chí Minh", 0, 1, 0, 0, 1, 1, 1, 1400000, 1, "KHEP_KIN", 1, 0, 0, 10.798553, 106.713669, 15, 2),
       (35, "101/27 nguyễn văn đậu, phường, 1 Bình Thạnh, Hồ Chí Minh", 0, 1, 0, 0, 1, 0, 1, 1500000, 1, "KHEP_KIN", 1, 1, 0, 10.809568, 106.687896, 15, 3),
       (58, "148/14 Nguyễn Lâm, phường 3, Bình Thạnh", 1, 1, 0, 0, 1, 0, 1, 13000000, 1, "KHEP_KIN", 1, 1, 0, 10.800530, 106.692470, 15, 4),
       (20, "281/4/32 bình lợi, phường 13, Bình Thạnh, Hồ Chí Minh", 0, 0, 0, 0, 1, 1, 1, 1200000, 1, "KHEP_KIN", 0, 1, 0, 10.825742, 106.706670, 15, 5),
       (40, "Bình Thạnh , , Bình Thạnh, Hồ Chí Minh", 0, 0, 0, 0, 0, 1, 0, 900000, 1, "CHUNG", 0, 0, 0, 10.810681, 106.708308, 15, 6);

-- -- -- post_id 1
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 1\phong-tro.jpg'), 1);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 1\phong-tro-1.jpg'), 1);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 1\phong-tro-2.jpg'), 1);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 1\phong-tro-3.jpg'), 1);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-4", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 1\phong-tro-4.jpg'), 1);

-- -- -- post_id 2
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 2\khu-can-ho.jpg'), 2);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 2\khu-can-ho-1.jpg'), 2);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 2\khu-can-ho-2.jpg'), 2);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 2\khu-can-ho-3.jpg'), 2);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-4", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 2\khu-can-ho-4.jpg'), 2);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-4", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 2\khu-can-ho-5.jpg'), 2);

-- -- -- post_id 3
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 3\phong-tro.jpg'), 3);

-- -- -- post_id 4
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 4\phong-tro.jpg'), 4);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 4\phong-tro-1.jpg'), 4);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 4\phong-tro-2.jpg'), 4);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 4\phong-tro-3.jpg'), 4);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-4", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 4\phong-tro-4.jpg'), 4);

-- -- -- post_id 5
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 5\phong-tro.jpg'), 5);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 5\phong-tro-1.jpg'), 5);

-- -- -- post_id 6
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 6\phong-tro.jpg'), 6);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 6\phong-tro-1.jpg'), 6);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 6\phong-tro-2.jpg'), 6);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 6\phong-tro-3.jpg'), 6);


-- -- user_id 2 -- Quận 1
INSERT INTO post(title, content, create_at, last_update, approved, not_approved, del, user_id)
VALUES ("Phòng trọ quận 1 sàn gỗ đẹp, đầy đủ tiện nghi", "<p>Cho thu&ecirc; ph&ograve;ng trọ cao cấp, s&agrave;n gỗ, đầy đủ tiện nghi. khu vực trung t&acirc;m quận 1, y&ecirc;n tĩnh, gần c&ocirc;ng vi&ecirc;n.<br /><br />Ph&ograve;ng ở lầu 1 trong nh&agrave; nguy&ecirc;n căn. giờ giấc tự do. Free wifi v&agrave; mỗi ng&agrave;y đều c&oacute; người dọn dẹp vệ sinh khu vực chung.</p>", now(), now(), 1, 0 ,0, 2),
       ("Homestay cao cấp 26m2", "<p>C&ograve;n 1 ph&ograve;ng duy trang tr&iacute; phong c&aacute;ch homestay cực chất!.<br />- Khu vực trung t&acirc;m gi&aacute;p Q1, Q3, Ph&uacute; Nhuận.<br />- 10 ph&uacute;t đi s&acirc;n bay T&acirc;n Sơn Nhất<br />- 5 ph&uacute;t đi Q1, Q3, Ph&uacute; Nhuận.<br />- Gần rất nhiều nh&agrave; h&agrave;ng, qu&aacute;n c&agrave; ph&ecirc;, si&ecirc;u thị, văn ph&ograve;ng, cửa h&agrave;ng tiện lợi, ng&acirc;n h&agrave;ng, bệnh viện...<br /><br />- Gi&aacute; 7 triệu/th&aacute;ng (Thanh to&aacute;n từ ng&agrave;y 1 - 5).<br />+ HĐ từ 3 th&aacute;ng.<br />+ Đặt cọc 1 th&aacute;ng.<br />Gi&aacute; thu&ecirc; bao ph&iacute; gồm: Internet, vệ sinh chung, m&aacute;y giặt<br />Li&ecirc;n hệ xem ph&ograve;ng ngay.</p>", now(), now(), 1, 0 , 0, 2),
       ("Phòng trọ cao cấp Điện Biên Phủ, Q.1", "<p>- ĐẦY ĐỦ NỘI THẤT: giường gỗ, nệm , TIVI , tủ lạnh, điều ho&agrave;, m&aacute;y nước n&oacute;ng, tủ đồ, m&aacute;y giặc , wifi<br />- DỌN VALI V&Agrave;O Ở NGAY.&nbsp;<br />- Hẻm rộng c&aacute;ch đường lớn Điện Bi&ecirc;n Phủ 50m , v&agrave; l&agrave; hẻm cụt n&ecirc;n AN NINH TUYỆT ĐỐI camera trong nh&agrave;<br />- Ch&igrave;a kho&aacute; v&acirc;n tay đi về như ch&iacute;nh nh&agrave; bạn - tự do 24/7 kh&ocirc;ng chung chủ<br />- Xe để dưới nh&agrave; c&oacute; bảo vệ tr&ocirc;ng coi y&ecirc;n t&acirc;m tuyệt đối<br />- MIỄN PH&Iacute;: internet c&aacute;p quang wifi 35MB,xe<br />-Điện:3.5k/số.nước 100k/người<br />GI&Aacute; THU&Ecirc;:&nbsp;<br />_6tr/th&aacute;ng:thanh to&agrave;n trước ng&agrave;y m&ugrave;ng 5 đầu th&aacute;ng</p>", now(), now(), 1, 0 , 0, 2),
       ("Phòng mới quận 1, đầy đủ tiện nghi", "<p>Hiện nh&agrave; nguy&ecirc;n căn gồm 1 trệt v&agrave; 3 lầu 1 s&acirc;n thượng c&oacute; 3 ph&ograve;ng cho thu&ecirc;. Gi&aacute; 2 - 3,5 triệu/ph&ograve;ng. Nh&agrave; trước đ&acirc;y l&agrave; 1 kh&aacute;ch sạn n&ecirc;n mỗi ph&ograve;ng đều c&oacute; đầy đủ tiện nghi (giường, m&aacute;y lạnh... ), c&oacute; ban c&ocirc;ng đầy đủ &aacute;nh s&aacute;ng. Nh&agrave; đẹp, thiết kế tiện nghi. Ở dưới ch&acirc;n nh&agrave; buổi s&aacute;ng l&agrave; chợ, ph&iacute;a sau chợ Th&aacute;i B&igrave;nh, đối diện c&ocirc;ng vi&ecirc;n 23/9, c&aacute;ch Coop Mart Cống Quỳnh 5 ph&uacute;t đi bộ, nằm ngay trung t&acirc;m TP v&agrave; khu phố t&acirc;y. Kh&ocirc;ng ở chung chủ, giờ giấc tự do, c&oacute; ch&igrave;a kho&aacute; ri&ecirc;ng. Kh&ocirc;ng giới hạn số người ở/ ph&ograve;ng. Th&iacute;ch hợp cho những gia đ&igrave;nh nhỏ, những người đi l&agrave;m, y&ecirc;n tĩnh v&igrave; c&oacute; sự t&aacute;ch biệt. Địa chỉ: 353/2/11 Phạm Ngũ L&atilde;o.</p>", now(), now(), 1, 0 , 0, 2),
       ("Phòng trọ Quận 1 cho thuê", "<p>Ph&ograve;ng c&oacute; m&aacute;y lạnh ,tủ lạnh, tủ quần &aacute;o 4 c&aacute;nh sang trọng ,giường ,n&ecirc;m,chăn ra gối , c&oacute; cửa sổ ban c&ocirc;ng , c&oacute; nước n&oacute;ng lạnh.</p>", now(), now(), 1, 0 , 0, 2),
       ("Phòng cho thuê, giờ giấc tự do, đầy đủ nội thất", "<p>cho thu&ecirc; ph&ograve;ng đầy đủ nội thất giờ giấc tự do<br />Diện t&iacute;ch 26m2,&nbsp;<br />C&oacute; sẵn giường nệm, b&agrave;n ghế, tủ quần &aacute;o, tủ lạnh, m&aacute;y lạnh, nh&agrave; wc ri&ecirc;ng c&oacute; hệ thống nước n&oacute;ng lạnh<br />Sạch sẽ,<br />Miễn ph&iacute; để xe, internet<br />Gần chợ H&ograve;a B&igrave;nh, tiện ăn uống 24/24<br />Gần c&ocirc;ng vi&ecirc;n gần bờ k&ecirc;nh</p>", now(), now(), 1, 0 , 0, 2);

INSERT INTO accomodation(acreage, address, air_conditioner, cabletv, electric_price, heater, internet, motel, parking, price, status, toilet, tv, upstair, water_price, x_coordinate, y_coordinate, district_id, post_id)
VALUES (25, "9/7Bis, Đường Phan Tôn, Phường Đa Kao, Quận 1, Tp Hồ Chí Minh", 1, 1, 0, 0, 1, 1, 0, 4000000, 1, "KHEP_KIN", 1, 0, 0, 10.790029, 106.696245, 1, 7),
       (26, "93/37, Đường Vạn Kiếp, Phường Bến Nghé, Quận 1, Tp Hồ Chí Minh", 1, 1, 0, 0, 1, 1, 0, 4000000, 1, "KHEP_KIN", 1, 0, 0, 10.798428, 106.693679, 1, 8),
       (30, "127/139, Đường Điện Biên Phủ, Phường Đa Kao, Quận 1, Tp Hồ Chí Minh", 1, 1, 0, 0, 1, 1, 0, 6000000, 1, "KHEP_KIN", 1, 0, 0, 10.788540, 106.696286, 1, 9),
       (16, "353/2/11 Phạm Ngũ Lão, P.Phạm Ngũ Lão, TP.HCM", 1, 0, 0, 0, 1, 1, 0, 6000000, 1, "KHEP_KIN", 1, 0, 0, 10.766994, 106.690080, 1, 10),
       (30, "Hẻm 12 Nguyễn Thị Minh Khai, Quận 1, Hồ Chí Minh, Việt Nam", 1, 0, 0, 0, 1, 1, 0, 4800000, 1, "KHEP_KIN", 1, 0, 0, 10.788592, 106.702089, 1, 11),
       (26, "5 Đường Nguyễn Cảnh Chân, Phường Nguyễn Cư Trinh, Quận 1, Hồ Chí Minh, Việt Nam", 1, 1, 4000, 0, 1, 1, 0, 4700000, 1, "KHEP_KIN", 1, 0, 0, 10.759722, 106.686444, 1, 12);

-- -- -- post_id 7
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 7\phong-tro.jpg'), 7);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 7\phong-tro-1.jpg'), 7);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 7\phong-tro-2.jpg'), 7);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 7\phong-tro-3.jpg'), 7);

-- -- -- post_id 8
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 8\phong-tro.jpg'), 8);

-- -- -- post_id 9
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 9\phong-tro.jpg'), 9);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 9\phong-tro-1.jpg'), 9);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 9\phong-tro-2.jpg'), 9);

-- -- -- post_id 10
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 10\phong-tro.jpg'), 10);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 10\phong-tro-1.jpg'), 10);

-- -- -- post_id 11
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 11\phong-tro.jpg'), 11);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 11\phong-tro-1.jpg'), 11);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 11\phong-tro-2.jpg'), 11);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 11\phong-tro-3.jpg'), 11);

-- -- -- post_id 12
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 12\phong-tro.jpg'), 12);

-- -- user_id 3 -- Quận Thủ Đức
INSERT INTO post(title, content, create_at, last_update, approved, not_approved, del, user_id)
VALUES ("Tìm người ở ghép nhà nguyên căn chợ Bình Triệu", "<p>M&igrave;nh cần tuyển 2 bạn nữ ở gh&eacute;p trong ph&ograve;ng với m&igrave;nh. Nh&agrave; rấtđ&aacute;ng để ở ổn định nh&eacute;.&nbsp;<br />Nh&agrave; m&igrave;nh nguy&ecirc;n căn đầy đủ tiện nghi, gi&aacute; lại good nh&eacute;. C&aacute;cbạn xem th&ocirc;ng tin như b&ecirc;n dưới :&nbsp;<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nh&agrave; 1 trệt, 2 lầu. Toilet ri&ecirc;ng từng ph&ograve;ng, c&oacute; cửasổ tho&aacute;ng m&aacute;t, c&oacute; m&aacute;y lạnh. C&oacute; s&acirc;n thượng phơi đồ thoải m&aacute;i, nắng mưa đều c&oacute; chỗ<br />phơi, c&oacute; s&acirc;n để xe, b&ecirc;n h&ocirc;ng c&oacute; s&acirc;n chơi cầu l&ocirc;ng nữa<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dưới nh&agrave; c&oacute; bếp, dụng cụ đầy đủ, nấu ăn thoảim&aacute;i. Nh&agrave; m&igrave;nh c&oacute; sẵn 2 tủ lạnh.&nbsp;<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Điện, nước t&iacute;nh theo gi&aacute; nh&agrave; nước. X&agrave;i nhi&ecirc;u trảnhi&ecirc;u, chia theo đầu người. Rất c&ocirc;ng bằng.&nbsp;<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kh&ocirc;ng ở chung chủ, c&aacute;c chị em ở nề nếp, tự quảnl&yacute; v&agrave; c&oacute; &yacute; thức cao n&ecirc;n nh&agrave; rất sạch sẽ, h&ograve;a đồng v&agrave; gi&uacute;p đỡ nhau nh&eacute;. Mọi người<br />đều d&acirc;n đi l&agrave;m/đi học c&oacute; tr&igrave;nh độ.<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Đi lại: Hẻm v&agrave;o &ocirc; t&ocirc;, ph&iacute;a trước hẻm l&agrave; chợ b&igrave;nhtriệu, gần si&ecirc;u thị co.opmart. Gần TTTM Gigamall. Đi l&ecirc;n c&aacute;c quận trung t&acirc;m/<br />s&acirc;n bay cũng gần v&igrave; gần tuyến đường Phạm Văn Đồng<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chi ph&iacute;: 1.4-1.5tr/ người đ&atilde; bao gồm tất cả c&aacute;cchi ph&iacute; li&ecirc;n quan (điện, nước, net,&hellip;)<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Giờ giấc tự do, tối thường 10h30 đ&oacute;ng cửa, nhưngai về trễ th&igrave; tự đ&oacute;ng nh&eacute;<br />-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;M&igrave;nh cần người khoảng cuối th&aacute;ng 3/2019 v&ocirc; ở &nbsp;<br />Bạn n&agrave;o nhanh v&agrave; c&oacute; thiện ch&iacute; th&igrave;li&ecirc;n hệ với m&igrave;nh xem nh&agrave; nh&eacute;. SDT: 0962406001 (Ngọc) / 0338497797 - Trinh)</p>", now(), now(), 1, 0, 0, 3),
       ("Cho thuê nhà nguyên căn 1 trệt 1 lầu, mặt tiền đường 28, HBC, Thủ Đức", "<p>Nh&agrave; 1 trệt 1 lầu, sử dụng 150m2, c&oacute; 3 ph&ograve;ng ngủ, 3 nh&agrave; vệ sinh.<br />Địa chỉ tại: 59 đường số 28, phường hiệp b&igrave;nh ch&aacute;nh, thủ đức.<br />Nh&agrave; thiết kế rộng r&atilde;i, nh&igrave;n rất hiện đại. C&oacute; đầy đủ thiết bị trong ph&ograve;ng từ b&agrave;n ăn, bếp n&uacute;c, giường tủ ... tới điều h&ograve;a nhiệt độ, m&aacute;y giặt.<br />C&oacute; chổ để xe ri&ecirc;ng, khu vực an ninh, y&ecirc;n tĩnh, gần bờ s&ocirc;ng n&ecirc;n kh&ocirc;ng kh&iacute; rất tho&aacute;ng đ&atilde;ng.<br />Gi&aacute; cho thu&ecirc;: 15 triệu/th&aacute;ng. Th&iacute;ch hợp nhất cho đại gia đ&igrave;nh ở, hoặc cho thu&ecirc; l&agrave;m văn ph&ograve;ng c&ocirc;ng t&yacute;. cho thu&ecirc; k&egrave;m theo nội thất trong nh&agrave; lu&ocirc;n.<br />Li&ecirc;n hệ xem nh&agrave;: 0933 54 08 04 Sang</p>", now(), now(), 1, 0, 0, 3),
       ("Phòng trọ thủ đức 50m2 gần khu cá sấu hoa cà", "<p>M&igrave;nh c&ograve;n 2ph&ograve;ng liền kề 50m2..bếp tolet ri&ecirc;ng..wifi Free giờ giấc thoải m&aacute;i.ch&igrave;a kh&oacute;a ri&ecirc;ng ai như cầu lh:0907074525 a sỹ</p>", now(), now(), 1, 0, 0, 3),
       ("Cho thuê nhà nguyên căn lối đi riêng ! Q.Thủ Đức!", "<p>Ph&ograve;ng mới,&nbsp; rộng v&agrave; tho&aacute;ng mát , y&ecirc;n tĩnh ! ( Như trong h&igrave;nh )- Gồm 1 ph&ograve;ng ngủ lớn,&nbsp; 1 ph&ograve;ng kh&aacute;ch,&nbsp; 1 toilet , bồn tắm ,lang can trước v&agrave; sau tho&aacute;ng m&aacute;t !- wifi miễn ph&iacute; !- hộp box truyền h&igrave;nh kỹ thuật số miễn ph&iacute; !- m&aacute;y nước n&oacute;ng !- khu vực an ninh !- gần chợ,&nbsp; si&ecirc;u thị , gần tạp h&oacute;a v.v..!- khu vực ri&ecirc;ng biệt !- Chỉ cho nữ sinh vi&ecirc;n hoặc nữ c&ocirc;ng nh&acirc;n , nữ nh&acirc;n vi&ecirc;n văn ph&ograve;ng hoặc gia đ&igrave;nh c&ocirc;ng nh&acirc;n vi&ecirc;n chức thu&ecirc; ( gồm 2 vợ&nbsp; chồng v&agrave; con nhỏ&nbsp; ) !&nbsp;- xem l&agrave; th&iacute;ch ngay !- Ph&ograve;ng lớn c&oacute; thể ở nhiều bạn !- ưu ti&ecirc;n : bạn thật th&agrave; v&agrave; hiền l&agrave;nh !- Li&ecirc;n hệ : (A.Ho&agrave;ng )</p>", now(), now(), 1, 0, 0, 3),
       ("CHO SINH VIÊN NỮ THUÊ, PHƯỜNG TRƯỜNG THỌ, QUẬN THỦ ĐỨC", "<p>Ph&ograve;ng c&oacute; g&aacute;c, wc ri&ecirc;ng, 20m2, sạch sẽ, y&ecirc;n tĩnh, gần trườngSư phạm kỹ thuật TP. HCM, điện 200/kw, nước free, &hellip; gi&aacute; 600 ng&agrave;n/th&aacute;ng/1 ph&ograve;ng.<br />LH: 0965 944 614.</p>", now(), now(), 1, 0, 0, 3),
       ("CẦN NAM Ở GHÉP PHÒNG SẠCH SẼ THOÁNG MÁT ĐẦY ĐỦ TIỆN NGHI", "<p>Ph&ograve;ng mới x&acirc;y rộng 38m2, c&oacute; g&aacute;c, tho&aacute;ng m&aacute;t, sạch sẽ, kh&ocirc;ng chung với chủ, lối đi ri&ecirc;ng, giờ ra v&agrave;o tự do, an ninh, c&oacute; Internet c&aacute;p quang FPT 27M, c&oacute; c&aacute;p TV, đầy đủ tiện nghi chỉ cần tới l&agrave; ở, c&aacute;ch đại học sư phạm kỹ thuật 500m, c&aacute;ch đại học ng&acirc;n h&agrave;ng 400m, c&aacute;ch cao đẳng x&acirc;y dựng số 02 1km, c&aacute;ch ng&atilde; tư Thủ Đức 1km, c&aacute;ch trường cao đảng c&ocirc;ng nghệ thủ đức 1,3km,c&aacute;ch trạm xe Busy gần nhất 150m. Y&ecirc;n tĩnh. Kế b&ecirc;n ng&atilde; tư nai v&agrave;ng giao nhau giữa Ho&agrave;ng Diệu Hai v&agrave; đường T&ocirc; Vĩnh Diện, t&iacute;nh c&aacute;ch m&igrave;nh vui vẽ h&ograve;a đồng.Ph&iacute;a trước nh&agrave; c&oacute; ngay một c&ocirc;ng vi&ecirc;n tiện cho c&aacute;c bạn tập thể dục v&agrave; h&oacute;ng m&aacute;t mỗi khi thư gi&atilde;n. li&ecirc;n hệ : 0975828781</p>", now(), now(), 1, 0, 0, 3);

INSERT INTO accomodation(acreage, address, air_conditioner, cabletv, electric_price, heater, internet, motel, parking, price, status, toilet, tv, upstair, water_price, x_coordinate, y_coordinate, district_id, post_id)
VALUES (30, "27/26 Đường số 6, P.Hiệp Bình Chánh, Thủ Đức", 1, 0, 0, 0, 1, 0, 1, 1500000, 1, "KHEP_KIN", 0, 1, 0, 10.831043, 106.717481, 13, 13),
       (150, "59 đường số 27, hiệp bình chánh, thủ đức", 1, 1, 0, 1, 1, 0, 1, 15000000, 1, "KHEP_KIN", 1, 2, 0, 10.833088, 106.732111, 13, 14),
       (50, "99 đường 38 phường hiệp bình chánh thủ đức", 1, 1, 0, 0, 1, 1, 1, 4500000, 1, "CHUA_XAC_DINH", 0, 0, 0, 10.842652, 106.736419, 13, 15),
       (60, "129/17 đường ngô chí quốc, P.bình chiểu Q.Thủ Đức", 0, 1, 3000, 0, 1, 1, 1, 2500000, 1, "KHEP_KIN", 0, 1, 0, 10.881087, 106.721836, 13, 16),
       (20, "1 đường số 4, phường Trường Thọ, quận Thủ Đức", 0, 0, 0, 0, 0, 1, 0, 600000, 1, "CHUA_XAC_DINH", 0, 0, 0, 10.839881, 106.763179, 13, 17),
       (39, "56 Đường số 9, Khu Phố 3, Phường Linh Trung, Quận Thủ Đức, TP Hồ Chí Minh", 0, 1, 4000, 0, 1, 1, 1, 525000, 1, "KHEP_KIN", 0, 1, 6000, 10.857847, 106.768565, 13, 18);


-- -- -- post_id 13
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 13\phong-tro.jpg'), 13);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 13\phong-tro-1.jpg'), 13);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 13\phong-tro-2.jpg'), 13);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 13\phong-tro-3.jpg'), 13);

-- -- -- post_id 14
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 14\phong-tro.jpg'), 14);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 14\phong-tro-1.jpg'), 14);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 14\phong-tro-2.jpg'), 14);

-- -- -- post_id 15
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 15\phong-tro.jpg'), 15);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 15\phong-tro-1.jpg'), 15);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 15\phong-tro-2.jpg'), 15);

-- -- -- post_id 16
-- NULL

-- -- -- post_id 17
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 17\phong-tro.jpg'), 17);

-- -- -- post_id 18
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 18\phong-tro.jpg'), 18);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 18\phong-tro-1.jpg'), 18);

-- -- user_id 4 -- Quận Thủ Đức
INSERT INTO post(title, content, create_at, last_update, approved, not_approved, del, user_id)
VALUES ("Phòng mới xây Quốc Lộ 13 cũ. Hiệp Bình Phước 25m2. 2,5 triệu", "<p>Ph&ograve;ng mới x&acirc;y mới 100%.<br />Nhiều diện t&iacute;ch chọn lựa: 25-40m2 c&oacute; g&aacute;c.<br />Gi&aacute; chỉ từ 2.500.000đ.<br />Đầy đủ thiết bị vệ sinh cao cấp, kh&ocirc;ng gian bếp.<br />Cầu thang gỗ an to&agrave;n cho trẻ nhỏ. Ph&ograve;ng c&oacute; cửa sổ v&agrave; th&ecirc;m quạt h&uacute;t rất tho&aacute;ng m&aacute;t....<br />C&oacute; nh&agrave; xe ri&ecirc;ng. Khu kh&ocirc;ng ngập nước, tho&aacute;ng m&aacute;t y&ecirc;n tĩnh, rất an ninh. C&oacute; bảo vệ 24/24.<br />Điện nước gi&aacute; nh&agrave; nước.<br />Gần trường tiểu học v&agrave; nhiều trường mầm non xung quanh. Ngay khu chợ hiệp b&igrave;nh phước...<br />Tiện đi b&igrave;nh dương, quận 12, g&ograve; vấp, b&igrave;nh thạnh.....<br />Li&ecirc;n hệ: 0908698113 gặp Phương Anh (ch&iacute;nh chủ)</p>", now(), now(), 1, 0, 0 ,4),
       ("Phòng cho thuê mới xây cao cấp trung tâm Thủ Đức", "<p>Nh&agrave; mới x&acirc;y, thiết bị cao cấp, c&oacute; bếp, g&aacute;c lửng, wc ri&ecirc;ng như căn hộ mini, c&oacute; camera, lối đi l&agrave; ban c&ocirc;ng tho&aacute;ng m&aacute;t với vew l&agrave; bầu trời đầy nắng v&agrave; gi&oacute;.<br />Khu vực an ninh tốt, hẻm xe hơi, tiện &iacute;ch xung quanh đầy đủ trường học, chợ, si&ecirc;u thị, bệnh viện..trong b&aacute;n k&iacute;nh 2km. V&agrave;o trung t&acirc;m TP khoảng 15 ph&uacute;t.<br />Lh: 0936493435</p>", now(), now(), 1, 0, 0 ,4),
       ("Phòng trọ cho nữ trên đường Dân Chủ, Quận Thủ Đức, HCM", "<p>Nh&agrave; Trọ gần trường ĐH Sư Phạm Kỹ Thuật, trường Cao Đẳng XD 2, c&oacute; c&aacute;c tuyến xe bu&yacute;t thuận tiện cho c&aacute;c bạn sinh vi&ecirc;n đến l&agrave;ng Đại Học như số 6, 8... S&aacute;t chợ đ&ecirc;m Bắc Ninh. Diện t&iacute;ch s&agrave;n khoảng 20m2 v&agrave; g&aacute;c đ&uacute;c 12m2 như một căn hộ mini nhỏ xinh.<br />Tường ốp gạch men cao 1.5m v&agrave; s&agrave;n l&oacute;t gạch đ&aacute; tho&aacute;ng m&aacute;t men sạch sẽ. Toilet trong ph&ograve;ng ri&ecirc;ng biệt tiện nghi. G&oacute;c bếp nấu ăn được ốp đ&aacute; hoa cương ti&ecirc;n lau dọn v&agrave; thiết kế th&ecirc;m kệ chứa đồ gọn gẽ.<br />Nh&agrave; để xe ri&ecirc;ng biệt c&oacute; camera an ninh 24/24. Chỗ phơi đồ tr&ecirc;n tầng thượng tho&aacute;ng m&aacute;t.<br />WIFI miễn ph&iacute; 24/24.<br />L&agrave; nơi ở l&yacute; tưởng, an to&agrave;n của c&aacute;c bạn sinh vi&ecirc;n nữ v&agrave; giới văn ph&ograve;ng sinh hoạt nghỉ ngơi sau một ng&agrave;y l&agrave;m việc học tập.<br />Li&ecirc;n hệ: Anh Huy 0909.302793 ~ 0763970098</p>", now(), now(), 1, 0, 0 ,4),
       ("PHÒNG CHO THUÊ - YÊN TĨNH - THOÁNG MÁT", "<p>⦁ DT: 20-22 m2. Gi&aacute;: 2.7 triệu - 3 triệu.<br />⦁ Ở tối đa 1-2 người.<br />⦁ Internet: Wifi. Điện, nước t&iacute;nh ri&ecirc;ng.<br />⦁ C&oacute; người dọn vệ sinh h&agrave;ng tuần, m&aacute;y giặt d&ugrave;ng chung, WC ri&ecirc;ng.<br />⦁ Ưu ti&ecirc;n nh&acirc;n vi&ecirc;n văn ph&ograve;ng, c&aacute;c bạn sinh vi&ecirc;n cần sự y&ecirc;n tĩnh để l&agrave;m việc v&agrave; học tập.<br />⦁ Kh&ocirc;ng ở chung với chủ nh&agrave;, c&oacute; người đ&oacute;ng cửa sau 12h00 đ&ecirc;m.<br />Địa chỉ: Hẻm 185 Ng&ocirc; Ch&iacute; Quốc, P. B&igrave;nh Chiểu, Q. Thủ Đức, Tp. Hồ Ch&iacute; Minh.<br />Gần: Chợ Đầu Mối, Khu C&ocirc;ng Nghiệp Linh Trung II, Khu C&ocirc;ng Nghiệp B&igrave;nh Chiểu.<br />Li&ecirc;n hệ: 0918.614.069 hoặc 0933.940.269 (Anh Vũ chủ nh&agrave;).</p>", now(), now(), 1, 0, 0 ,4),
       ("Cho thuê nhà nguyên căn cho gia đình ở", "<p>Cho th&ecirc;u nh&agrave; gia đ&igrave;nh<br />Diện t&iacute;ch 107m c&oacute; s&acirc;n trước, 2 ph&ograve;ng ngủ tolet phong kh&aacute;ch rộng<br />Vị tr&iacute; gần trường học chợ v&agrave; trạm yte<br />Lh: 0934 672076 Nghĩa</p>", now(), now(), 1, 0, 0 ,4),
       ("Nhà cho thuê gần chợ Thủ Đức (2 phút xe máy)", "<p>Nh&agrave; cho thu&ecirc; gần chợ Thủ Đức (2 ph&uacute;t xe m&aacute;y)<br />Hẻm 1 xẹt, c&aacute;ch đường số 9 10 m&eacute;t</p><p>Diện t&iacute;ch 46m2. 1 trệt. 2PN, 2WC, 1 bếp<br />Nội thất đầy đủ: M&aacute;y lạnh, m&aacute;y giặt, tủ lạnh, giường, tủ bếp, bếp gas, kệ....<br />Đ&atilde; gắn sẵn internet, điện nước ri&ecirc;ng</p><p>C&aacute;ch chợ Thủ Đức (2ph xe m&aacute;y)<br />Kế b&ecirc;n UBND phường Trường Thọ, CA Phường, trường học...<br />Khu vực an ninh, y&ecirc;n tĩnh</p><p>Nh&agrave; mới sơn sửa, sạch sẽ, gọn g&agrave;ng<br />Cho thu&ecirc; l&acirc;u d&agrave;i, ưu ti&ecirc;n gia đ&igrave;nh</p><p>LH ch&iacute;nh chủ: A Vũ 0379987879<br />hoangvu2608@yahoo.com</p>", now(), now(), 1, 0, 0 ,4);

INSERT INTO accomodation(acreage, address, air_conditioner, cabletv, electric_price, heater, internet, motel, parking, price, status, toilet, tv, upstair, water_price, x_coordinate, y_coordinate, district_id, post_id)
VALUES (25, "Đường Quốc Lộ 13, Phường Hiệp Bình Phước, Quận Thủ Đức, Hồ Chí Minh", 0, 0, 0, 0, 1, 1, 1, 2500000, 1, "KHEP_KIN", 0, 0, 0, 10.845676, 106.718154, 13, 19),
       (15, "Hẻm 35, Đường 4, Phường Trường Thọ, Quận Thủ Đức, Hồ Chí Minh", 0, 0, 0, 0, 1, 1, 1, 2900000, 1, "KHEP_KIN", 0, 0, 0, 10.835857, 106.759889, 13, 20),
       (15, "45-31 Dân Chủ, Bình Thọ, Thủ Đức, Hồ Chí Minh, Việt Nam", 0, 0, 4000, 0, 1, 1, 1, 1900000, 1, "KHEP_KIN", 0, 0, 5000, 10.846662, 106.765327, 13, 21),
       (22, "Đường Ngô Chí Quốc, Phường Bình Chiểu, Quận Thủ Đức, Hồ Chí Minh", 0, 0, 0, 0, 1, 1, 1, 3000000, 1, "KHEP_KIN", 0, 0, 0, 10.886748, 106.723880, 13, 22),
       (107, "89-81 Đường Hiệp Bình, Hiệp Bình Phước, Thủ Đức, Hồ Chí Minh", 1, 1, 0, 0, 1, 0, 1, 10000000, 1, "KHEP_KIN", 0, 0, 0, 10.846008, 106.724090, 13, 23),
       (46, "132, Đường 9, Phường Trường Thọ, Quận Thủ Đức, Hồ Chí Minh", 1, 1, 0, 0, 1, 0, 1, 7500000, 1, "KHEP_KIN", 1, 0, 0, 10.832358, 106.755900, 13, 24);

-- -- -- post_id 19
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 19\phong-tro.jpg'), 19);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 19\phong-tro-1.jpg'), 19);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 19\phong-tro-2.jpg'), 19);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 19\phong-tro-3.jpg'), 19);

-- -- -- post_id 20
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 20\phong-tro.jpg'), 20);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 20\phong-tro-1.jpg'), 20);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 20\phong-tro-2.jpg'), 20);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 20\phong-tro-3.jpg'), 20);

-- -- -- post_id 21
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 21\phong-tro.jpg'), 21);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 21\phong-tro-1.jpg'), 21);

-- -- -- post_id 22
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 22\phong-tro.jpg'), 22);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 22\phong-tro-1.jpg'), 22);

-- -- -- post_id 23
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 23\phong-tro.jpg'), 23);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 23\phong-tro-1.jpg'), 23);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 23\phong-tro-2.jpg'), 23);

-- -- -- post_id 24
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 24\phong-tro.jpg'), 24);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-1", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 24\phong-tro-1.jpg'), 24);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-2", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 24\phong-tro-2.jpg'), 24);
INSERT INTO image(id, file_name, file_type, data, post_id) VALUES (UUID(), "phong-tro-3", "jpg", LOAD_FILE('C:\Users\Thien Doan\Desktop\image\id 24\phong-tro-3.jpg'), 24);