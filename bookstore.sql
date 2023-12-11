/*
 Navicat Premium Data Transfer

 Source Server         : grape
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 11/12/2023 13:54:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` float NULL DEFAULT NULL,
  `discount` float NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `book_concern` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `publish_date` date NULL DEFAULT NULL,
  `brief` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 1, 'VC++深入详解', '孙鑫', 168, 0.95, '/api/img/vc++.jpg', '电子工业出版社', '2019-06-01', 'vc++', 6);
INSERT INTO `book` VALUES (2, 2, 'JAVA编程思想', 'Bruce Eckel', 108, 0.5, '/api/img/javathinking.jpg', '电子工业出版社', '2008-09-01', 'java thinking', 9);
INSERT INTO `book` VALUES (3, 3, 'Vue3入门到入土', '孙鑫', 99.8, 0.75, '/api/img/vuejs30.jpg', '水利水电出版社', '2021-05-01', '    vuejs30书籍', 3);
INSERT INTO `book` VALUES (4, 1909782525, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (5, 289248797, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (6, 1950777779, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (7, 109856855, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (8, 467879696, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (9, 1540689541, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (10, 1998030496, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (11, 531012923, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (12, 1706152928, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (13, 1344518143, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (14, 120007384, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (15, 127101605, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (16, 1425296545, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (17, 672532798, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (18, 795744312, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (19, 1675133243, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (20, 1271770393, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (21, 152201619, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (22, 1851286631, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (23, 795744312, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '清华大学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (24, 795744312, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '春风出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (25, 795744312, '三国演义', '罗贯中', 39.5, 0.65, '/api/img/sanguo.jpg', '人民文学出版社', '2023-09-01', '作者通过集中描绘三国时代各封建统治集团之间的政治、军事、外交斗争，揭示了东汉末年社会的动荡和黑暗，谴责了封建统治者的暴虐，反映了民众的苦难和他们呼唤明君、呼唤安定的强烈愿望。', 4);
INSERT INTO `book` VALUES (26, 26, '活着', '余华', 67, 0.5, '/api/img/huozhe.jpg', '作家出版社', '2023-02-23', '好看 爱看', 4);
INSERT INTO `book` VALUES (27, 27, 'Modern C++', 'Scott', 345, 0.5, '/api/img/c2.jpg', '随便出版社', '1987-07-14', '很好看 孩子看了眼泪掉地上', 6);
INSERT INTO `book` VALUES (28, 28, 'c111', 'wpziji', 324, 0.9, '/api/img/c1.jpg', '爱马仕出版社', '2023-11-21', '葡萄干了就是葡萄干', 3);

-- ----------------------------
-- Table structure for bookcategory
-- ----------------------------
DROP TABLE IF EXISTS `bookcategory`;
CREATE TABLE `bookcategory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookcategory
-- ----------------------------
INSERT INTO `bookcategory` VALUES (1, 1, 'JAVA EE', 0);
INSERT INTO `bookcategory` VALUES (2, 2, '程序设计', 0);
INSERT INTO `bookcategory` VALUES (3, 3, 'Servlet/JSP', 1);
INSERT INTO `bookcategory` VALUES (4, 4, '应用服务器', 1);
INSERT INTO `bookcategory` VALUES (5, 5, 'MVC框架', 1);
INSERT INTO `bookcategory` VALUES (6, 6, 'C/C++', 2);
INSERT INTO `bookcategory` VALUES (7, 7, 'C11', 6);
INSERT INTO `bookcategory` VALUES (8, 8, 'C#', 2);
INSERT INTO `bookcategory` VALUES (9, 9, 'JAVA', 2);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `comment_date` datetime NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, '本书是VC深入详解第三版，内容基于VS2017', '2019-11-12 12:11:00', 1, 1);
INSERT INTO `comment` VALUES (2, 2, '书收到了，快递非常快，书的质量很好，谢谢你们', '2019-09-14 00:00:00', 2, 2);
INSERT INTO `comment` VALUES (3, 3, '这个是接收Vuejs的书籍，很好', '2022-10-10 12:01:00', 1, 3);
INSERT INTO `comment` VALUES (4, 4, 'VUEJS is GOOD！！！', '2022-10-12 00:25:00', 2, 1);

-- ----------------------------
-- Table structure for hotbook
-- ----------------------------
DROP TABLE IF EXISTS `hotbook`;
CREATE TABLE `hotbook`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotbook
-- ----------------------------
INSERT INTO `hotbook` VALUES (1, 1);
INSERT INTO `hotbook` VALUES (3, 3);
INSERT INTO `hotbook` VALUES (26, 26);
INSERT INTO `hotbook` VALUES (27, 27);

-- ----------------------------
-- Table structure for newbook
-- ----------------------------
DROP TABLE IF EXISTS `newbook`;
CREATE TABLE `newbook`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newbook
-- ----------------------------
INSERT INTO `newbook` VALUES (1, 1);
INSERT INTO `newbook` VALUES (2, 2);
INSERT INTO `newbook` VALUES (4, 1909782525);
INSERT INTO `newbook` VALUES (26, 26);
INSERT INTO `newbook` VALUES (27, 27);

-- ----------------------------
-- Table structure for teachbook
-- ----------------------------
DROP TABLE IF EXISTS `teachbook`;
CREATE TABLE `teachbook`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachbook
-- ----------------------------
INSERT INTO `teachbook` VALUES (2, 2);
INSERT INTO `teachbook` VALUES (3, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `mobile` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('zhangsan', 'zhangsan@qq.com', '123456', '2022-10-12 00:00:00', 1, '13333333333', 3, 'user');
INSERT INTO `user` VALUES ('李四', 'ls@gdpu.com', '123456', '2022-10-12 00:00:00', 2, '18888888888', 4, 'user');
INSERT INTO `user` VALUES ('王五', 'ww@aa.com', '123456', '2023-09-18 00:00:00', 3, '12222222222', 5, 'admin');
INSERT INTO `user` VALUES ('lisi', 'example@example.com', '123456', '2023-10-02 11:20:09', 125530320, '13912345678', 12, 'user');
INSERT INTO `user` VALUES ('test', 'example@example.com', '123456', '2023-11-30 08:41:35', 921512226, '123456', 14, 'user');
INSERT INTO `user` VALUES ('test2', 'example@example.com', 'test2', '2023-11-30 08:42:21', 129691147, '123456', 15, 'user');
INSERT INTO `user` VALUES ('test3', 'example@example.com', '123', '2023-11-30 08:43:39', 545826645, '123', 16, 'user');
INSERT INTO `user` VALUES ('test4', 'example@example.com', '123', '2023-11-30 09:59:33', 114322607, '123', 17, 'user');
INSERT INTO `user` VALUES ('test5', 'example@example.com', '123', '2023-11-30 10:00:40', 244756769, '123', 18, 'user');
INSERT INTO `user` VALUES ('test7', 'example@example.com', '123', '2023-11-30 10:17:03', 175075116, '123', 19, 'user');
INSERT INTO `user` VALUES ('123456', 'example@example.com', '123456', '2023-12-06 14:51:56', 140310363, '123456', 20, 'user');
INSERT INTO `user` VALUES ('123123', 'example@example.com', '123456', '2023-12-09 20:25:42', 104904948, '123456', 21, 'user');

SET FOREIGN_KEY_CHECKS = 1;
