/*
 Navicat Premium Data Transfer

 Source Server         : DataBase
 Source Server Type    : MySQL
 Source Server Version : 50741
 Source Host           : localhost:3306
 Source Schema         : cake_mange_ssm

 Target Server Type    : MySQL
 Target Server Version : 50741
 File Encoding         : 65001

 Date: 27/02/2023 22:36:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cake
-- ----------------------------
DROP TABLE IF EXISTS `cake`;
CREATE TABLE `cake`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cake
-- ----------------------------
INSERT INTO `cake` VALUES (1, 'auth-img2.png', '蛋挞', 3.00, 5, '蛋挞是一种以蛋浆做成馅料的西式馅饼；塔为“tart”的粤语音译，指馅料外露之馅饼，而馅料为饼皮密封之西式馅饼则为pie（派）。');
INSERT INTO `cake` VALUES (2, 'bika.png', '榴莲千层', 14.50, 5, '好喜欢千层蛋糕软绵的口感，和入口的多层次感特别是榴莲千层蛋糕，对于超级无敌喜欢榴莲的我来说，简直就是幸福和满足的代名词');
INSERT INTO `cake` VALUES (3, 'bilibili.jpg', '圣代', 3.50, 5, '圣代（英语：sundae，香港称为新地）是在冰淇淋上浇上水果酱或糖浆的甜品，有时也会放上一些碎坚果、巧克力末、奶油、樱桃等');
INSERT INTO `cake` VALUES (4, 'loading.gif', '老婆饼', 2.50, 5, '老婆饼，又名为冬蓉酥，是一款发源于广东的传统饼食，在中国广东和香港最为常见，在台湾亦可找到。[1]老婆饼呈圆形，外层是一层酥皮，里面则是冬瓜蓉以及熟糯米粉，原本冬瓜蓉淡而无味，加上糖后便会呈现甜味。');
INSERT INTO `cake` VALUES (5, 'auth-img1.png', '菠萝包', 5.00, 5, '菠萝包，亦称菠萝面包、酥皮面包，是一种甜味面包，没有馅料，源于香港，约于1960年代出现。因为菠萝包经烘焙过后表面金黄色、凹凸的脆皮状似菠萝（亦称“凤梨”）因而得名');
INSERT INTO `cake` VALUES (6, '008.jpg', '吐司', 10.00, 5, '吐司（英语：toast），也称烤面包片，或者译为多士，指使用小麦烘烤的面包，是最常见的一种西式面包。在粤语，“方包”指未烤吐司。在欧式早餐中常见，配以牛奶、豆浆适合早餐食用。');
INSERT INTO `cake` VALUES (7, '006.jpg', '三明治', 6.99, 5, '三明治（英語：Sandwich）是指一切在兩片以上的麵包或薄餅中間放置餡料如肉、乾酪或蔬菜等食物，加上調味料、醬汁任意搭配在一起的料理[1]。其中的麵包經常會塗上少许沙拉醬、奶油、花生醬、調味油或其他調味料烘烤以改善味道和口感。三明治食用及携带方便，經常作為正餐或郊游、遠足、旅行时的餐點。');
INSERT INTO `cake` VALUES (8, '004.png', '泡芙', 16.50, 5, '泡芙（Profiterole / Cream Puff），台湾又称「奶油空心饼」[1]，是一种源自法国的球形糕點。常見的泡芙会从蓬松张孔的面皮中包裹鮮忌廉、巧克力或冰淇淋。');
INSERT INTO `cake` VALUES (9, '010.jpg', '芝士雪豹', 15.00, 5, '菠萝包，亦称菠萝面包、酥皮面包，是一种甜味面包，没有馅料，源于香港，约于1960年代出现。因为菠萝包经烘焙过后表面金黄色、凹凸的脆皮状似菠萝（亦称“凤梨”）因而得名');
INSERT INTO `cake` VALUES (10, '009.jpg', '檽米丸子', 8.00, 5, '泡芙（Profiterole / Cream Puff），台湾又称「奶油空心饼」[1]，是一种源自法国的球形糕點。常見的泡芙会从蓬松张孔的面皮中包裹鮮忌廉、巧克力或冰淇淋。');
INSERT INTO `cake` VALUES (12, 'bika.png', '芝士牛奶', 16.50, 5, '圣代（英语：sundae，香港称为新地）是在冰淇淋上浇上水果酱或糖浆的甜品，有时也会放上一些碎坚果、巧克力末、奶油、樱桃等');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (58, 1, 5);
INSERT INTO `cart` VALUES (59, 1, 5);
INSERT INTO `cart` VALUES (60, 1, 5);
INSERT INTO `cart` VALUES (61, 4, 6);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `order_number` int(11) NULL DEFAULT NULL,
  `total` double NULL DEFAULT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`order_id`, `time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 5, 5, 55.5, '2022-12-04 02:33:14');
INSERT INTO `order` VALUES (4, 5, 2, 7.5, '2022-12-04 12:11:02');
INSERT INTO `order` VALUES (7, 5, 2, 8.5, '2022-12-04 15:31:02');
INSERT INTO `order` VALUES (8, 9, 1, 5, '2022-12-04 20:08:09');
INSERT INTO `order` VALUES (9, 7, 4, 34.5, '2022-12-04 20:12:03');
INSERT INTO `order` VALUES (10, 7, 1, 5, '2022-12-04 20:12:13');
INSERT INTO `order` VALUES (11, 8, 3, 23.99, '2022-12-04 21:49:26');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for profile
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile`  (
  `id` int(11) NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES (5, '15073107407', 109, '曾超群', '湖南长沙');
INSERT INTO `profile` VALUES (6, '18153337457', 51, '夏瑞芳', '涵虚楼B多1');
INSERT INTO `profile` VALUES (7, '15580959328', 22, '陈静', '涵虚楼C多1');
INSERT INTO `profile` VALUES (8, '13037316625', 26, '李龙恩', '汇泽426');
INSERT INTO `profile` VALUES (9, '15580959328', 45, '空调承太郎', '星辰十字军');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `unique_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (4, 'admin', 'admin', '$2a$10$DN1j2VF6BisiAegmoyg12.sFurok7DEuME2JGAaQV18khgNlIHNRy');
INSERT INTO `users` VALUES (5, 'ciaociao', 'user', '$2a$10$id6qlpf2XX21gye1pb11U.MyGhJgV0XBFZQx22aYCkb9kTyOUKcUm');
INSERT INTO `users` VALUES (6, 'test', 'user', '$2a$10$BqePmoSq6aytLp8E4Yj.j.cnF2IhD5KSnmeSWwyKD8xc3rF.tiYUe');
INSERT INTO `users` VALUES (7, 'SAKURA', 'user', '$2a$10$neGHPIAMmxPtDOaW9GV.8.zlTXpGc8jge20ZCUrZUvVMZQvcT4Uj.');
INSERT INTO `users` VALUES (8, 'hana', 'user', '$2a$10$l6m15PlYCArsYhLCjni1we3.2aI75ZoTWsSPRMBUY6195XD3Np/xa');
INSERT INTO `users` VALUES (9, 'jojo', 'user', '$2a$10$AdnXYqbt0Wv7qLUwpcIiHOBwRG7hIfWL6z1enMNojOHfloNqcqat6');

-- ----------------------------
-- Triggers structure for table cake
-- ----------------------------
DROP TRIGGER IF EXISTS `del_cake`;
delimiter ;;
CREATE TRIGGER `del_cake` BEFORE DELETE ON `cake` FOR EACH ROW DELETE FROM cart WHERE pid = old.pid
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table users
-- ----------------------------
DROP TRIGGER IF EXISTS `del_user`;
delimiter ;;
CREATE TRIGGER `del_user` BEFORE DELETE ON `users` FOR EACH ROW DELETE FROM cart WHERE uid=old.uid
;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
