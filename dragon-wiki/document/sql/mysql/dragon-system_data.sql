BEGIN;
INSERT INTO `dragon_system`.`t_dragon_tenant` (`id`, `tenant_id`, `name`, `full_name`, `status`, `description`,
                                               `create_user`, `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('b90ba9d30e6d427fb94645a1c9535b7a', 10000000, 'machineswift', 'machineswift-fullName', 0, '描述',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_department` (`id`, `tenant_id`, `department_id`, `parent_id`, `code`, `name`,
                                                   `sort`, `create_user`, `create_time`, `update_user`, `update_time`,
                                                   `is_deleted`)
VALUES ('821098a85de14e249cca08378d49a38c', 10000000, 1, 0, '000001', '全部', 0,
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_user` (`id`, `tenant_id`, `account`, `password`, `code`, `name`, `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('831098a85de14e249cca08378d49a38c', 10000000, 'superadmin',
        '$2a$10$UNynLuoZnZ2N/LfqdJ6fE./l.tJkNsBLJibbBxhs4tpJzkzJjzave', NULL, '超级管理员',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_role` (`id`, `tenant_id`, `role_id`, `parent_id`, `code`, `name`, `sort`,
                                             `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('811098a85de14e249cca08378d49a38c', 10000000, 1, 0, 'SUPER_ADMIN', '超级管理员', 0,
        '831098a85de14e249cca08378d49a38c',
        1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_role` (`id`, `tenant_id`, `role_id`, `parent_id`, `code`, `name`, `sort`,
                                             `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('065d0169652a4452b69a086385ad9916', 10000000, 2, 0, 'USER', '普通用户', 0,
        '831098a85de14e249cca08378d49a38c',
        1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_role` (`id`, `tenant_id`, `role_id`, `parent_id`, `code`, `name`, `sort`,
                                             `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('5a6efaff36e44cd283fba229090c4088', 10000000, 3, 0, 'GUEST', '来宾用户', 0,
        '831098a85de14e249cca08378d49a38c',
        1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;

-- ---------------------------------------------------
-- 模块Id: 1-999
-- 标准菜单Id: 1001-1000_000
-- 自定义菜单id: 1000_001-10_000_000
-- ---------------------------------------------------
BEGIN;
-- 模块
INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('435e3df4fce94225ac2f09d4485268da', 10000000, 1, 0, 'SYSTEM', '系统模块', '系统模块', 'dragon-system-web', 990, 0,
        '系统模块', '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290,
        0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('06d236f58bac4c2bab25dccd788b0e9a', 10000000, 2, 0, 'PSS', '商品中心', '商品中心', 'dragon-pss-web', 980, 0, '商品中心',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('4bda86192e0e48c4963ca7c5cd5058c7', 10000000, 3, 0, 'OMS', '订单中心', '订单中心', 'dragon-oms-web', 970, 0, '订单中心',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('667fc9a25d4b48dfb3564521db0fb371', 10000000, 4, 0, 'PSM', '营销中心', '营销中心', 'dragon-psm-web', 960, 0, '营销中心',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('930a99a6c69a486e87f7bac724de100d', 10000000, 5, 0, 'CRM', '客户中心', '客户中心', 'dragon-crm-web', 950, 0, '客户中心',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;


BEGIN;
-- 菜单（系统模块）
-- 标准菜单Id: 1001-1000_000
INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('c0a3bfe4f3854f4b9296856089badbe7', 10000000, 1001, 1, 'SYSTEM_PERMISSION', '权限管理', '权限管理',
        'dragon-system-web/permission', 1000000, 0, '权限管理', '831098a85de14e249cca08378d49a38c', 1639731002290,
        '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('56e6a4b43505421196e9ae5c3fd36aee', 10000000, 1002, 1001, 'SYSTEM_USER', '用户管理', '用户管理',
        'dragon-system-web/permission/user', 900, 1, '用户管理', '831098a85de14e249cca08378d49a38c', 1639731002290,
        '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('e5c15c10e897401c8347924937dbe81b', 10000000, 1003, 1001, 'SYSTEM_ROLE', '角色管理', '角色管理',
        'dragon-system-web/permission/role', 890, 1, '角色管理', '831098a85de14e249cca08378d49a38c', 1639731002290,
        '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

INSERT INTO `dragon_system`.`t_dragon_menu` (`id`, `tenant_id`, `menu_id`, `parent_id`, `code`, `name`, `alias`, `path`,
                                             `sort`, `is_opened`, `description`, `create_user`, `create_time`,
                                             `update_user`, `update_time`, `is_deleted`)
VALUES ('bd21f6ed8703481983a4e797d5bad8cc', 10000000, 1004, 1001, 'SYSTEM_DEPARTMENT', '部门管理', '部门管理',
        'dragon-system-web/permission/department', 880, 1, '部门管理', '831098a85de14e249cca08378d49a38c',
        1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);

COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_user_department` (`id`, `tenant_id`, `department_id`, `user_id`, `create_time`,
                                                        `update_time`)
VALUES ('811098a85de14e249cca08378d49a38c', 10000000, 1, '831098a85de14e249cca08378d49a38c', 1639731002290,
        1639731002290);
COMMIT;