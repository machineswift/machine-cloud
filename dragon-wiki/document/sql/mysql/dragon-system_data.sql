BEGIN;
INSERT INTO `dragon_system`.`t_dragon_tenant` (`id`, `tenant_id`, `name`, `status`, `create_time`, `update_time`,
                                               `is_deleted`)
VALUES ('b90ba9d30e6d427fb94645a1c9535b7a', 10000000, 'machineswift', 0, '2021-12-14 07:20:13', '2021-12-14 07:20:13',
        0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_department` (`id`, `tenant_id`, `department_id`, `parent_id`, `code`, `name`,
                                                   `sort`, `is_deleted`, `create_time`, `update_time`)
VALUES ('821098a85de14e249cca08378d49a38c', 10000000, 1, 0, '000001', '全部', 0, 0, '2021-11-22 03:23:49',
        '2021-11-22 03:23:49');
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_user` (`id`, `tenant_id`, `user_id`, `account`, `password`, `code`, `name`,
                                             `create_user`, `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('1', 10000000, '831098a85de14e249cca08378d49a38c', 'superadmin',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', NULL, '超级管理员',
        '831098a85de14e249cca08378d49a38c', '2021-11-22 09:07:14', '831098a85de14e249cca08378d49a38c',
        '2021-11-22 09:09:00', 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_role` (`id`, `tenant_id`, `role_id`, `parent_id`, `name`, `sort`, `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('811098a85de14e249cca08378d49a38c', 10000000, 1, 0, '超级管理员', 0, '831098a85de14e249cca08378d49a38c',
        '2021-11-29 09:11:26', '831098a85de14e249cca08378d49a38c', '2021-11-29 09:11:26', 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_user_department` (`id`, `tenant_id`, `department_id`, `user_id`, `create_time`,
                                                        `update_time`)
VALUES ('811098a85de14e249cca08378d49a38c', 10000000, 1, '831098a85de14e249cca08378d49a38c', '2021-11-22 09:15:07',
        '2021-11-22 09:15:07');
COMMIT;