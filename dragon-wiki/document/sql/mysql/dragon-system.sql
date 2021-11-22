-- ----------------------------
-- Table structure for dragon_department
-- ----------------------------
DROP TABLE IF EXISTS `dragon_department`;
CREATE TABLE `dragon_department` (
    `id` varchar(32) NOT NULL COMMENT 'id',
    `tenant_id` int unsigned NOT NULL COMMENT '租户id',
    `department_id` bigint unsigned NOT NULL COMMENT '部门Id。根部门此字段为1',
    `parent_id` bigint unsigned NOT NULL COMMENT '父部门Id。根部门此字段为0',
    `code` varchar(32) DEFAULT NULL COMMENT '编码',
    `name` varchar(64) DEFAULT NULL COMMENT '名称',
    `sort` bigint unsigned NULL default 0 COMMENT '在父部门中的次序值。sort值大的排序靠前',
    `create_time` DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_time` DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_01`(`tenant_id`,`department_id`,`parent_id`) USING BTREE,
    KEY `idx_01` (`tenant_id`,`parent_id`) USING BTREE,
    KEY `idx_02` (`tenant_id`,`code`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT='部门表';

BEGIN;
INSERT INTO `dragon_system`.`dragon_department` (`id`, `tenant_id`, `department_id`, `parent_id`, `code`, `name`, `sort`, `is_deleted`, `create_time`, `update_time`)
VALUES ('821098a85de14e249cca08378d49a38c', 1, 1, 0, '000001', '全部', 0, 0, '2021-11-22 03:23:49.885', '2021-11-22 03:23:49.885');
COMMIT;


-- ----------------------------
-- Table structure for dragon_user
-- ----------------------------
DROP TABLE IF EXISTS `dragon_user`;
CREATE TABLE `dragon_user`  (
    `id` varchar(32) NOT NULL COMMENT 'id',
    `tenant_id` int unsigned NOT NULL COMMENT '租户id',
    `user_id` varchar(32) NOT NULL COMMENT '用户id',
    `account` varchar(32) NULL DEFAULT NULL COMMENT '账号',
    `password` varchar(64) NULL DEFAULT NULL COMMENT '密码',
    `code` varchar(32) DEFAULT NULL COMMENT '编码',
    `name` varchar(64) DEFAULT NULL COMMENT '名称',
    `create_user` varchar(32) NOT NULL COMMENT '创建人',
    `create_time` DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_user` varchar(32) NOT NULL COMMENT '修改人',
    `update_time` DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    `is_deleted` int(2) NULL DEFAULT 0 COMMENT '是否已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表';

BEGIN;
INSERT INTO `dragon_system`.`dragon_user` (`id`, `tenant_id`, `user_id`, `account`, `password`, `code`, `name`, `create_user`, `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('1', 1, '831098a85de14e249cca08378d49a38c', 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', NULL, '管理员', '831098a85de14e249cca08378d49a38c', '2021-11-22 09:07:14.885', '831098a85de14e249cca08378d49a38c', '2021-11-22 09:09:00.885', 0);
COMMIT;


-- ----------------------------
-- Table structure for dragon_user_department
-- ----------------------------
DROP TABLE IF EXISTS `dragon_user_department`;
CREATE TABLE `dragon_user_department`  (
    `id` varchar(32) NOT NULL COMMENT 'id',
    `tenant_id` int unsigned NOT NULL COMMENT '租户id',
    `department_id` bigint unsigned NOT NULL COMMENT '部门ID',
    `user_id` varchar(32) NOT NULL COMMENT '用户ID',
    `create_time` DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_time` DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_01`(`tenant_id`,`department_id`,`user_id`) USING BTREE,
    KEY `idx_01` (`tenant_id`,`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户部门表';

BEGIN;
INSERT INTO `dragon_system`.`dragon_user_department` (`id`, `tenant_id`, `department_id`, `user_id`, `create_time`, `update_time`)
VALUES ('811098a85de14e249cca08378d49a38c', 1, 1, '831098a85de14e249cca08378d49a38c', '2021-11-22 09:15:07.885', '2021-11-22 09:15:07.885');
COMMIT;