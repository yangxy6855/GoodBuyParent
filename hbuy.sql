/*
Navicat MySQL Data Transfer

Source Server         : 本地-yxy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hbuy

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-02 17:19:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_menus
-- ----------------------------
DROP TABLE IF EXISTS `admin_menus`;
CREATE TABLE `admin_menus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `text` varchar(20) DEFAULT NULL COMMENT '菜单名',
  `iconCls` varchar(20) DEFAULT NULL COMMENT '图标名',
  `url` varchar(200) DEFAULT NULL COMMENT '跳转地址',
  `state` varchar(10) DEFAULT 'open' COMMENT '菜单展开状态',
  `parentId` bigint(20) DEFAULT '0' COMMENT '父节点',
  `flag` varchar(2) DEFAULT '0' COMMENT '1是授权模块  0非授权模块',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_menus
-- ----------------------------
INSERT INTO `admin_menus` VALUES ('1', '前台菜单管理', 'icon-system', null, 'closed', '0', '0');
INSERT INTO `admin_menus` VALUES ('2', '横向菜单', 'icon-ok', 'hxMenu.jsp', 'open', '1', '0');
INSERT INTO `admin_menus` VALUES ('3', '纵向菜单', 'icon-manager', 'http://www.sina.com', 'open', '1', '0');
INSERT INTO `admin_menus` VALUES ('4', '轮播管理', 'icon-house', null, 'closed', '0', '0');
INSERT INTO `admin_menus` VALUES ('5', '查看轮播图', 'icon-search', 'showBanners.jsp', 'open', '4', '0');
INSERT INTO `admin_menus` VALUES ('6', '权限管理', 'icon-login', null, 'closed', '0', '1');
INSERT INTO `admin_menus` VALUES ('7', '用户信息', 'icon-search', 'showSystemUser.jsp', 'open', '6', '1');
INSERT INTO `admin_menus` VALUES ('8', '授予权限', 'icon-group', '#', 'open', '6', '1');
INSERT INTO `admin_menus` VALUES ('9', '回收权限', 'icon-cancel', '#', 'open', '6', '1');

-- ----------------------------
-- Table structure for admin_users
-- ----------------------------
DROP TABLE IF EXISTS `admin_users`;
CREATE TABLE `admin_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(40) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(40) DEFAULT NULL COMMENT '密码',
  `isRoot` varchar(2) DEFAULT '0' COMMENT '1超级管理员，0普通管理员',
  `updateTime` datetime DEFAULT NULL COMMENT '账号最新变动时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_users
-- ----------------------------
INSERT INTO `admin_users` VALUES ('1', 'admin', '123456', '1', '2018-11-02 08:42:59');
INSERT INTO `admin_users` VALUES ('5', 'zhangsan', '123456', '0', '2019-02-15 11:23:37');
INSERT INTO `admin_users` VALUES ('7', 'wangwu', '123456', '0', '2019-02-15 11:27:46');

-- ----------------------------
-- Table structure for admin_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_authority`;
CREATE TABLE `admin_user_authority` (
  `userId` bigint(20) DEFAULT NULL COMMENT '后台用户主键',
  `menuId` bigint(20) DEFAULT NULL COMMENT '后台菜单主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user_authority
-- ----------------------------
INSERT INTO `admin_user_authority` VALUES ('1', '1');
INSERT INTO `admin_user_authority` VALUES ('1', '2');
INSERT INTO `admin_user_authority` VALUES ('1', '4');
INSERT INTO `admin_user_authority` VALUES ('1', '5');
INSERT INTO `admin_user_authority` VALUES ('1', '3');
INSERT INTO `admin_user_authority` VALUES ('1', '6');
INSERT INTO `admin_user_authority` VALUES ('1', '7');
INSERT INTO `admin_user_authority` VALUES ('1', '8');
INSERT INTO `admin_user_authority` VALUES ('1', '9');
INSERT INTO `admin_user_authority` VALUES ('5', '1');
INSERT INTO `admin_user_authority` VALUES ('5', '2');
INSERT INTO `admin_user_authority` VALUES ('7', '1');
INSERT INTO `admin_user_authority` VALUES ('7', '3');
INSERT INTO `admin_user_authority` VALUES ('7', '4');
INSERT INTO `admin_user_authority` VALUES ('7', '5');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uName` varchar(40) DEFAULT NULL COMMENT '用户名',
  `age` int(11) DEFAULT NULL COMMENT '年龄'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('test1', '19');
INSERT INTO `users` VALUES ('test2', '90');
INSERT INTO `users` VALUES ('test3', '95');
INSERT INTO `users` VALUES ('test4', '3');
INSERT INTO `users` VALUES ('test5', '32');
INSERT INTO `users` VALUES ('test6', '50');
INSERT INTO `users` VALUES ('test7', '54');
INSERT INTO `users` VALUES ('test8', '21');
INSERT INTO `users` VALUES ('test9', '44');
INSERT INTO `users` VALUES ('test10', '59');
INSERT INTO `users` VALUES ('test11', '63');
INSERT INTO `users` VALUES ('test12', '38');
INSERT INTO `users` VALUES ('test13', '1');
INSERT INTO `users` VALUES ('test14', '93');
INSERT INTO `users` VALUES ('test15', '62');
INSERT INTO `users` VALUES ('test16', '32');
INSERT INTO `users` VALUES ('test17', '76');
INSERT INTO `users` VALUES ('test18', '83');
INSERT INTO `users` VALUES ('test19', '89');
INSERT INTO `users` VALUES ('test20', '93');
INSERT INTO `users` VALUES ('test21', '2');
INSERT INTO `users` VALUES ('test22', '31');
INSERT INTO `users` VALUES ('test23', '47');
INSERT INTO `users` VALUES ('test24', '44');
INSERT INTO `users` VALUES ('test25', '80');
INSERT INTO `users` VALUES ('test26', '69');
INSERT INTO `users` VALUES ('test27', '5');
INSERT INTO `users` VALUES ('test28', '17');
INSERT INTO `users` VALUES ('test29', '73');
INSERT INTO `users` VALUES ('test30', '13');
INSERT INTO `users` VALUES ('test31', '47');
INSERT INTO `users` VALUES ('test32', '98');
INSERT INTO `users` VALUES ('test33', '47');
INSERT INTO `users` VALUES ('test34', '42');
INSERT INTO `users` VALUES ('test35', '68');
INSERT INTO `users` VALUES ('test36', '17');
INSERT INTO `users` VALUES ('test37', '79');
INSERT INTO `users` VALUES ('test38', '44');
INSERT INTO `users` VALUES ('test39', '83');
INSERT INTO `users` VALUES ('test40', '85');
INSERT INTO `users` VALUES ('test41', '78');
INSERT INTO `users` VALUES ('test42', '36');
INSERT INTO `users` VALUES ('test43', '45');
INSERT INTO `users` VALUES ('test44', '16');
INSERT INTO `users` VALUES ('test45', '45');
INSERT INTO `users` VALUES ('test46', '80');
INSERT INTO `users` VALUES ('test47', '65');
INSERT INTO `users` VALUES ('test48', '84');
INSERT INTO `users` VALUES ('test49', '28');
INSERT INTO `users` VALUES ('test50', '86');
INSERT INTO `users` VALUES ('test51', '48');
INSERT INTO `users` VALUES ('test52', '81');
INSERT INTO `users` VALUES ('test53', '61');
INSERT INTO `users` VALUES ('test54', '62');
INSERT INTO `users` VALUES ('test55', '27');
INSERT INTO `users` VALUES ('test56', '49');
INSERT INTO `users` VALUES ('test57', '64');
INSERT INTO `users` VALUES ('test58', '74');
INSERT INTO `users` VALUES ('test59', '79');
INSERT INTO `users` VALUES ('test60', '74');
INSERT INTO `users` VALUES ('test61', '31');
INSERT INTO `users` VALUES ('test62', '36');
INSERT INTO `users` VALUES ('test63', '88');
INSERT INTO `users` VALUES ('test64', '32');
INSERT INTO `users` VALUES ('test65', '96');
INSERT INTO `users` VALUES ('test66', '85');
INSERT INTO `users` VALUES ('test67', '39');
INSERT INTO `users` VALUES ('test68', '37');
INSERT INTO `users` VALUES ('test69', '72');
INSERT INTO `users` VALUES ('test70', '49');
INSERT INTO `users` VALUES ('test71', '27');
INSERT INTO `users` VALUES ('test72', '89');
INSERT INTO `users` VALUES ('test73', '67');
INSERT INTO `users` VALUES ('test74', '67');
INSERT INTO `users` VALUES ('test75', '35');
INSERT INTO `users` VALUES ('test76', '74');
INSERT INTO `users` VALUES ('test77', '67');
INSERT INTO `users` VALUES ('test78', '11');
INSERT INTO `users` VALUES ('test79', '54');
INSERT INTO `users` VALUES ('test80', '39');
INSERT INTO `users` VALUES ('test81', '33');
INSERT INTO `users` VALUES ('test82', '49');
INSERT INTO `users` VALUES ('test83', '45');
INSERT INTO `users` VALUES ('test84', '81');
INSERT INTO `users` VALUES ('test85', '69');
INSERT INTO `users` VALUES ('test86', '3');
INSERT INTO `users` VALUES ('test87', '8');
INSERT INTO `users` VALUES ('test88', '33');
INSERT INTO `users` VALUES ('test89', '40');
INSERT INTO `users` VALUES ('test90', '1');
INSERT INTO `users` VALUES ('test91', '85');
INSERT INTO `users` VALUES ('test92', '25');
INSERT INTO `users` VALUES ('test93', '70');
INSERT INTO `users` VALUES ('test94', '77');
INSERT INTO `users` VALUES ('test95', '75');
INSERT INTO `users` VALUES ('test96', '43');
INSERT INTO `users` VALUES ('test97', '91');
INSERT INTO `users` VALUES ('test98', '25');
INSERT INTO `users` VALUES ('test99', '55');
INSERT INTO `users` VALUES ('test100', '1');
INSERT INTO `users` VALUES ('test101', '40');
INSERT INTO `users` VALUES ('test102', '97');
INSERT INTO `users` VALUES ('test103', '64');
INSERT INTO `users` VALUES ('test104', '30');
INSERT INTO `users` VALUES ('test105', '59');
INSERT INTO `users` VALUES ('test106', '4');
INSERT INTO `users` VALUES ('test107', '46');
INSERT INTO `users` VALUES ('test108', '18');
INSERT INTO `users` VALUES ('test109', '53');
INSERT INTO `users` VALUES ('test110', '12');
INSERT INTO `users` VALUES ('test111', '2');
INSERT INTO `users` VALUES ('test112', '74');
INSERT INTO `users` VALUES ('test113', '66');
INSERT INTO `users` VALUES ('test114', '8');
INSERT INTO `users` VALUES ('test115', '43');
INSERT INTO `users` VALUES ('test116', '91');
INSERT INTO `users` VALUES ('test117', '25');
INSERT INTO `users` VALUES ('test118', '54');
INSERT INTO `users` VALUES ('test119', '94');
INSERT INTO `users` VALUES ('test120', '9');
INSERT INTO `users` VALUES ('test121', '65');
INSERT INTO `users` VALUES ('test122', '96');
INSERT INTO `users` VALUES ('test123', '85');
INSERT INTO `users` VALUES ('test124', '37');
INSERT INTO `users` VALUES ('test125', '32');
INSERT INTO `users` VALUES ('test126', '48');
INSERT INTO `users` VALUES ('test127', '44');
INSERT INTO `users` VALUES ('test128', '76');
INSERT INTO `users` VALUES ('test129', '48');
INSERT INTO `users` VALUES ('test130', '15');
INSERT INTO `users` VALUES ('test131', '30');
INSERT INTO `users` VALUES ('test132', '5');
INSERT INTO `users` VALUES ('test133', '37');
INSERT INTO `users` VALUES ('test134', '70');
INSERT INTO `users` VALUES ('test135', '38');
INSERT INTO `users` VALUES ('test136', '82');
INSERT INTO `users` VALUES ('test137', '98');
INSERT INTO `users` VALUES ('test138', '43');
INSERT INTO `users` VALUES ('test139', '23');
INSERT INTO `users` VALUES ('test140', '87');
INSERT INTO `users` VALUES ('test141', '67');
INSERT INTO `users` VALUES ('test142', '74');
INSERT INTO `users` VALUES ('test143', '71');
INSERT INTO `users` VALUES ('test144', '30');
INSERT INTO `users` VALUES ('test145', '41');
INSERT INTO `users` VALUES ('test146', '14');
INSERT INTO `users` VALUES ('test147', '46');
INSERT INTO `users` VALUES ('test148', '90');
INSERT INTO `users` VALUES ('test149', '12');
INSERT INTO `users` VALUES ('test150', '91');
INSERT INTO `users` VALUES ('test151', '20');
INSERT INTO `users` VALUES ('test152', '29');
INSERT INTO `users` VALUES ('test153', '83');
INSERT INTO `users` VALUES ('test154', '31');
INSERT INTO `users` VALUES ('test155', '3');
INSERT INTO `users` VALUES ('test156', '25');
INSERT INTO `users` VALUES ('test157', '15');
INSERT INTO `users` VALUES ('test158', '0');
INSERT INTO `users` VALUES ('test159', '58');
INSERT INTO `users` VALUES ('test160', '90');
INSERT INTO `users` VALUES ('test161', '77');
INSERT INTO `users` VALUES ('test162', '13');
INSERT INTO `users` VALUES ('test163', '37');
INSERT INTO `users` VALUES ('test164', '45');
INSERT INTO `users` VALUES ('test165', '14');
INSERT INTO `users` VALUES ('test166', '34');
INSERT INTO `users` VALUES ('test167', '31');
INSERT INTO `users` VALUES ('test168', '53');
INSERT INTO `users` VALUES ('test169', '72');
INSERT INTO `users` VALUES ('test170', '1');
INSERT INTO `users` VALUES ('test171', '88');
INSERT INTO `users` VALUES ('test172', '40');
INSERT INTO `users` VALUES ('test173', '35');
INSERT INTO `users` VALUES ('test174', '57');
INSERT INTO `users` VALUES ('test175', '80');
INSERT INTO `users` VALUES ('test176', '31');
INSERT INTO `users` VALUES ('test177', '16');
INSERT INTO `users` VALUES ('test178', '88');
INSERT INTO `users` VALUES ('test179', '89');
INSERT INTO `users` VALUES ('test180', '85');
INSERT INTO `users` VALUES ('test181', '58');
INSERT INTO `users` VALUES ('test182', '35');
INSERT INTO `users` VALUES ('test183', '3');
INSERT INTO `users` VALUES ('test184', '7');
INSERT INTO `users` VALUES ('test185', '30');
INSERT INTO `users` VALUES ('test186', '28');
INSERT INTO `users` VALUES ('test187', '51');
INSERT INTO `users` VALUES ('test188', '69');
INSERT INTO `users` VALUES ('test189', '96');
INSERT INTO `users` VALUES ('test190', '70');
INSERT INTO `users` VALUES ('test191', '65');
INSERT INTO `users` VALUES ('test192', '14');
INSERT INTO `users` VALUES ('test193', '75');
INSERT INTO `users` VALUES ('test194', '34');
INSERT INTO `users` VALUES ('test195', '45');
INSERT INTO `users` VALUES ('test196', '23');
INSERT INTO `users` VALUES ('test197', '80');
INSERT INTO `users` VALUES ('test198', '31');
INSERT INTO `users` VALUES ('test199', '16');
INSERT INTO `users` VALUES ('test200', '86');
INSERT INTO `users` VALUES ('test201', '82');
INSERT INTO `users` VALUES ('test202', '56');
INSERT INTO `users` VALUES ('test203', '31');
INSERT INTO `users` VALUES ('test204', '88');
INSERT INTO `users` VALUES ('test205', '49');
INSERT INTO `users` VALUES ('test206', '83');
INSERT INTO `users` VALUES ('test207', '67');
INSERT INTO `users` VALUES ('test208', '84');
INSERT INTO `users` VALUES ('test209', '23');
INSERT INTO `users` VALUES ('test210', '63');
INSERT INTO `users` VALUES ('test211', '47');
INSERT INTO `users` VALUES ('test212', '45');
INSERT INTO `users` VALUES ('test213', '83');
INSERT INTO `users` VALUES ('test214', '83');
INSERT INTO `users` VALUES ('test215', '65');
INSERT INTO `users` VALUES ('test216', '79');
INSERT INTO `users` VALUES ('test217', '0');
INSERT INTO `users` VALUES ('test218', '61');
INSERT INTO `users` VALUES ('test219', '8');
INSERT INTO `users` VALUES ('test220', '57');
INSERT INTO `users` VALUES ('test221', '63');
INSERT INTO `users` VALUES ('test222', '42');
INSERT INTO `users` VALUES ('test223', '24');
INSERT INTO `users` VALUES ('test224', '94');
INSERT INTO `users` VALUES ('test225', '97');
INSERT INTO `users` VALUES ('test226', '4');
INSERT INTO `users` VALUES ('test227', '31');
INSERT INTO `users` VALUES ('test228', '44');
INSERT INTO `users` VALUES ('test229', '24');
INSERT INTO `users` VALUES ('test230', '92');
INSERT INTO `users` VALUES ('test231', '87');
INSERT INTO `users` VALUES ('test232', '61');
INSERT INTO `users` VALUES ('test233', '44');
INSERT INTO `users` VALUES ('test234', '39');
INSERT INTO `users` VALUES ('test235', '63');
INSERT INTO `users` VALUES ('test236', '96');
INSERT INTO `users` VALUES ('test237', '93');
INSERT INTO `users` VALUES ('test238', '79');
INSERT INTO `users` VALUES ('test239', '14');
INSERT INTO `users` VALUES ('test240', '36');
INSERT INTO `users` VALUES ('test241', '38');
INSERT INTO `users` VALUES ('test242', '81');
INSERT INTO `users` VALUES ('test243', '94');
INSERT INTO `users` VALUES ('test244', '27');
INSERT INTO `users` VALUES ('test245', '52');
INSERT INTO `users` VALUES ('test246', '78');
INSERT INTO `users` VALUES ('test247', '38');
INSERT INTO `users` VALUES ('test248', '56');
INSERT INTO `users` VALUES ('test249', '64');
INSERT INTO `users` VALUES ('test250', '55');
INSERT INTO `users` VALUES ('test251', '84');
INSERT INTO `users` VALUES ('test252', '56');
INSERT INTO `users` VALUES ('test253', '25');
INSERT INTO `users` VALUES ('test254', '61');
INSERT INTO `users` VALUES ('test255', '29');
INSERT INTO `users` VALUES ('test256', '64');
INSERT INTO `users` VALUES ('test257', '34');
INSERT INTO `users` VALUES ('test258', '78');
INSERT INTO `users` VALUES ('test259', '89');
INSERT INTO `users` VALUES ('test260', '11');
INSERT INTO `users` VALUES ('test261', '86');
INSERT INTO `users` VALUES ('test262', '1');
INSERT INTO `users` VALUES ('test263', '44');
INSERT INTO `users` VALUES ('test264', '19');
INSERT INTO `users` VALUES ('test265', '66');
INSERT INTO `users` VALUES ('test266', '70');
INSERT INTO `users` VALUES ('test267', '55');
INSERT INTO `users` VALUES ('test268', '66');
INSERT INTO `users` VALUES ('test269', '65');
INSERT INTO `users` VALUES ('test270', '28');
INSERT INTO `users` VALUES ('test271', '44');
INSERT INTO `users` VALUES ('test272', '38');
INSERT INTO `users` VALUES ('test273', '57');
INSERT INTO `users` VALUES ('test274', '71');
INSERT INTO `users` VALUES ('test275', '85');
INSERT INTO `users` VALUES ('test276', '13');
INSERT INTO `users` VALUES ('test277', '11');
INSERT INTO `users` VALUES ('test278', '17');
INSERT INTO `users` VALUES ('test279', '53');
INSERT INTO `users` VALUES ('test280', '16');
INSERT INTO `users` VALUES ('test281', '18');
INSERT INTO `users` VALUES ('test282', '43');
INSERT INTO `users` VALUES ('test283', '62');
INSERT INTO `users` VALUES ('test284', '83');
INSERT INTO `users` VALUES ('test285', '29');
INSERT INTO `users` VALUES ('test286', '95');
INSERT INTO `users` VALUES ('test287', '90');
INSERT INTO `users` VALUES ('test288', '64');
INSERT INTO `users` VALUES ('test289', '50');
INSERT INTO `users` VALUES ('test290', '58');
INSERT INTO `users` VALUES ('test291', '42');
INSERT INTO `users` VALUES ('test292', '36');
INSERT INTO `users` VALUES ('test293', '53');
INSERT INTO `users` VALUES ('test294', '60');
INSERT INTO `users` VALUES ('test295', '39');
INSERT INTO `users` VALUES ('test296', '16');
INSERT INTO `users` VALUES ('test297', '65');
INSERT INTO `users` VALUES ('test298', '79');
INSERT INTO `users` VALUES ('test299', '98');
INSERT INTO `users` VALUES ('test300', '55');
INSERT INTO `users` VALUES ('test301', '81');
INSERT INTO `users` VALUES ('test302', '42');
INSERT INTO `users` VALUES ('test303', '68');
INSERT INTO `users` VALUES ('test304', '12');
INSERT INTO `users` VALUES ('test305', '56');
INSERT INTO `users` VALUES ('test306', '45');
INSERT INTO `users` VALUES ('test307', '59');
INSERT INTO `users` VALUES ('test308', '60');
INSERT INTO `users` VALUES ('test309', '25');
INSERT INTO `users` VALUES ('test310', '46');
INSERT INTO `users` VALUES ('test311', '53');
INSERT INTO `users` VALUES ('test312', '30');
INSERT INTO `users` VALUES ('test313', '91');
INSERT INTO `users` VALUES ('test314', '66');
INSERT INTO `users` VALUES ('test315', '58');
INSERT INTO `users` VALUES ('test316', '91');
INSERT INTO `users` VALUES ('test317', '84');
INSERT INTO `users` VALUES ('test318', '44');
INSERT INTO `users` VALUES ('test319', '70');
INSERT INTO `users` VALUES ('test320', '17');
INSERT INTO `users` VALUES ('test321', '78');
INSERT INTO `users` VALUES ('test322', '40');
INSERT INTO `users` VALUES ('test323', '65');
INSERT INTO `users` VALUES ('test324', '6');
INSERT INTO `users` VALUES ('test325', '34');
INSERT INTO `users` VALUES ('test326', '53');
INSERT INTO `users` VALUES ('test327', '64');
INSERT INTO `users` VALUES ('test328', '62');
INSERT INTO `users` VALUES ('test329', '19');
INSERT INTO `users` VALUES ('test330', '9');
INSERT INTO `users` VALUES ('test331', '88');
INSERT INTO `users` VALUES ('test332', '16');
INSERT INTO `users` VALUES ('test333', '14');
INSERT INTO `users` VALUES ('test334', '23');
INSERT INTO `users` VALUES ('test335', '72');
INSERT INTO `users` VALUES ('test336', '91');
INSERT INTO `users` VALUES ('test337', '40');
INSERT INTO `users` VALUES ('test338', '26');
INSERT INTO `users` VALUES ('test339', '12');
INSERT INTO `users` VALUES ('test340', '81');
INSERT INTO `users` VALUES ('test341', '70');
INSERT INTO `users` VALUES ('test342', '7');
INSERT INTO `users` VALUES ('test343', '26');
INSERT INTO `users` VALUES ('test344', '12');
INSERT INTO `users` VALUES ('test345', '79');
INSERT INTO `users` VALUES ('test346', '61');
INSERT INTO `users` VALUES ('test347', '68');
INSERT INTO `users` VALUES ('test348', '59');
INSERT INTO `users` VALUES ('test349', '90');
INSERT INTO `users` VALUES ('test350', '72');
INSERT INTO `users` VALUES ('test351', '92');
INSERT INTO `users` VALUES ('test352', '43');
INSERT INTO `users` VALUES ('test353', '39');
INSERT INTO `users` VALUES ('test354', '66');
INSERT INTO `users` VALUES ('test355', '17');
INSERT INTO `users` VALUES ('test356', '84');
INSERT INTO `users` VALUES ('test357', '72');
INSERT INTO `users` VALUES ('test358', '6');
INSERT INTO `users` VALUES ('test359', '15');
INSERT INTO `users` VALUES ('test360', '58');
INSERT INTO `users` VALUES ('test361', '45');
INSERT INTO `users` VALUES ('test362', '54');
INSERT INTO `users` VALUES ('test363', '32');
INSERT INTO `users` VALUES ('test364', '1');
INSERT INTO `users` VALUES ('test365', '10');
INSERT INTO `users` VALUES ('test366', '48');
INSERT INTO `users` VALUES ('test367', '9');
INSERT INTO `users` VALUES ('test368', '3');
INSERT INTO `users` VALUES ('test369', '88');
INSERT INTO `users` VALUES ('test370', '31');
INSERT INTO `users` VALUES ('test371', '91');
INSERT INTO `users` VALUES ('test372', '65');
INSERT INTO `users` VALUES ('test373', '51');
INSERT INTO `users` VALUES ('test374', '61');
INSERT INTO `users` VALUES ('test375', '50');
INSERT INTO `users` VALUES ('test376', '71');
INSERT INTO `users` VALUES ('test377', '3');
INSERT INTO `users` VALUES ('test378', '3');
INSERT INTO `users` VALUES ('test379', '8');
INSERT INTO `users` VALUES ('test380', '32');
INSERT INTO `users` VALUES ('test381', '34');
INSERT INTO `users` VALUES ('test382', '75');
INSERT INTO `users` VALUES ('test383', '74');
INSERT INTO `users` VALUES ('test384', '46');
INSERT INTO `users` VALUES ('test385', '9');
INSERT INTO `users` VALUES ('test386', '6');
INSERT INTO `users` VALUES ('test387', '5');
INSERT INTO `users` VALUES ('test388', '7');
INSERT INTO `users` VALUES ('test389', '21');
INSERT INTO `users` VALUES ('test390', '86');
INSERT INTO `users` VALUES ('test391', '66');
INSERT INTO `users` VALUES ('test392', '71');
INSERT INTO `users` VALUES ('test393', '57');
INSERT INTO `users` VALUES ('test394', '72');
INSERT INTO `users` VALUES ('test395', '93');
INSERT INTO `users` VALUES ('test396', '47');
INSERT INTO `users` VALUES ('test397', '55');
INSERT INTO `users` VALUES ('test398', '36');
INSERT INTO `users` VALUES ('test399', '17');
INSERT INTO `users` VALUES ('test400', '78');
INSERT INTO `users` VALUES ('test401', '40');
INSERT INTO `users` VALUES ('test402', '64');
INSERT INTO `users` VALUES ('test403', '0');
INSERT INTO `users` VALUES ('test404', '10');
INSERT INTO `users` VALUES ('test405', '51');
INSERT INTO `users` VALUES ('test406', '24');
INSERT INTO `users` VALUES ('test407', '67');
INSERT INTO `users` VALUES ('test408', '65');
INSERT INTO `users` VALUES ('test409', '24');
INSERT INTO `users` VALUES ('test410', '25');
INSERT INTO `users` VALUES ('test411', '52');
INSERT INTO `users` VALUES ('test412', '88');
INSERT INTO `users` VALUES ('test413', '83');
INSERT INTO `users` VALUES ('test414', '51');
INSERT INTO `users` VALUES ('test415', '8');
INSERT INTO `users` VALUES ('test416', '85');
INSERT INTO `users` VALUES ('test417', '2');
INSERT INTO `users` VALUES ('test418', '56');
INSERT INTO `users` VALUES ('test419', '76');
INSERT INTO `users` VALUES ('test420', '11');
INSERT INTO `users` VALUES ('test421', '30');
INSERT INTO `users` VALUES ('test422', '15');
INSERT INTO `users` VALUES ('test423', '86');
INSERT INTO `users` VALUES ('test424', '86');
INSERT INTO `users` VALUES ('test425', '72');
INSERT INTO `users` VALUES ('test426', '4');
INSERT INTO `users` VALUES ('test427', '4');
INSERT INTO `users` VALUES ('test428', '7');
INSERT INTO `users` VALUES ('test429', '23');
INSERT INTO `users` VALUES ('test430', '94');
INSERT INTO `users` VALUES ('test431', '5');
INSERT INTO `users` VALUES ('test432', '40');
INSERT INTO `users` VALUES ('test433', '86');
INSERT INTO `users` VALUES ('test434', '13');
INSERT INTO `users` VALUES ('test435', '6');
INSERT INTO `users` VALUES ('test436', '90');
INSERT INTO `users` VALUES ('test437', '32');
INSERT INTO `users` VALUES ('test438', '91');
INSERT INTO `users` VALUES ('test439', '62');
INSERT INTO `users` VALUES ('test440', '36');
INSERT INTO `users` VALUES ('test441', '94');
INSERT INTO `users` VALUES ('test442', '61');
INSERT INTO `users` VALUES ('test443', '25');
INSERT INTO `users` VALUES ('test444', '44');
INSERT INTO `users` VALUES ('test445', '45');
INSERT INTO `users` VALUES ('test446', '94');
INSERT INTO `users` VALUES ('test447', '34');
INSERT INTO `users` VALUES ('test448', '87');
INSERT INTO `users` VALUES ('test449', '36');
INSERT INTO `users` VALUES ('test450', '19');
INSERT INTO `users` VALUES ('test451', '89');
INSERT INTO `users` VALUES ('test452', '86');
INSERT INTO `users` VALUES ('test453', '66');
INSERT INTO `users` VALUES ('test454', '72');
INSERT INTO `users` VALUES ('test455', '61');
INSERT INTO `users` VALUES ('test456', '91');
INSERT INTO `users` VALUES ('test457', '71');
INSERT INTO `users` VALUES ('test458', '83');
INSERT INTO `users` VALUES ('test459', '3');
INSERT INTO `users` VALUES ('test460', '65');
INSERT INTO `users` VALUES ('test461', '16');
INSERT INTO `users` VALUES ('test462', '87');
INSERT INTO `users` VALUES ('test463', '89');
INSERT INTO `users` VALUES ('test464', '84');
INSERT INTO `users` VALUES ('test465', '52');
INSERT INTO `users` VALUES ('test466', '10');
INSERT INTO `users` VALUES ('test467', '96');
INSERT INTO `users` VALUES ('test468', '48');
INSERT INTO `users` VALUES ('test469', '55');
INSERT INTO `users` VALUES ('test470', '29');
INSERT INTO `users` VALUES ('test471', '81');
INSERT INTO `users` VALUES ('test472', '19');
INSERT INTO `users` VALUES ('test473', '52');
INSERT INTO `users` VALUES ('test474', '4');
INSERT INTO `users` VALUES ('test475', '63');
INSERT INTO `users` VALUES ('test476', '3');
INSERT INTO `users` VALUES ('test477', '29');
INSERT INTO `users` VALUES ('test478', '37');
INSERT INTO `users` VALUES ('test479', '99');
INSERT INTO `users` VALUES ('test480', '85');
INSERT INTO `users` VALUES ('test481', '26');
INSERT INTO `users` VALUES ('test482', '75');
INSERT INTO `users` VALUES ('test483', '97');
INSERT INTO `users` VALUES ('test484', '62');
INSERT INTO `users` VALUES ('test485', '17');
INSERT INTO `users` VALUES ('test486', '2');
INSERT INTO `users` VALUES ('test487', '59');
INSERT INTO `users` VALUES ('test488', '88');
INSERT INTO `users` VALUES ('test489', '63');
INSERT INTO `users` VALUES ('test490', '54');
INSERT INTO `users` VALUES ('test491', '79');
INSERT INTO `users` VALUES ('test492', '34');
INSERT INTO `users` VALUES ('test493', '34');
INSERT INTO `users` VALUES ('test494', '67');
INSERT INTO `users` VALUES ('test495', '36');
INSERT INTO `users` VALUES ('test496', '76');
INSERT INTO `users` VALUES ('test497', '76');
INSERT INTO `users` VALUES ('test498', '52');
INSERT INTO `users` VALUES ('test499', '31');
INSERT INTO `users` VALUES ('test500', '99');
INSERT INTO `users` VALUES ('test501', '5');
INSERT INTO `users` VALUES ('test502', '27');
INSERT INTO `users` VALUES ('test503', '19');
INSERT INTO `users` VALUES ('test504', '14');
INSERT INTO `users` VALUES ('test505', '17');
INSERT INTO `users` VALUES ('test506', '40');
INSERT INTO `users` VALUES ('test507', '52');
INSERT INTO `users` VALUES ('test508', '42');
INSERT INTO `users` VALUES ('test509', '51');
INSERT INTO `users` VALUES ('test510', '30');
INSERT INTO `users` VALUES ('test511', '98');
INSERT INTO `users` VALUES ('test512', '2');
INSERT INTO `users` VALUES ('test513', '14');
INSERT INTO `users` VALUES ('test514', '64');
INSERT INTO `users` VALUES ('test515', '80');
INSERT INTO `users` VALUES ('test516', '6');
INSERT INTO `users` VALUES ('test517', '92');
INSERT INTO `users` VALUES ('test518', '44');
INSERT INTO `users` VALUES ('test519', '44');
INSERT INTO `users` VALUES ('test520', '90');
INSERT INTO `users` VALUES ('test521', '18');
INSERT INTO `users` VALUES ('test522', '18');
INSERT INTO `users` VALUES ('test523', '40');
INSERT INTO `users` VALUES ('test524', '44');
INSERT INTO `users` VALUES ('test525', '1');
INSERT INTO `users` VALUES ('test526', '74');
INSERT INTO `users` VALUES ('test527', '69');
INSERT INTO `users` VALUES ('test528', '21');
INSERT INTO `users` VALUES ('test529', '98');
INSERT INTO `users` VALUES ('test530', '29');
INSERT INTO `users` VALUES ('test531', '51');
INSERT INTO `users` VALUES ('test532', '70');
INSERT INTO `users` VALUES ('test533', '98');
INSERT INTO `users` VALUES ('test534', '80');
INSERT INTO `users` VALUES ('test535', '6');
INSERT INTO `users` VALUES ('test536', '90');
INSERT INTO `users` VALUES ('test537', '34');
INSERT INTO `users` VALUES ('test538', '99');
INSERT INTO `users` VALUES ('test539', '95');
INSERT INTO `users` VALUES ('test540', '76');
INSERT INTO `users` VALUES ('test541', '96');
INSERT INTO `users` VALUES ('test542', '54');
INSERT INTO `users` VALUES ('test543', '82');
INSERT INTO `users` VALUES ('test544', '47');
INSERT INTO `users` VALUES ('test545', '90');
INSERT INTO `users` VALUES ('test546', '11');
INSERT INTO `users` VALUES ('test547', '84');
INSERT INTO `users` VALUES ('test548', '90');
INSERT INTO `users` VALUES ('test549', '97');
INSERT INTO `users` VALUES ('test550', '15');
INSERT INTO `users` VALUES ('test551', '84');
INSERT INTO `users` VALUES ('test552', '78');
INSERT INTO `users` VALUES ('test553', '36');
INSERT INTO `users` VALUES ('test554', '49');
INSERT INTO `users` VALUES ('test555', '37');
INSERT INTO `users` VALUES ('test556', '36');
INSERT INTO `users` VALUES ('test557', '73');
INSERT INTO `users` VALUES ('test558', '56');
INSERT INTO `users` VALUES ('test559', '61');
INSERT INTO `users` VALUES ('test560', '37');
INSERT INTO `users` VALUES ('test561', '2');
INSERT INTO `users` VALUES ('test562', '2');
INSERT INTO `users` VALUES ('test563', '5');
INSERT INTO `users` VALUES ('test564', '17');
INSERT INTO `users` VALUES ('test565', '72');
INSERT INTO `users` VALUES ('test566', '8');
INSERT INTO `users` VALUES ('test567', '25');
INSERT INTO `users` VALUES ('test568', '3');
INSERT INTO `users` VALUES ('test569', '41');
INSERT INTO `users` VALUES ('test570', '97');
INSERT INTO `users` VALUES ('test571', '63');
INSERT INTO `users` VALUES ('test572', '24');
INSERT INTO `users` VALUES ('test573', '30');
INSERT INTO `users` VALUES ('test574', '81');
INSERT INTO `users` VALUES ('test575', '14');
INSERT INTO `users` VALUES ('test576', '27');
INSERT INTO `users` VALUES ('test577', '95');
INSERT INTO `users` VALUES ('test578', '93');
INSERT INTO `users` VALUES ('test579', '79');
INSERT INTO `users` VALUES ('test580', '19');
INSERT INTO `users` VALUES ('test581', '58');
INSERT INTO `users` VALUES ('test582', '32');
INSERT INTO `users` VALUES ('test583', '88');
INSERT INTO `users` VALUES ('test584', '44');
INSERT INTO `users` VALUES ('test585', '57');
INSERT INTO `users` VALUES ('test586', '53');
INSERT INTO `users` VALUES ('test587', '95');
INSERT INTO `users` VALUES ('test588', '16');
INSERT INTO `users` VALUES ('test589', '95');
INSERT INTO `users` VALUES ('test590', '29');
INSERT INTO `users` VALUES ('test591', '61');
INSERT INTO `users` VALUES ('test592', '19');
INSERT INTO `users` VALUES ('test593', '13');
INSERT INTO `users` VALUES ('test594', '7');
INSERT INTO `users` VALUES ('test595', '99');
INSERT INTO `users` VALUES ('test596', '72');
INSERT INTO `users` VALUES ('test597', '63');
INSERT INTO `users` VALUES ('test598', '1');
INSERT INTO `users` VALUES ('test599', '15');
INSERT INTO `users` VALUES ('test600', '73');
INSERT INTO `users` VALUES ('test601', '19');
INSERT INTO `users` VALUES ('test602', '76');
INSERT INTO `users` VALUES ('test603', '25');
INSERT INTO `users` VALUES ('test604', '99');
INSERT INTO `users` VALUES ('test605', '17');
INSERT INTO `users` VALUES ('test606', '91');
INSERT INTO `users` VALUES ('test607', '6');
INSERT INTO `users` VALUES ('test608', '54');
INSERT INTO `users` VALUES ('test609', '54');
INSERT INTO `users` VALUES ('test610', '7');
INSERT INTO `users` VALUES ('test611', '76');
INSERT INTO `users` VALUES ('test612', '58');
INSERT INTO `users` VALUES ('test613', '62');
INSERT INTO `users` VALUES ('test614', '35');
INSERT INTO `users` VALUES ('test615', '92');
INSERT INTO `users` VALUES ('test616', '55');
INSERT INTO `users` VALUES ('test617', '98');
INSERT INTO `users` VALUES ('test618', '26');
INSERT INTO `users` VALUES ('test619', '35');
INSERT INTO `users` VALUES ('test620', '99');
INSERT INTO `users` VALUES ('test621', '91');
INSERT INTO `users` VALUES ('test622', '57');
INSERT INTO `users` VALUES ('test623', '15');
INSERT INTO `users` VALUES ('test624', '1');
INSERT INTO `users` VALUES ('test625', '63');
INSERT INTO `users` VALUES ('test626', '10');
INSERT INTO `users` VALUES ('test627', '64');
INSERT INTO `users` VALUES ('test628', '91');
INSERT INTO `users` VALUES ('test629', '61');
INSERT INTO `users` VALUES ('test630', '35');
INSERT INTO `users` VALUES ('test631', '92');
INSERT INTO `users` VALUES ('test632', '57');
INSERT INTO `users` VALUES ('test633', '7');
INSERT INTO `users` VALUES ('test634', '64');
INSERT INTO `users` VALUES ('test635', '1');
INSERT INTO `users` VALUES ('test636', '12');
INSERT INTO `users` VALUES ('test637', '60');
-- ----------------------------
-- Table structure for web_banner
-- ----------------------------
DROP TABLE IF EXISTS `web_banner`;
CREATE TABLE `web_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `imgUrl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `href` varchar(200) DEFAULT NULL COMMENT '跳转链接',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_banner
-- ----------------------------
INSERT INTO `web_banner` VALUES ('13', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzeVsmAMpfXAADi0qfDH84188.jpg', 'http://www.baidu.com', '哈哈', '1', '2019-05-17 14:39:12');
INSERT INTO `web_banner` VALUES ('14', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzeVy2AJWr7AAFtdAgNIkI057.jpg', 'http://www.sina.com', '呵呵', '2', '2019-05-17 14:40:15');

-- ----------------------------
-- Table structure for web_menu
-- ----------------------------
DROP TABLE IF EXISTS `web_menu`;
CREATE TABLE `web_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(40) DEFAULT NULL COMMENT '菜单名',
  `url` varchar(200) DEFAULT NULL COMMENT '跳转链接',
  `menuType` varchar(2) DEFAULT '2' COMMENT '菜单类型(1横向菜单,2纵向菜单)',
  `updateTime` datetime DEFAULT NULL COMMENT '最新修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_menu
-- ----------------------------
INSERT INTO `web_menu` VALUES ('1', '首页', 'http://www.baidu.com', '1', '2019-02-21 14:46:17');
INSERT INTO `web_menu` VALUES ('63', '美食', 'http://www.girl.com', '1', '2019-01-18 10:20:26');
INSERT INTO `web_menu` VALUES ('64', '生鲜', 'http://www.sx.com', '1', '2019-01-18 10:20:49');
INSERT INTO `web_menu` VALUES ('65', '家具', 'http://www.jiaju.com', '1', '2019-01-18 11:48:10');

-- ----------------------------
-- Table structure for web_order
-- ----------------------------
DROP TABLE IF EXISTS `web_order`;
CREATE TABLE `web_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderNo` varchar(100) DEFAULT NULL COMMENT '订单编号',
  `uName` varchar(40) DEFAULT NULL COMMENT '用户名',
  `orderStatus` varchar(2) DEFAULT '0' COMMENT '0已经创建 1未支付  2已经支付  3已经收货  4未评价 5已经评价',
  `secId` bigint(20) DEFAULT NULL COMMENT '秒杀ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_order
-- ----------------------------
INSERT INTO `web_order` VALUES ('1', '5095709022416270', 'test14', '0', '1');
INSERT INTO `web_order` VALUES ('2', '8803605535769148', 'zhangsan', '0', '1');

-- ----------------------------
-- Table structure for web_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `web_product_detail`;
CREATE TABLE `web_product_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `productNum` varchar(20) DEFAULT NULL COMMENT '商品编号',
  `title` varchar(200) DEFAULT NULL,
  `subTitle` varchar(200) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `typeId` bigint(20) DEFAULT NULL,
  `href` varchar(200) DEFAULT NULL COMMENT '跳转地址',
  `updateTime` datetime DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_product_detail
-- ----------------------------
INSERT INTO `web_product_detail` VALUES ('1', '88081', '联想(Lenovo)拯救者Y7000 第九代', 'Y7000爆款机型，512G_PCIE固态硬盘海量存储更快捷', '4699.00', '黑色', '经典版', '100', '4', '88081.html', '2019-02-22 15:18:19');
INSERT INTO `web_product_detail` VALUES ('2', '88082', '沙宣洗发水', '沙宣洗发水-1折狂甩', '19.00', '白色', '500ml', '1000', '1', '88082.html', '2019-01-18 14:48:26');
INSERT INTO `web_product_detail` VALUES ('3', '88083', '牛奶德国进口', '德亚全脂纯牛奶200ml*48盒', '189.00', '红色', '200ml', '2000', '2', '88083.html', '2019-02-22 14:49:30');
INSERT INTO `web_product_detail` VALUES ('4', '88084', 'iphone x手机', 'iphone手机1折甩卖', '999.00', '玫瑰金', '16G', '500', '4', '88084.html', '2019-02-17 14:48:33');
INSERT INTO `web_product_detail` VALUES ('5', '88085', '东北大米', '纯天然东北大米好吃不贵', '60.00', '白色', '5斤', '100', '2', '88085.html', '2019-02-17 14:48:35');
INSERT INTO `web_product_detail` VALUES ('6', '88086', '德芙巧克力', '德芙巧克力尽享丝滑', '20.00', '黑色', '20块', '100', '2', '88086.html', '2019-02-24 11:38:55');

-- ----------------------------
-- Table structure for web_product_img
-- ----------------------------
DROP TABLE IF EXISTS `web_product_img`;
CREATE TABLE `web_product_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `imgUrl` varchar(200) DEFAULT NULL COMMENT '图片',
  `productId` bigint(20) DEFAULT NULL COMMENT '商品id',
  `productNum` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_product_img
-- ----------------------------
INSERT INTO `web_product_img` VALUES ('1', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwPGAangvAABD_zdjoXY679.jpg', '1', '88081');
INSERT INTO `web_product_img` VALUES ('2', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwTiAejSrAAA_FrDP7dQ569.jpg', '1', '88081');
INSERT INTO `web_product_img` VALUES ('3', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwVSAcsbZAAAsArZ94fE796.jpg', '1', '88081');
INSERT INTO `web_product_img` VALUES ('4', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwXmAffnhAAAlcJ34sBc775.jpg', '2', '88082');
INSERT INTO `web_product_img` VALUES ('5', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwZiAWOlsAABnbYdTNGQ600.jpg', '3', '88083');
INSERT INTO `web_product_img` VALUES ('6', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwc2AJzc1AABrVOJd6lY807.jpg', '4', '88084');
INSERT INTO `web_product_img` VALUES ('7', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwe-ADt82AACfXnN-3yY761.jpg', '5', '88085');
INSERT INTO `web_product_img` VALUES ('8', 'http://192.168.25.133/group1/M00/00/05/wKgZhVzgwhCAN2eTAABeWaBrCok227.jpg', '6', '88086');

-- ----------------------------
-- Table structure for web_seckill
-- ----------------------------
DROP TABLE IF EXISTS `web_seckill`;
CREATE TABLE `web_seckill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀主键',
  `productId` bigint(20) DEFAULT NULL COMMENT '商品id',
  `num` int(11) DEFAULT NULL COMMENT '秒杀名额',
  `seckillPrice` float(10,2) DEFAULT NULL COMMENT '秒杀价',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `status` varchar(2) DEFAULT '0' COMMENT '0未开始，1已开始，2已经结束',
  `href` varchar(200) DEFAULT NULL COMMENT '秒杀详情页',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_seckill
-- ----------------------------
INSERT INTO `web_seckill` VALUES ('1', '3', '30', '569.90', '2019-06-02 14:00:00', '2019-06-02 19:00:00', '1', '88081.html');
INSERT INTO `web_seckill` VALUES ('2', '1', '5', '5.00', '2019-05-31 14:00:00', '2019-05-31 15:00:00', '2', '88082.html');
INSERT INTO `web_seckill` VALUES ('3', '2', '30', '9.00', '2019-05-31 15:00:00', '2019-05-31 16:00:00', '2', '88083.html');
INSERT INTO `web_seckill` VALUES ('4', '4', '10', '2.00', '2019-01-23 10:00:00', '2019-02-25 16:00:00', '2', '88084.html');
INSERT INTO `web_seckill` VALUES ('5', '5', '10', '3.00', '2019-01-23 10:00:00', '2019-02-25 16:00:00', '2', '88085.html');
INSERT INTO `web_seckill` VALUES ('6', '6', '10', '5.00', '2019-01-23 10:00:00', '2019-02-25 16:00:00', '2', '88086.html');

-- ----------------------------
-- Table structure for web_sort
-- ----------------------------
DROP TABLE IF EXISTS `web_sort`;
CREATE TABLE `web_sort` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品类型主键',
  `sortName` varchar(40) DEFAULT NULL COMMENT '类型名',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_sort
-- ----------------------------
INSERT INTO `web_sort` VALUES ('1', '化妆品', '2019-02-21 16:49:03');
INSERT INTO `web_sort` VALUES ('2', '食品', '2019-02-21 16:49:31');
INSERT INTO `web_sort` VALUES ('3', '玩具', '2019-02-21 16:50:00');
INSERT INTO `web_sort` VALUES ('4', '数码', '2019-02-21 16:55:48');

-- ----------------------------
-- Procedure structure for pro_insertManyData
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_insertManyData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_insertManyData`(in num int)
begin
	declare i int default 1;
	while i<=num do
		insert `users` values(concat('test',i),floor(RAND()*100));
		set i = i+1;
	end while;
end
;;
DELIMITER ;
