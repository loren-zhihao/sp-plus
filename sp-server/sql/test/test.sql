DROP TABLE IF EXISTS user;
CREATE TABLE user(
    `id` Bigint(64) NOT NULL AUTO_INCREMENT  COMMENT '主键id' ,
    `username` VARCHAR(50) NOT NULL   COMMENT '用户名' ,
    `password` VARCHAR(255) NOT NULL   COMMENT '密码' ,
    `create_by` VARCHAR(32)    COMMENT '创建人' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_by` VARCHAR(32)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户表';

DROP TABLE IF EXISTS category;
CREATE TABLE category(
    `id` Bigint(64) NOT NULL AUTO_INCREMENT  COMMENT '主键id' ,
    `name` VARCHAR(50) NOT NULL   COMMENT '分类名称' ,
    `create_by` VARCHAR(32)    COMMENT '创建人' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_by` VARCHAR(32)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '密码分类表';

DROP TABLE IF EXISTS password;
CREATE TABLE password(
    `id` Bigint(64) NOT NULL AUTO_INCREMENT  COMMENT '主键id' ,
    `user_id` Bigint(64) NOT NULL   COMMENT '所属用户ID' ,
    `category_id` Bigint(64) NOT NULL   COMMENT '密码分类ID' ,
    `title` VARCHAR(100)    COMMENT '密码标题' ,
    `account` VARCHAR(100)    COMMENT '账号' ,
    `password` VARCHAR(100)    COMMENT '密码' ,
    `url` VARCHAR(200)    COMMENT '登录地址' ,
    `notes` VARCHAR(255)    COMMENT '备注' ,
    `create_by` VARCHAR(32)    COMMENT '创建人' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_by` VARCHAR(32)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '密码表';

ALTER TABLE `sp-dev`.category ADD user_id BIGINT NOT NULL COMMENT '用户id';
ALTER TABLE `sp-dev`.category CHANGE user_id user_id BIGINT NOT NULL COMMENT '用户id' AFTER id;


INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(18, 1, 'user', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(19, 1, 'user-add', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(40, 1, 'user-list', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(41, 1, 'user-delete', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(42, 1, 'user-deleteByIds', '2023-05-28 12:57:59');

INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category-add', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category-update', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category-list', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category-info', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category-delete', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'category-deleteByIds', '2023-05-28 12:57:59');

INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password-add', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password-update', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password-list', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password-info', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password-delete', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 1, 'password-deleteByIds', '2023-05-28 12:57:59');

ALTER TABLE `sp-dev`.sp_role MODIFY COLUMN create_time DATETIME DEFAULT CURRENT_TIMESTAMP  NULL COMMENT '创建时间';
ALTER TABLE `sp-dev`.sp_role_permission MODIFY COLUMN create_time DATETIME DEFAULT CURRENT_TIMESTAMP  NULL COMMENT '创建时间';

INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'category-add', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'category-update', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'category-delete', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'category-deleteByIds', '2023-05-28 12:57:59');

INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'password-add', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'password-update', '2023-05-28 09:54:11');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'password-delete', '2023-05-28 12:57:59');
INSERT INTO `sp-dev`.sp_role_permission
(id, role_id, permission_code, create_time)
VALUES(null, 3, 'password-deleteByIds', '2023-05-28 12:57:59');
