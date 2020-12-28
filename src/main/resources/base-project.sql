/*
Navicat MySQL Data Transfer

Source Server         : 本机mysql8.0.15
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : base-project

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-12-28 09:31:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_data_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_type`;
CREATE TABLE `sys_data_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) DEFAULT NULL COMMENT '数据类型编码',
  `default_length` int(11) DEFAULT NULL COMMENT '默认长度',
  `default_precision` int(11) DEFAULT NULL COMMENT '默认精度',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_data_type
-- ----------------------------
INSERT INTO `sys_data_type` VALUES ('1', 'varchar', '255', null, '10');
INSERT INTO `sys_data_type` VALUES ('2', 'bigint', '20', null, '11');
INSERT INTO `sys_data_type` VALUES ('3', 'int', '11', null, '12');
INSERT INTO `sys_data_type` VALUES ('4', 'date', null, null, '13');
INSERT INTO `sys_data_type` VALUES ('5', 'datetime', null, null, '14');
INSERT INTO `sys_data_type` VALUES ('6', 'timestamp', null, null, '15');
INSERT INTO `sys_data_type` VALUES ('7', 'float', '8', '2', '16');
INSERT INTO `sys_data_type` VALUES ('8', 'text', null, null, '17');

-- ----------------------------
-- Table structure for sys_info_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_info_item`;
CREATE TABLE `sys_info_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `infoset_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '信息集编码',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字段编码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字段名称',
  `data_type_id` bigint(20) DEFAULT NULL COMMENT '数据类型',
  `length` int(11) DEFAULT NULL COMMENT '字段长度',
  `precision_set` int(11) DEFAULT NULL COMMENT '小数点精确度',
  `nullable` int(11) DEFAULT NULL COMMENT '不是null 必填0是1否',
  `code_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码类型',
  `remark` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字段注释',
  `is_default` int(10) DEFAULT '1' COMMENT '是否为默认字段0是 1否',
  `database_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '数据库类型  目前只支持mysql',
  `sort` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='信息项表';

-- ----------------------------
-- Records of sys_info_item
-- ----------------------------

-- ----------------------------
-- Table structure for sys_info_set
-- ----------------------------
DROP TABLE IF EXISTS `sys_info_set`;
CREATE TABLE `sys_info_set` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '信息编码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表名称',
  `is_sys` int(5) DEFAULT NULL COMMENT '是否为系统表0是 1否',
  `character_set` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '信息集字符集',
  `remark` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='信息集表';

-- ----------------------------
-- Records of sys_info_set
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=494 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '根目录', '0', '0', '0', null, null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统管理', '1', '200', '0', null, null, 'el-icon-setting', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '用户管理', '2', '210', '0', 'sysUserInfo', '/sys/sysUserInfo', 'el-icon-user', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '日志管理', '2', '220', '0', 'logInfo', '/sys/logInfo', 'el-icon-s-release', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '2', '230', '0', 'menuInfo', '/sys/menuInfo', 'el-icon-s-operation', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6', '角色管理', '2', '240', '0', 'sysRoleInfo', '/sys/sysRoleInfo', 'el-icon-s-check', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('7', '数据管理', '2', '250', '0', 'sysInfoSet', '/sys/sysInfoSet', 'el-icon-notebook-1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '字段详情', '7', '710', '0', 'sysInfoItem', '/sys/sysInfoItem', 'el-icon-notebook-1', null, null, null, null);

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
INSERT INTO `sys_role` VALUES ('2', 'Admin', '系统管理员', '0', '1,2,3,4,5,6,7,8,', '0', null, '1');

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
