DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `criteria`;
CREATE TABLE `criteria`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `district_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `motel` bit(1) NOT NULL,
  `stop` bit(1) NOT NULL,
  `price_start` double NOT NULL,
  `price_end` double NOT NULL,
  `acreage_start` double NOT NULL,
  `acreage_end` double NOT NULL,
  `create_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKoiqm9rfwl0j4o349q2gqn7n20`(`district_id`) USING BTREE,
  INDEX `FKq7e8qgeirqpqadbcb2pqmsupi`(`user_id`) USING BTREE,
  CONSTRAINT `FK_district_criteria` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_user_criteria` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- SET FOREIGN_KEY_CHECKS = 1;
--
-- INSERT INTO criteria(district_id, motel, stop, user_id, price_start, price_end, acreage_start, acreage_end, create_at)
-- VALUES (1, 1, 0, 2, 3000000, 10000000, 20, 40, now());
-- INSERT INTO criteria(district_id, motel, stop, user_id, price_start, price_end, acreage_start, acreage_end, create_at)
-- VALUES (13, 0, 0, 1, 1000000, 3000000, 10, 35, now());

CREATE TABLE `notification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `criteria_id` bigint(20) NULL DEFAULT NULL,
  `seen` bit(1) NOT NULL,
  `create_at` datetime(0) NULL DEFAULT NULL,
  `notification_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKoiqm9rfwl0j4o349q2gqn7n21`(`post_id`) USING BTREE,
  INDEX `FKq7e8qgeirqpqadbcb2pqmsupo`(`user_id`) USING BTREE,
  INDEX `FKb7bq3ifinxseoia87hja6slay`(`criteria_id`) USING BTREE,
  CONSTRAINT `FK_criteria_notification` FOREIGN KEY (`criteria_id`) REFERENCES `criteria` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_post_notification` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_user_notification` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;
-- SET FOREIGN_KEY_CHECKS = 1;
