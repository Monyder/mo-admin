/*
Navicat MySQL Data Transfer

Source Server         : 本机mysql8.0.15
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : base-project

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-01-07 16:46:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of students
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='信息项表';

-- ----------------------------
-- Records of sys_info_item
-- ----------------------------
INSERT INTO `sys_info_item` VALUES ('112', 'students', 'id', '主键', '2', '20', null, '0', null, '主键', '0', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='信息集表';

-- ----------------------------
-- Records of sys_info_set
-- ----------------------------
INSERT INTO `sys_info_set` VALUES ('33', 'students', '学生表', '1', 'utf8', '学生表', '2021-01-07 13:53:08');

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
) ENGINE=InnoDB AUTO_INCREMENT=586 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('494', 'admin', '2020-12-30 10:29:43', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('495', 'admin', '2020-12-30 10:30:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('496', 'admin', '2020-12-31 16:59:14', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('497', 'admin', '2021-01-04 10:47:51', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('498', 'admin', '2021-01-04 10:49:30', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('499', 'admin', '2021-01-04 10:49:32', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('500', 'admin', '2021-01-04 10:49:34', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('501', 'admin', '2021-01-04 10:49:36', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('502', 'admin', '2021-01-04 10:49:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('503', 'admin', '2021-01-04 10:51:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('504', 'admin', '2021-01-04 10:51:41', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('505', 'admin', '2021-01-04 10:51:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('506', 'admin', '2021-01-04 10:51:47', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('507', 'admin', '2021-01-04 10:51:56', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('508', 'admin', '2021-01-04 10:52:10', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('509', 'admin', '2021-01-04 10:52:53', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('510', 'admin', '2021-01-04 10:55:54', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('511', 'admin', '2021-01-04 11:01:59', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('512', 'admin', '2021-01-04 11:02:05', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('513', 'admin', '2021-01-04 15:29:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('514', 'admin', '2021-01-07 11:23:57', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('515', 'admin', '2021-01-07 11:24:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('516', 'admin', '2021-01-07 11:24:59', '192.168.1.208', '角色管理', '修改角色', null, null, null);
INSERT INTO `sys_log` VALUES ('517', 'admin', '2021-01-07 11:25:03', '192.168.1.208', '角色管理', '删除角色', null, null, null);
INSERT INTO `sys_log` VALUES ('518', 'admin', '2021-01-07 13:55:47', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('519', 'admin', '2021-01-07 15:01:09', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('520', 'admin', '2021-01-07 15:08:20', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('521', 'admin', '2021-01-07 15:08:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('522', 'admin', '2021-01-07 15:08:25', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('523', 'admin', '2021-01-07 15:12:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('524', 'admin', '2021-01-07 15:12:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('525', 'admin', '2021-01-07 15:12:42', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('526', 'admin', '2021-01-07 15:12:44', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('527', 'admin', '2021-01-07 15:12:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('528', 'admin', '2021-01-07 15:12:49', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('529', 'admin', '2021-01-07 15:13:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('530', 'admin', '2021-01-07 15:13:31', '192.168.1.208', '角色管理', '添加角色', null, null, null);
INSERT INTO `sys_log` VALUES ('531', 'admin', '2021-01-07 15:13:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('532', 'admin', '2021-01-07 15:13:46', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('533', 'admin', '2021-01-07 15:14:03', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('534', 'admin', '2021-01-07 15:14:43', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('535', 'admin', '2021-01-07 15:14:50', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('536', 'admin', '2021-01-07 15:16:22', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('537', 'admin', '2021-01-07 15:17:17', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('538', 'admin', '2021-01-07 15:17:32', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('539', 'admin', '2021-01-07 15:17:34', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('540', 'admin', '2021-01-07 15:17:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('541', 'admin', '2021-01-07 15:17:41', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('542', 'admin', '2021-01-07 15:17:47', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('543', 'admin', '2021-01-07 15:17:49', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('544', 'admin', '2021-01-07 15:18:13', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('545', 'admin', '2021-01-07 15:19:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('546', 'admin', '2021-01-07 15:20:03', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('547', 'admin', '2021-01-07 15:20:57', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('548', 'admin', '2021-01-07 15:27:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('549', 'admin', '2021-01-07 15:27:50', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('550', 'admin', '2021-01-07 15:32:15', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('551', 'admin', '2021-01-07 15:32:28', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('552', 'admin', '2021-01-07 15:32:30', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('553', 'admin', '2021-01-07 15:32:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('554', 'admin', '2021-01-07 15:32:34', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('555', 'admin', '2021-01-07 15:32:36', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('556', 'admin', '2021-01-07 15:32:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('557', 'admin', '2021-01-07 15:32:39', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('558', 'admin', '2021-01-07 15:32:44', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('559', 'admin', '2021-01-07 15:32:51', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('560', 'admin', '2021-01-07 15:32:52', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('561', 'admin', '2021-01-07 15:33:04', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('562', 'admin', '2021-01-07 15:34:29', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('563', 'admin', '2021-01-07 15:34:31', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('564', 'admin', '2021-01-07 15:34:32', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('565', 'admin', '2021-01-07 15:34:33', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('566', 'admin', '2021-01-07 15:34:35', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('567', 'admin', '2021-01-07 15:34:37', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('568', 'admin', '2021-01-07 15:34:38', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('569', 'admin', '2021-01-07 15:34:40', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('570', 'admin', '2021-01-07 15:34:41', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('571', 'admin', '2021-01-07 15:34:42', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('572', 'admin', '2021-01-07 15:34:45', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('573', 'admin', '2021-01-07 15:34:47', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('574', 'admin', '2021-01-07 15:34:48', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('575', 'admin', '2021-01-07 15:34:50', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('576', 'admin', '2021-01-07 15:34:54', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('577', 'admin', '2021-01-07 15:34:56', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('578', 'admin', '2021-01-07 15:34:57', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('579', 'admin', '2021-01-07 15:35:00', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('580', 'admin', '2021-01-07 15:35:06', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('581', 'admin', '2021-01-07 15:35:11', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('582', 'admin', '2021-01-07 15:35:12', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('583', 'admin', '2021-01-07 15:35:47', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('584', 'admin', '2021-01-07 15:35:50', '192.168.1.208', '角色管理', '修改权限', null, null, null);
INSERT INTO `sys_log` VALUES ('585', 'admin', '2021-01-07 16:30:50', '192.168.1.208', '菜单功能', '修改菜单操作', null, null, null);

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
  `func_type` int(11) DEFAULT NULL COMMENT '功能类别：0：系统功能 1：开发功能',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `spare_one` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `spare_two` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `spare_three` varchar(100) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '根目录', '0', '0', '0', null, null, null, '0', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统管理', '1', '200', '0', null, null, 'el-icon-setting', '0', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '用户管理', '2', '210', '0', 'sysUserInfo', '/sys/sysUserInfo', 'el-icon-user', '0', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '日志管理', '2', '220', '0', 'logInfo', '/sys/logInfo', 'el-icon-s-release', '0', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '2', '230', '0', 'menuInfo', '/sys/menuInfo', 'el-icon-s-operation', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6', '角色管理', '2', '240', '0', 'sysRoleInfo', '/sys/sysRoleInfo', 'el-icon-s-check', '0', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('7', '数据管理', '2', '250', '0', 'sysInfoSet', '/sys/sysInfoSet', 'el-icon-notebook-1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '字段详情', '7', '710', '0', 'sysInfoItem', '/sys/sysInfoItem', 'el-icon-notebook-1', null, null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2', 'Admin', '系统管理员', '0', '1,2,3,4,6', '0', null, '1');
INSERT INTO `sys_role` VALUES ('5', 'test', '测试角色', '0', '1,2,3', '0', null, '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2', '张孝美', '15140006656', '管理员', null, null, null);
INSERT INTO `sys_user` VALUES ('8', 'test', '202cb962ac59075b964b07152d234b70', '5', '张三', '15142055652', null, null, null, null);
