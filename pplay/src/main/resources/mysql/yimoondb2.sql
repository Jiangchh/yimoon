create database if not exists yimosystemdb;
use  yimosystemdb;
-- Sys_User
/*
警告: 字段名可能非法 - Password
警告: 字段名可能非法 - Status
*/

create table if not exists `Sys_User`
(
       `Uid`             bigint(20) auto_increment not null comment '编号',
       `Name`            VARCHAR(20) comment '人名',
       `Account`         VARCHAR(20) comment '账号',
       `Password`        VARCHAR(100) comment '密码',
       `Icon`            VARCHAR(255) comment '图片路径',
       `NickName`        VARCHAR(255) comment '昵称',
       `Gender`          tinyint(2) comment '性别 男为1，女为0',
       `Age`             tinyint(3) comment '年龄',
       `PhoneNo`         int(11) comment '手机号',
       `Mail`            VARCHAR(50) comment '邮箱',
       `CreateDate`      DATETIME comment '创建时间',
       `Version`         bigint(20) comment '版本号',
       `Status`          tinyint(2) comment '状态 状态id',
       `Remark`          VARCHAR(255) comment '备注',
       `OrderNo`         bigint(20) comment '排序号',
       `OnlineStatus`    tinyint(3) comment '在线状态码',
       `LastAccessTime`  DATETIME comment '最后访问时间',
       `Attribute2`      VARCHAR(255) comment '备用字段2',
        PRIMARY KEY (`Uid`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户个人信息表';
 create unique index `IDU_Sys_User_Account` on `Sys_User`(`Account`);
 create unique index `IDU_Sys_User_PhoneNo` on `Sys_User`(`PhoneNo`);
 create index `IDX_Sys_User_Status` on `Sys_User`(`Status`);
-- 缺少了盐，uuid，pid
-- Sys_Role
/*
警告: 字段名可能非法 - Status
*/
create table if not exists `Sys_Role`
(
       `Rid`             bigINT auto_increment  not null comment '编号',
       `Role_Name`       varchar(25) comment '角色名称',
       `Description`     varchar(25) comment '描述',
       `Remark`          VARCHAR(255) comment '备注',
       `Status`          tinyint(2) comment '状态 和状态表相关联',
       `Version`         bigint(20) comment '版本号',
       `OrderNo`         bigINT comment '排序号',
       `CreateDate`      DATETIME comment '创建时间',
       `Attribute1`      VARCHAR(255) comment '备用字段',
       `Attribute2`      VARCHAR(255) comment '备用字段',
        PRIMARY KEY (`Rid`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户角色表';
 create index `IDX_Sys_Role_Status` on `Sys_Role`(`Status`);

-- Sys_Post
/*
警告: 字段名可能非法 - Status
*/
create table if not exists `Sys_Post`
(
       `Pid`             bigINT auto_increment not null comment '编号',
       `Post_Name`       VARCHAR(25) comment '职位名称',
       `Description`     varchar(25) comment '职位描述',
       `Remark`          VARCHAR(255) comment '备注',
       `Status`          tinyint(3) comment '状态',
       `Version`         bigINT comment '版本号',
       `OrderNo`         bigint(20) comment '排序号',
       `CreateDate`      DATETIME comment '创建时间',
       `Attribute`       VARCHAR(255) comment '备用字段',
       PRIMARY KEY (`Pid`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户职位表';

 create index `IDX_Sys_Post_Status` on `Sys_Post`(`Status`);

-- Sys_Permission
/*
警告: 字段名可能非法 - Type
*/
create table if not exists `Sys_Permission`
(
       `PerId`           bigINT auto_increment not null comment '编号',
       `Name`            VARCHAR(25) comment '权限名称',
       `Url`             VARCHAR(255) comment '路径',
       `Type`            VARCHAR(255) comment '资源类型',
       `Parent_id`       bigINT comment '父编号',
       `Description`     VARCHAR(255) comment '描述',
       `Remark`          VARCHAR(255) comment '备注',
       `OrderNo`         bigINT comment '排序号',
       `CreateDate`      DATETIME comment '创建时间',
       `Attribute2`      VARCHAR(255) comment '备用字段',
        PRIMARY KEY (`PerId`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户权限表';


-- Sys_User_Role
create table if not exists `Sys_User_Role`
(
       `Id`              bigINT auto_increment not null comment '编号',
       `Uid`             bigINT comment '用户表',
       `Rid`             bigINT comment '角色表',
       `Attribute1`      VARCHAR(255) comment '备用字段',
       `Attribute2`      VARCHAR(255) comment '备用字段',
        PRIMARY KEY (`Id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- Sys_Role_Permission
create table if not exists `Sys_Role_Permission`
(
       `Id`              bigINT auto_increment not null comment '编号',
       `PerId`           bigINT comment '权限表',
       `Rid`             bigINT comment '用户表',
       `OrderNo`         bigINT comment '排序号',
       `Attribute2`      VARCHAR(255) comment '备用字段',
        PRIMARY KEY (`Id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='角色权限表';


-- Sys_Role_Post
create table if not exists `Sys_Role_Post`
(
       `Id`              bigINT auto_increment not null comment '编号',
       `Pid`             bigINT comment '岗位表',
       `Rid`             bigINT comment '角色表',
       `Attribute1`      VARCHAR(255) comment '备用字段1',
       `Attribute2`      VARCHAR(255) comment '备用字段2',
        PRIMARY KEY (`Id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='角色岗位表';


-- Sys_User_Login
create table if not exists `Sys_User_Login`
(
       `Id`              bigint auto_increment not null comment '编号',
       `Uid`             bigint comment '用户表',
       `loginTime`       DATETIME comment '登陆时间',
       `loginIp`         VARCHAR(36) comment '登陆ip',
       `loginSrc`        tinyint(3) comment '登录来源 0：网页，1：app',
       `remark`          VARCHAR(255) comment '备注',
       `IdentityType`    tinyint(3) comment '登录类型',
       `Identifier`      VARCHAR(255) comment '唯一标识 (手机号/邮箱/用户名或第三方应用的唯一标识)',
       `Credential`      VARCHAR(255) comment '密码凭证  (站内的保存密码 , 站外的不保存或保存 token)',
       `OrderNo`         bigINT comment '排序号',
        PRIMARY KEY (`Id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户登录表';

alter  table `Sys_User_Role`
       add constraint `FK_Sys_User_Role_Uid` foreign key (`Uid`)
       references `Sys_User`(`Uid`);
alter  table `Sys_User_Role`
       add constraint `FK_Sys_User_Role_Rid` foreign key (`Rid`)
       references `Sys_Role`(`Rid`);

alter  table `Sys_Role_Permission`
       add constraint `FK_Sys_Rolion_PerId5FCB` foreign key (`PerId`)
       references `Sys_Permission`(`PerId`);
alter  table `Sys_Role_Permission`
       add constraint `FK_Sys_Rolion_Rid45B1` foreign key (`Rid`)
       references `Sys_Role`(`Rid`);

alter  table `Sys_Role_Post`
       add constraint `FK_Sys_Role_Post_Pid` foreign key (`Pid`)
       references `Sys_Post`(`Pid`);
alter  table `Sys_Role_Post`
       add constraint `FK_Sys_Role_Post_Rid` foreign key (`Rid`)
       references `Sys_Role`(`Rid`);

alter  table `Sys_User_Login`
       add constraint `FK_Sys_User_Login_Id` foreign key (`Id`)
       references `Sys_User`(`Uid`);

