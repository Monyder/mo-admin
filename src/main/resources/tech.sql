/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.195（tech）
Source Server Version : 50726
Source Host           : 192.168.1.195:3306
Source Database       : tech

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-12-08 16:11:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `operating_time` datetime DEFAULT NULL COMMENT '操作时间',
  `ip` varchar(32) DEFAULT NULL COMMENT '操作ip',
  `func` varchar(255) DEFAULT NULL COMMENT '操作功能',
  `remarks` varchar(520) DEFAULT NULL COMMENT '备注',
  `spare_one` varchar(255) DEFAULT NULL,
  `spare_two` varchar(255) DEFAULT NULL,
  `spare_three` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=487 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('4', 'admin', '2020-08-10 11:37:30', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('5', 'admin', '2020-08-10 11:39:14', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('6', 'admin', '2020-08-10 11:40:15', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('7', 'admin', '2020-08-11 13:56:30', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('8', 'admin', '2020-08-11 13:57:04', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('9', 'admin', '2020-08-12 10:20:46', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('10', 'admin', '2020-08-12 11:33:36', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('11', 'admin', '2020-08-12 11:34:28', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('12', 'admin', '2020-08-12 11:34:43', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('13', 'admin', '2020-08-12 11:35:16', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('14', 'admin', '2020-08-12 11:36:05', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('15', 'admin', '2020-08-12 11:38:49', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('16', 'admin', '2020-08-12 15:01:21', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('17', 'admin', '2020-08-12 15:15:37', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('18', 'admin', '2020-08-12 16:29:27', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('19', 'admin', '2020-08-12 16:29:28', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('20', 'admin', '2020-08-12 16:29:29', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('21', 'admin', '2020-08-12 16:31:11', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('22', 'admin', '2020-08-12 16:34:42', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('23', 'admin', '2020-08-12 16:37:28', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('24', 'admin', '2020-08-12 16:44:34', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('25', 'admin', '2020-08-12 16:53:50', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('26', 'admin', '2020-08-12 17:36:32', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('27', 'admin', '2020-08-12 17:37:42', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('28', 'admin', '2020-08-12 17:37:53', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('29', 'admin', '2020-08-12 17:40:09', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('30', 'admin', '2020-08-12 17:40:39', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('31', 'admin', '2020-08-12 17:44:03', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('32', 'admin', '2020-08-13 10:08:30', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('33', 'admin', '2020-08-13 10:09:21', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('34', 'admin', '2020-08-13 10:22:54', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('35', 'admin', '2020-08-13 11:42:11', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('36', 'admin', '2020-08-13 13:04:50', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('37', 'admin', '2020-08-13 16:41:54', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('38', 'admin', '2020-08-13 17:08:03', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('39', 'admin', '2020-08-13 17:10:42', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('40', 'admin', '2020-08-14 09:05:19', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('41', 'admin', '2020-08-14 13:25:40', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('42', 'admin', '2020-08-14 14:52:37', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('43', 'admin', '2020-08-14 17:11:27', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('44', 'admin', '2020-08-17 09:30:50', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('45', 'admin', '2020-08-18 09:42:30', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('46', 'admin', '2020-08-18 13:01:56', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('47', 'admin', '2020-08-18 15:30:42', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('48', 'admin', '2020-08-19 09:29:17', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('49', 'admin', '2020-08-19 17:20:46', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('50', 'admin', '2020-08-20 09:49:57', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('51', 'admin', '2020-08-20 10:25:53', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('52', 'admin', '2020-08-20 10:26:50', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('53', 'admin', '2020-08-20 10:27:40', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('54', 'admin', '2020-08-20 10:29:42', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('55', 'admin', '2020-08-20 11:45:02', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('56', 'admin', '2020-08-20 13:13:19', '192.168.1.208', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('57', 'admin', '2020-08-20 13:49:35', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('58', null, '2020-08-20 15:26:39', '192.168.1.208', '登录', null, null, null, null);
INSERT INTO `sys_log` VALUES ('59', null, '2020-08-20 16:09:22', '192.168.1.208', '登录', null, null, null, null);
INSERT INTO `sys_log` VALUES ('60', 'admin', '2020-08-20 16:14:59', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('61', 'admin', '2020-08-20 17:11:09', '192.168.1.208', '登录', null, null, null, null);
INSERT INTO `sys_log` VALUES ('62', 'admin', '2020-08-20 17:13:26', '192.168.1.208', '登录', null, null, null, null);
INSERT INTO `sys_log` VALUES ('63', 'admin', '2020-08-24 10:19:30', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('64', 'admin', '2020-08-24 10:40:49', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('65', 'admin', '2020-08-24 14:22:58', '127.0.0.1', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('66', 'admin', '2020-08-25 09:26:17', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('67', 'admin', '2020-08-25 09:27:30', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('68', 'admin', '2020-08-25 09:42:40', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('69', 'admin', '2020-08-25 09:43:53', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('70', 'admin', '2020-08-25 10:55:02', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('71', 'admin', '2020-08-25 11:10:41', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('72', 'admin', '2020-08-25 11:27:06', '192.168.1.202', '登陆', null, null, null, null);
INSERT INTO `sys_log` VALUES ('73', 'admin', '2020-08-26 16:57:32', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('74', 'admin', '2020-08-26 17:29:04', '192.168.1.208', '菜单功能', '删除菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('75', 'admin', '2020-08-28 14:15:38', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('76', 'admin', '2020-09-01 11:36:27', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('77', 'admin', '2020-09-01 11:36:41', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('78', 'admin', '2020-09-01 11:36:44', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('79', 'admin', '2020-09-01 12:00:46', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('80', 'admin', '2020-09-01 15:13:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('81', 'admin', '2020-09-01 15:13:06', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('82', 'admin', '2020-09-01 15:24:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('83', 'admin', '2020-09-01 15:24:21', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('84', 'admin', '2020-09-01 15:24:23', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('85', 'admin', '2020-09-01 15:24:25', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('86', 'admin', '2020-09-01 15:24:27', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('87', 'admin', '2020-09-01 15:24:28', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('88', 'admin', '2020-09-01 15:24:30', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('89', 'admin', '2020-09-01 15:24:32', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('90', 'admin', '2020-09-01 15:24:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('91', 'admin', '2020-09-01 15:40:12', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('92', 'admin', '2020-09-01 15:40:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('93', 'admin', '2020-09-01 15:40:16', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('94', 'admin', '2020-09-01 15:40:19', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('95', 'admin', '2020-09-01 15:40:20', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('96', 'admin', '2020-09-01 15:40:21', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('97', 'admin', '2020-09-01 15:40:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('98', 'admin', '2020-09-01 15:41:31', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('99', 'admin', '2020-09-01 15:42:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('100', 'admin', '2020-09-01 16:34:05', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('101', 'admin', '2020-09-01 16:57:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('102', 'admin', '2020-09-01 17:17:29', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('103', 'admin', '2020-09-01 17:17:41', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('104', 'admin', '2020-09-01 17:17:48', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('105', 'admin', '2020-09-01 17:17:54', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('106', 'admin', '2020-09-01 17:18:14', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('107', 'admin', '2020-09-01 17:39:50', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('108', 'admin', '2020-09-01 17:44:04', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('109', 'admin', '2020-09-01 17:44:11', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('110', 'admin', '2020-09-01 17:44:13', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('111', 'admin', '2020-09-01 17:53:52', '192.168.1.208', '角色管理', '添加角色', null, null, null);
INSERT INTO `sys_log` VALUES ('112', 'admin', '2020-09-03 09:22:25', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('113', 'admin', '2020-09-03 09:22:31', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('114', 'admin', '2020-09-03 09:22:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('115', 'admin', '2020-09-03 09:22:35', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('116', 'admin', '2020-09-03 09:22:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('117', 'admin', '2020-09-03 09:22:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('118', 'admin', '2020-09-03 09:53:52', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('119', 'admin', '2020-09-03 09:53:55', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('120', 'admin', '2020-09-03 09:54:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('121', 'admin', '2020-09-03 09:54:10', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('122', 'admin', '2020-09-03 09:59:44', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('123', 'admin', '2020-09-03 09:59:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('124', 'admin', '2020-09-03 09:59:47', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('125', 'admin', '2020-09-03 10:00:03', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('126', 'admin', '2020-09-03 10:00:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('127', 'admin', '2020-09-03 10:00:31', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('128', 'admin', '2020-09-03 10:00:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('129', 'admin', '2020-09-03 10:00:44', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('130', 'admin', '2020-09-03 10:00:55', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('131', 'admin', '2020-09-03 10:16:17', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('132', 'admin', '2020-09-03 10:16:20', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('133', 'admin', '2020-09-03 10:19:43', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('134', 'admin', '2020-09-03 10:20:27', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('135', 'admin', '2020-09-03 10:20:34', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('136', 'admin', '2020-09-03 10:22:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('137', 'admin', '2020-09-03 10:40:34', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('138', 'admin', '2020-09-03 10:40:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('139', 'admin', '2020-09-03 10:41:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('140', 'admin', '2020-09-03 10:45:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('141', 'admin', '2020-09-03 10:47:02', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('142', 'admin', '2020-09-03 10:51:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('143', 'admin', '2020-09-03 10:51:17', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('144', 'admin', '2020-09-03 10:51:26', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('145', 'admin', '2020-09-03 10:55:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('146', 'admin', '2020-09-03 10:55:53', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('147', 'admin', '2020-09-03 10:59:02', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('148', 'admin', '2020-09-03 10:59:19', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('149', 'admin', '2020-09-03 11:01:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('150', 'admin', '2020-09-03 11:01:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('151', 'admin', '2020-09-03 11:01:42', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('152', 'admin', '2020-09-03 11:01:54', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('153', 'admin', '2020-09-03 11:01:56', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('154', 'admin', '2020-09-03 11:02:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('155', 'admin', '2020-09-03 11:02:11', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('156', 'admin', '2020-09-03 11:02:17', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('157', 'admin', '2020-09-03 11:05:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('158', 'admin', '2020-09-03 11:05:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('159', 'admin', '2020-09-03 11:05:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('160', 'admin', '2020-09-03 11:06:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('161', 'admin', '2020-09-03 11:06:49', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('162', 'admin', '2020-09-03 11:06:52', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('163', 'admin', '2020-09-03 11:06:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('164', 'admin', '2020-09-03 11:07:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('165', 'admin', '2020-09-03 11:08:07', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('166', 'admin', '2020-09-03 11:12:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('167', 'admin', '2020-09-03 11:13:43', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('168', 'admin', '2020-09-03 11:16:02', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('169', 'admin', '2020-09-03 11:16:36', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('170', 'admin', '2020-09-03 11:17:01', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('171', 'admin', '2020-09-03 11:18:12', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('172', 'admin', '2020-09-03 11:22:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('173', 'admin', '2020-09-03 11:25:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('174', 'admin', '2020-09-03 11:25:21', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('175', 'admin', '2020-09-03 11:30:11', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('176', 'admin', '2020-09-03 11:30:19', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('177', 'admin', '2020-09-03 11:30:21', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('178', 'admin', '2020-09-03 11:30:27', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('179', 'admin', '2020-09-03 11:30:31', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('180', 'admin', '2020-09-03 11:30:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('181', 'admin', '2020-09-03 11:30:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('182', 'admin', '2020-09-03 11:30:41', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('183', 'admin', '2020-09-03 11:30:43', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('184', 'admin', '2020-09-03 11:31:05', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('185', 'admin', '2020-09-03 11:36:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('186', 'admin', '2020-09-03 11:36:07', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('187', 'admin', '2020-09-03 11:36:11', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('188', 'admin', '2020-09-03 11:40:23', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('189', 'admin', '2020-09-03 11:49:01', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('190', 'admin', '2020-09-03 17:40:20', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('191', 'admin', '2020-09-03 17:40:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('192', 'admin', '2020-09-03 17:40:24', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('193', 'admin', '2020-09-03 17:43:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('194', 'admin', '2020-09-03 17:46:54', '192.168.1.208', '角色管理', '添加角色', null, null, null);
INSERT INTO `sys_log` VALUES ('195', 'admin', '2020-09-03 17:47:13', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('196', 'admin', '2020-09-03 17:49:37', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('197', 'admin', '2020-09-03 17:49:39', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('198', 'admin', '2020-09-03 17:49:45', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('199', 'admin', '2020-09-03 17:50:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('200', 'admin', '2020-09-03 17:50:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('201', 'zhangxiaomei', '2020-09-03 17:51:17', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('202', 'zhangxiaomei', '2020-09-03 17:51:26', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('203', 'zhangxiaomei', '2020-09-03 17:51:36', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('204', 'zhangxiaomei', '2020-09-03 17:51:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('205', 'zhangxiaomei', '2020-09-03 17:51:53', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('206', 'admin', '2020-09-03 17:53:01', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('207', 'admin', '2020-09-03 17:53:11', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('208', 'admin', '2020-09-03 17:53:17', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('209', 'admin', '2020-09-04 11:01:54', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('210', 'admin', '2020-09-04 11:02:20', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('211', 'admin', '2020-09-04 11:02:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('212', 'admin', '2020-09-04 11:03:29', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('213', 'admin', '2020-09-04 13:15:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('214', 'admin', '2020-09-04 13:16:01', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('215', 'admin', '2020-09-04 13:16:13', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('216', 'admin', '2020-09-04 13:18:27', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('217', 'admin', '2020-09-04 13:20:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('218', 'admin', '2020-09-04 13:33:52', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('219', 'admin', '2020-09-04 13:34:18', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('220', 'admin', '2020-09-04 13:34:30', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('221', 'admin', '2020-09-04 14:15:51', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('222', 'admin', '2020-09-04 14:16:07', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('223', 'admin', '2020-09-04 14:16:13', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('224', 'admin', '2020-09-04 14:18:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('225', 'admin', '2020-09-04 14:19:12', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('226', 'admin', '2020-09-04 14:19:42', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('227', 'admin', '2020-09-04 14:19:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('228', 'admin', '2020-09-04 14:19:51', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('229', 'admin', '2020-09-04 14:19:57', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('230', 'admin', '2020-09-04 14:19:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('231', 'admin', '2020-09-04 14:20:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('232', 'admin', '2020-09-04 14:20:03', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('233', 'admin', '2020-09-04 14:20:44', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('234', 'admin', '2020-09-04 14:22:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('235', 'admin', '2020-09-04 14:22:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('236', 'admin', '2020-09-04 14:22:25', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('237', 'admin', '2020-09-04 14:51:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('238', 'admin', '2020-09-04 14:51:28', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('239', 'admin', '2020-09-04 14:51:35', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('240', 'admin', '2020-09-04 14:53:09', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('241', 'admin', '2020-09-04 14:53:11', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('242', 'admin', '2020-09-04 14:53:57', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('243', 'admin', '2020-09-04 14:54:56', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('244', 'admin', '2020-09-04 14:54:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('245', 'admin', '2020-09-04 14:56:26', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('246', 'admin', '2020-09-04 14:56:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('247', 'admin', '2020-09-04 14:57:12', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('248', 'admin', '2020-09-04 15:01:32', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('249', 'admin', '2020-09-04 15:07:19', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('250', 'admin', '2020-09-04 15:07:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('251', 'admin', '2020-09-04 15:09:34', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('252', 'admin', '2020-09-04 15:13:26', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('253', 'admin', '2020-09-04 15:13:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('254', 'admin', '2020-09-04 15:13:46', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('255', 'admin', '2020-09-04 15:13:53', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('256', 'admin', '2020-09-04 15:14:01', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('257', 'admin', '2020-09-04 15:14:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('258', 'admin', '2020-09-04 15:17:50', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('259', 'admin', '2020-09-04 15:17:53', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('260', 'admin', '2020-09-04 15:18:05', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('261', 'admin', '2020-09-04 15:18:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('262', 'admin', '2020-09-04 15:19:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('263', 'admin', '2020-09-07 13:03:27', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('264', 'admin', '2020-09-07 17:05:43', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('265', 'admin', '2020-09-09 13:52:08', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('266', 'admin', '2020-09-09 14:01:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('267', 'admin', '2020-09-11 16:34:35', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('268', 'admin', '2020-09-11 16:35:19', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('269', 'admin', '2020-09-11 16:35:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('270', 'admin', '2020-09-11 16:35:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('271', 'admin', '2020-09-11 16:37:20', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('272', 'admin', '2020-09-14 11:48:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('273', 'admin', '2020-09-14 11:48:46', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('274', 'admin', '2020-09-14 14:12:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('275', 'admin', '2020-09-14 14:14:36', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('276', 'admin', '2020-09-14 15:23:29', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('277', 'admin', '2020-09-21 17:05:05', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('278', 'admin', '2020-09-21 17:07:19', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('279', 'admin', '2020-09-21 17:07:26', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('280', 'admin', '2020-09-21 17:07:41', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('281', 'admin', '2020-09-24 13:23:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('282', 'admin', '2020-09-24 13:31:26', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('283', 'admin', '2020-09-24 13:40:24', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('284', 'admin', '2020-09-24 13:40:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('285', 'admin', '2020-09-24 13:55:51', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('286', 'admin', '2020-09-24 13:55:53', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('287', 'admin', '2020-09-24 13:59:08', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('288', 'admin', '2020-09-24 14:00:15', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('289', 'admin', '2020-09-24 14:03:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('290', 'admin', '2020-09-24 14:04:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('291', 'admin', '2020-09-24 14:04:39', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('292', 'admin', '2020-09-24 14:05:34', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('293', 'admin', '2020-09-24 14:05:53', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('294', 'admin', '2020-09-24 14:10:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('295', 'admin', '2020-09-24 14:10:21', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('296', 'admin', '2020-09-24 16:46:41', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('297', 'admin', '2020-09-24 16:46:43', '192.168.1.208', '家属管理', '修改家属信息！', null, null, null);
INSERT INTO `sys_log` VALUES ('298', 'admin', '2020-09-24 17:18:23', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('299', 'admin', '2020-09-24 17:18:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('300', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('301', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('302', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('303', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('304', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('305', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('306', 'admin', '2020-09-25 09:55:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('307', 'admin', '2020-09-25 10:01:20', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('308', 'admin', '2020-09-25 10:02:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('309', 'admin', '2020-09-25 10:02:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('310', 'admin', '2020-09-25 10:02:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('311', 'admin', '2020-09-25 10:02:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('312', 'admin', '2020-09-25 10:02:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('313', 'admin', '2020-09-25 10:02:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('314', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('315', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('316', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('317', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('318', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('319', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('320', 'admin', '2020-09-25 10:13:27', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('321', 'admin', '2020-09-25 10:19:23', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('322', 'admin', '2020-09-25 10:19:37', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('323', 'admin', '2020-09-25 10:19:37', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('324', 'admin', '2020-09-25 10:19:37', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('325', 'admin', '2020-09-25 10:19:37', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('326', 'admin', '2020-09-25 10:23:51', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('327', 'admin', '2020-09-25 10:23:51', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('328', 'admin', '2020-09-25 10:23:52', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('329', 'admin', '2020-09-25 10:23:52', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('330', 'admin', '2020-09-25 10:23:52', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('331', 'admin', '2020-09-25 10:23:52', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('332', 'admin', '2020-09-25 10:23:52', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('333', 'admin', '2020-09-25 11:04:26', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('334', 'admin', '2020-09-25 11:04:59', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('335', 'admin', '2020-09-25 11:05:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('336', 'admin', '2020-09-25 11:05:36', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('337', 'admin', '2020-09-25 11:05:36', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('338', 'admin', '2020-09-25 11:06:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('339', 'admin', '2020-09-25 11:06:04', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('340', 'admin', '2020-09-25 11:13:30', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('341', 'admin', '2020-09-25 11:14:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('342', 'admin', '2020-09-25 11:14:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('343', 'admin', '2020-09-25 11:14:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('344', 'admin', '2020-09-25 11:14:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('345', 'admin', '2020-09-25 11:14:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('346', 'admin', '2020-09-25 11:14:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('347', 'admin', '2020-09-25 11:14:15', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('348', 'admin', '2020-09-25 11:17:21', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('349', 'admin', '2020-09-25 11:19:04', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('350', 'admin', '2020-09-25 11:19:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('351', 'admin', '2020-09-25 11:19:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('352', 'admin', '2020-09-25 11:19:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('353', 'admin', '2020-09-25 11:19:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('354', 'admin', '2020-09-25 11:19:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('355', 'admin', '2020-09-25 11:19:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('356', 'admin', '2020-09-25 11:22:41', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('357', 'admin', '2020-09-25 11:23:32', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('358', 'admin', '2020-09-25 11:23:33', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('359', 'admin', '2020-09-25 11:23:33', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('360', 'admin', '2020-09-25 11:23:33', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('361', 'admin', '2020-09-25 11:23:33', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('362', 'admin', '2020-09-25 11:23:33', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('363', 'admin', '2020-09-25 11:23:33', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('364', 'admin', '2020-09-25 11:26:12', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('365', 'admin', '2020-09-25 11:27:59', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('366', 'admin', '2020-09-25 11:27:59', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('367', 'admin', '2020-09-25 11:28:48', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('368', 'admin', '2020-09-25 11:29:45', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('369', 'admin', '2020-09-25 11:29:45', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('370', 'admin', '2020-09-25 11:29:45', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('371', 'admin', '2020-09-25 11:33:34', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('372', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('373', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('374', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('375', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('376', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('377', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('378', 'admin', '2020-09-25 11:36:21', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('379', 'admin', '2020-09-25 11:39:00', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('380', 'admin', '2020-09-25 11:40:39', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('381', 'admin', '2020-09-25 11:40:39', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('382', 'admin', '2020-09-25 11:40:39', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('383', 'admin', '2020-09-25 11:40:39', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('384', 'admin', '2020-09-25 11:40:39', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('385', 'admin', '2020-09-25 11:40:39', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('386', 'admin', '2020-09-25 11:42:16', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('387', 'admin', '2020-09-25 11:42:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('388', 'admin', '2020-09-25 11:42:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('389', 'admin', '2020-09-25 11:42:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('390', 'admin', '2020-09-25 11:42:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('391', 'admin', '2020-09-25 11:42:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('392', 'admin', '2020-09-25 11:42:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('393', 'admin', '2020-09-25 11:44:33', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('394', 'admin', '2020-09-25 11:44:49', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('395', 'admin', '2020-09-25 11:44:49', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('396', 'admin', '2020-09-25 11:44:49', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('397', 'admin', '2020-09-25 11:44:49', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('398', 'admin', '2020-09-25 11:44:49', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('399', 'admin', '2020-09-25 11:44:49', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('400', 'admin', '2020-09-25 11:45:50', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('401', 'admin', '2020-09-25 11:46:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('402', 'admin', '2020-09-25 11:46:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('403', 'admin', '2020-09-25 11:46:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('404', 'admin', '2020-09-25 11:46:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('405', 'admin', '2020-09-25 11:46:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('406', 'admin', '2020-09-25 11:46:06', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('407', 'admin', '2020-09-25 11:48:09', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('408', 'admin', '2020-09-25 11:48:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('409', 'admin', '2020-09-25 11:48:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('410', 'admin', '2020-09-25 11:48:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('411', 'admin', '2020-09-25 11:48:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('412', 'admin', '2020-09-25 11:48:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('413', 'admin', '2020-09-25 11:48:23', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('414', 'admin', '2020-09-25 11:49:14', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('415', 'admin', '2020-09-25 11:49:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('416', 'admin', '2020-09-25 11:49:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('417', 'admin', '2020-09-25 11:49:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('418', 'admin', '2020-09-25 11:49:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('419', 'admin', '2020-09-25 11:49:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('420', 'admin', '2020-09-25 11:49:24', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('421', 'admin', '2020-09-25 11:53:27', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('422', 'admin', '2020-09-25 11:53:38', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('423', 'admin', '2020-09-25 11:53:40', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('424', 'admin', '2020-09-25 11:53:41', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('425', 'admin', '2020-09-25 11:53:43', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('426', 'admin', '2020-09-25 11:53:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('427', 'admin', '2020-09-25 11:53:45', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('428', 'admin', '2020-09-25 15:54:43', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('429', 'admin', '2020-09-25 15:54:43', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('430', 'admin', '2020-09-25 15:54:43', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('431', 'admin', '2020-09-25 15:54:43', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('432', 'admin', '2020-09-25 15:54:43', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('433', 'admin', '2020-09-25 15:54:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('434', 'admin', '2020-09-25 15:54:44', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('435', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('436', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('437', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('438', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('439', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('440', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('441', 'admin', '2020-09-25 15:57:19', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('442', 'admin', '2020-09-25 16:00:13', '192.168.1.208', '家属登记', '家属进行登记', null, null, null);
INSERT INTO `sys_log` VALUES ('443', 'admin', '2020-09-25 16:00:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('444', 'admin', '2020-09-25 16:00:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('445', 'admin', '2020-09-25 16:00:13', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('446', 'admin', '2020-09-25 16:00:14', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('447', 'admin', '2020-09-25 16:00:14', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('448', 'admin', '2020-09-25 16:00:14', '192.168.1.208', '家属管理,修改家属', '上传家属照片', null, null, null);
INSERT INTO `sys_log` VALUES ('449', 'admin', '2020-09-25 17:14:05', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('450', 'admin', '2020-09-29 10:35:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('451', 'admin', '2020-09-29 10:35:35', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('452', 'admin', '2020-09-29 10:35:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('453', 'admin', '2020-09-29 10:36:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('454', 'admin', '2020-09-29 10:36:24', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('455', 'admin', '2020-09-29 11:27:50', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('456', 'admin', '2020-09-30 10:10:31', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('457', 'admin', '2020-10-12 15:25:52', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('458', 'admin', '2020-10-12 15:25:55', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('459', 'admin', '2020-10-12 18:00:08', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('460', 'admin', '2020-10-12 18:00:21', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('461', 'admin', '2020-10-13 10:20:03', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('462', 'admin', '2020-10-14 15:52:16', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('463', 'admin', '2020-10-14 15:54:27', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('464', 'admin', '2020-10-14 15:56:47', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('465', 'admin', '2020-10-14 16:22:26', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('466', 'admin', '2020-10-14 16:28:36', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('467', 'admin', '2020-10-14 16:33:19', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('468', 'admin', '2020-10-14 16:35:08', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('469', 'admin', '2020-10-14 16:35:56', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('470', 'admin', '2020-10-14 16:37:35', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('471', 'admin', '2020-10-14 16:38:34', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('472', 'admin', '2020-10-14 16:38:43', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('473', 'admin', '2020-10-14 16:40:17', '192.168.1.208', '角色管理', '添加角色', null, null, null);
INSERT INTO `sys_log` VALUES ('474', 'admin', '2020-10-15 09:18:27', '192.168.1.219', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('475', 'admin', '2020-10-15 09:18:31', '192.168.1.219', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('476', 'admin', '2020-10-19 16:10:33', '192.168.1.208', '菜单功能', '新增菜单操作', null, null, null);
INSERT INTO `sys_log` VALUES ('477', 'admin', '2020-12-08 14:59:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('478', 'admin', '2020-12-08 15:00:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('479', 'admin', '2020-12-08 15:05:43', '192.168.1.208', '角色管理', '添加角色', null, null, null);
INSERT INTO `sys_log` VALUES ('480', 'admin', '2020-12-08 15:05:58', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('481', 'admin', '2020-12-08 15:06:03', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('482', 'admin', '2020-12-08 15:06:15', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('483', 'admin', '2020-12-08 15:06:38', '192.168.1.208', '角色管理', '添加角色', null, null, null);
INSERT INTO `sys_log` VALUES ('484', 'admin', '2020-12-08 15:26:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('485', 'admin', '2020-12-08 15:27:36', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('486', 'admin', '2020-12-08 15:27:58', '192.168.1.208', '角色管理', '删除角色', null, null, null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `node_name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `node_pid` bigint(20) DEFAULT NULL COMMENT '上级菜单ID',
  `roder_code` int(11) DEFAULT NULL COMMENT '排序号',
  `node_type` int(11) DEFAULT NULL COMMENT '节点类型，0菜单，1按钮；按钮不能有下级菜单',
  `node_path` varchar(64) DEFAULT NULL COMMENT '节点路径',
  `node_component` varchar(64) DEFAULT NULL COMMENT '节点组件',
  `node_iconcls` varchar(64) DEFAULT NULL COMMENT '节点图标',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `spare_one` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `spare_two` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `spare_three` varchar(100) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '根目录', '0', '0', '0', null, null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统管理', '1', '200', '0', null, null, 'el-icon-setting', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '用户管理', '2', '210', '0', 'sysUserInfo', '/sys/sysUserInfo', 'el-icon-user', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '日志管理', '2', '220', '0', 'logInfo', '/sys/logInfo', 'el-icon-s-release', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '2', '230', '0', 'menuInfo', '/sys/menuInfo', 'el-icon-s-operation', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6', '角色管理', '2', '240', '0', 'sysRoleInfo', '/sys/sysRoleInfo', 'el-icon-s-check', null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(20) NOT NULL COMMENT '角色',
  `status` int(20) DEFAULT '0' COMMENT '角色状态，0有效1无效',
  `menu_ids` varchar(2000) DEFAULT NULL COMMENT '存储目录表主键 逗号分隔',
  `authority` int(11) DEFAULT '0' COMMENT '0 可读可写，1读',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `orders` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2', 'Admin', '系统管理员', '0', '1,2,3,4,5,6', '0', null, '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `role_id` bigint(20) NOT NULL COMMENT '角色id，逗号分隔存储',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `remark` varchar(520) DEFAULT NULL COMMENT '备注',
  `spare_one` varchar(255) DEFAULT NULL,
  `spare_two` varchar(255) DEFAULT NULL,
  `spare_three` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2', '张孝美', '15142055652', '管理员', null, null, null);
