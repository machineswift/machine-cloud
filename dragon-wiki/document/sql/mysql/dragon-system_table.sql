-- ----------------------------
-- Table structure for t_dragon_department
-- ----------------------------
DROP TABLE IF EXISTS `t_dragon_department`;
CREATE TABLE `t_dragon_department`
(
    `id`            varchar(32) NOT NULL COMMENT 'id',
    `tenant_id`     int unsigned NOT NULL COMMENT '租户id',
    `department_id` bigint unsigned NOT NULL COMMENT '部门Id。根部门此字段为1',
    `parent_id`     bigint unsigned NOT NULL COMMENT '父部门Id。根部门此字段为0',
    `code`          varchar(32) DEFAULT NULL COMMENT '编码',
    `name`          varchar(64) DEFAULT NULL COMMENT '名称',
    `sort`          bigint unsigned NULL default 0 COMMENT '在父部门中的次序值。sort值大的排序靠前',
    `create_time`   DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_time`   DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    `is_deleted`    tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_01`(`tenant_id`,`department_id`,`parent_id`) USING BTREE,
    KEY             `idx_01` (`tenant_id`,`parent_id`) USING BTREE,
    KEY             `idx_02` (`tenant_id`,`code`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT='部门表';

-- ----------------------------
-- Table structure for t_dragon_user
-- ----------------------------
DROP TABLE IF EXISTS `t_dragon_user`;
CREATE TABLE `t_dragon_user`
(
    `id`          varchar(32) NOT NULL COMMENT 'id',
    `tenant_id`   int unsigned NOT NULL COMMENT '租户id',
    `user_id`     varchar(32) NOT NULL COMMENT '用户id',
    `account`     varchar(32) NULL DEFAULT NULL COMMENT '账号',
    `password`    varchar(64) NULL DEFAULT NULL COMMENT '密码',
    `code`        varchar(32) DEFAULT NULL COMMENT '编码',
    `name`        varchar(64) DEFAULT NULL COMMENT '名称',
    `create_user` varchar(32) NOT NULL COMMENT '创建人',
    `create_time` DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_user` varchar(32) NOT NULL COMMENT '修改人',
    `update_time` DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    `is_deleted`  tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表';

-- ----------------------------
-- Table structure for t_dragon_role
-- ----------------------------
DROP TABLE IF EXISTS `t_dragon_role`;
CREATE TABLE `t_dragon_role`
(
    `id`          varchar(32) NOT NULL COMMENT 'id',
    `tenant_id`   int unsigned NOT NULL COMMENT '租户id',
    `role_id`     bigint unsigned NOT NULL COMMENT '角色Id。超级管理员角色此字段为1',
    `parent_id`   bigint unsigned NOT NULL COMMENT '父角色Id。超级管理角色此字段为0',
    `name`        varchar(64) DEFAULT NULL COMMENT '名称',
    `sort`        int(11) NULL DEFAULT NULL COMMENT '排序',
    `create_user` varchar(32) NOT NULL COMMENT '创建人',
    `create_time` DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_user` varchar(32) NOT NULL COMMENT '修改人',
    `update_time` DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    `is_deleted`  tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_01`(`tenant_id`,`role_id`,`parent_id`) USING BTREE,
    KEY           `idx_01` (`tenant_id`,`parent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表';

-- ----------------------------
-- Table structure for dragon_user_department
-- ----------------------------
DROP TABLE IF EXISTS `t_dragon_user_department`;
CREATE TABLE `t_dragon_user_department`
(
    `id`            varchar(32) NOT NULL COMMENT 'id',
    `tenant_id`     int unsigned NOT NULL COMMENT '租户id',
    `department_id` bigint unsigned NOT NULL COMMENT '部门ID',
    `user_id`       varchar(32) NOT NULL COMMENT '用户ID',
    `create_time`   DATETIME(3) NOT NULL DEFAULT now(3) COMMENT '创建时间',
    `update_time`   DATETIME(3) NOT NULL DEFAULT now(3) ON UPDATE now(3) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_01`(`tenant_id`,`department_id`,`user_id`) USING BTREE,
    KEY             `idx_01` (`tenant_id`,`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户部门表';


-- ----------------------------
-- Table structure for t_dragon_rabbit_dead_message
-- ----------------------------
DROP TABLE IF EXISTS `t_dragon_rabbit_dead_message`;
CREATE TABLE `t_dragon_rabbit_dead_message`
(
    `id`                 varchar(32)  NOT NULL COMMENT 'id',
    `tenant_id`          int unsigned NOT NULL COMMENT '租户id',
    `message_key`        varchar(128) NOT NULL COMMENT '消息唯一标识',
    `message_class_name` varchar(128) NOT NULL COMMENT '消息类的全路径名字',
    `publish_exchange`   varchar(128) NOT NULL COMMENT '交换机',
    `publish_routing_key` varchar(128) NOT NULL COMMENT '路由键',
    `publish_name`       varchar(64)  NOT NULL COMMENT '生产者名称',
    `subscribe_queues`   varchar(128) NOT NULL COMMENT '消费者队列',
    `subscribe_name`     varchar(64)  NOT NULL COMMENT '消费者名称',
    `max_resend_times`   int unsigned DEFAULT '0' COMMENT '最大重发次数',
    `resend_times`       int unsigned DEFAULT '0' COMMENT '重发次数',
    `last_send_time`     datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '最后一次重发时间',
    `subscribe_times`     int unsigned DEFAULT '0' COMMENT '消费次数',
    `last_subscribe_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '最后一次消费时间',
    `next_exe_time`      datetime(3) DEFAULT NULL COMMENT '下一次执行时间',
    `message_content`    text COMMENT '消息内容',
    `reason`             text COMMENT '最近一次失败原因	',
    `remark`             text COMMENT '备注',
    `create_time`        datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`        datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_deleted`         tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
    PRIMARY KEY (`id`),
    KEY                  `idx_01` (`tenant_id`,`message_key`),
    KEY                  `idx_02` (`next_exe_time`),
    KEY                  `idx_03` (`publish_routing_key`),
    KEY                  `idx_04` (`publish_exchange`,`publish_routing_key`),
    KEY                  `idx_05` (`subscribe_queues`),
    KEY                  `idx_06` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='rabbit 死亡消息表';

-- ----------------------------
-- Table structure for t_dragon_rabbit_reliable_message
-- ----------------------------
DROP TABLE IF EXISTS `t_dragon_rabbit_reliable_message`;
CREATE TABLE `t_dragon_rabbit_reliable_message`
(
    `id`                 varchar(32)  NOT NULL COMMENT 'id',
    `tenant_id`          int unsigned NOT NULL COMMENT '租户id',
    `message_key`        varchar(128) NOT NULL COMMENT '消息唯一标识',
    `message_class_name` varchar(128) NOT NULL COMMENT '消息类的全路径名字',
    `publish_exchange`   varchar(128) NOT NULL COMMENT '交换机',
    `publish_routing_key` varchar(128) NOT NULL COMMENT '路由键',
    `publish_name`       varchar(64)  NOT NULL COMMENT '生产者名称',
    `subscribe_queues`   varchar(128) NOT NULL COMMENT '消费者队列',
    `subscribe_name`     varchar(64)  NOT NULL COMMENT '消费者名称',
    `max_resend_times`   int unsigned DEFAULT '0' COMMENT '最大重发次数',
    `resend_times`       int unsigned DEFAULT '0' COMMENT '重发次数',
    `last_send_time`     datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '最后一次重发时间',
    `subscribe_times`     int unsigned DEFAULT '0' COMMENT '消费次数',
    `last_subscribe_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '最后一次消费时间',
    `next_exe_time`      datetime(3) DEFAULT NULL COMMENT '下一次执行时间',
    `message_content`    text COMMENT '消息内容',
    `reason`             text COMMENT '最近一次失败原因	',
    `remark`             text COMMENT '备注',
    `create_time`        datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`        datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_deleted`         tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_01` (`tenant_id`,`message_key`),
    KEY                  `idx_02` (`next_exe_time`),
    KEY                  `idx_03` (`publish_routing_key`),
    KEY                  `idx_04` (`publish_exchange`,`publish_routing_key`),
    KEY                  `idx_05` (`subscribe_queues`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='rabbit 可靠消息表';