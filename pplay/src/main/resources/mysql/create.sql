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


-- Play_Drama
create table if not exists  `Play_Drama`
(
       `Pid`             bigINT auto_increment primary key not null comment '编号',
       `name`            varchar(50) comment '编剧名称',
       `CreatorId`       bigINT comment '作者编号',
       `CreatorName`     VARCHAR(20) comment '作者姓名',
       `Role_Num`        TINYINT comment '角色数量',
       `DifficultyId`      TINYINT comment '难度',
       `Introduction`    VARCHAR(255) comment '引言',
       `Brief`           VARCHAR(255) comment '简介',
       `Details`         VARCHAR(255) comment '详情',
       `CreateDate`      DATETIME comment '创建日期',
       `TimePeriods`     TINYINT(3) comment '大约时间,单位分钟',
       `Version`         INT comment '版本号',
       `Status`          TINYINT(3) comment '剧本状态 0正常 1审核中 2被否决 -1已删除 -2草稿',
       `OrderNo`         bigINT comment '排序号'
     
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='剧本表';

-- Play_Type
create table  `play_type`
(
       `PTid`            bigINT auto_increment primary key not null comment '编号',
       `Name`            VARCHAR(30) comment '类型名称',
       `Key`             TINYINT(3) comment '键值',
       `Description`     VARCHAR(50) comment '描述',
       `CreatorId`       INT comment '创建人编号',
       `CreatorName`     VARCHAR(20) comment '创建人姓名',
       `CreateDate`      DATETIME comment '创建日期',
	   `Version`         INT comment '版本号',
	   `Status`          TINYINT(3) comment '剧本状态 0正常 1审核中 2被否决 -1已删除 -2草稿',
       `OrderNo`         DOUBLE comment '排序号'
       
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='剧本类型表';

-- Play_Player
create table  `Play_Player`
(
       `PlayerId`        bigINT auto_increment primary key not null comment '编号',
       `Pid`             bigINT comment '剧本编号',
       `Name`            VARCHAR(50) comment '角色名',
       `Brief`           VARCHAR(255) comment '简介',
       `Mission`         VARCHAR(255) comment '任务',
       `Version`         INT comment '版本号',
       `CreatorName`     VARCHAR(20) comment '创建人姓名',
       `CreateDate`      DATETIME comment '创建日期',
       `Status`          TINYINT(3) comment '状态 0正常 1审核中 2被否决 -1已删除 -2草稿',
       `OrderNo`         DOUBLE comment '排序号'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='剧本角色表';

-- Play_Scene
create table  `play_scene`
(
       `Sid`             bigINT auto_increment primary key not null comment '编号',
       `Pid`             bigINT comment '剧本编号',
       `Name`            VARCHAR(255) comment '场景名称',
       `Description`     VARCHAR(255) comment '详情',
       `CreatorId`       bigINT comment '创建人编号',
       `CreatorName`     VARCHAR(20) comment '创建人姓名',
       `CreateDate`      DATETIME comment '创建日期',
       `Version`         INT comment '版本号',
       `Status`          TINYINT comment '状态 0正常 1审核中 2被否决 -1已删除 -2草稿',
       `OrderNo`         DOUBLE comment '排序号'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='剧本场景表';

-- Play_Clue
create table  `play_clue`
(
       `Cid`             bigINT auto_increment primary key not null comment '编号',
       `Pid`             bigINT comment '剧本编号',
       `Sid`             bigINT comment '场景编号',
       `Name`            VARCHAR(255) comment '线索名称',
       `Description`     VARCHAR(255) comment '线索描述',
       `CreatorId`       bigINT comment '创建人编号',
       `CreatorName`     VARCHAR(20) comment '创建人姓名',
       `CreateDate`      DATETIME comment '创建日期',
       `Version`         INT comment '版本号',
       `Status`          TINYINT comment '状态 0正常 1审核中 2被否决 -1已删除 -2草稿',
       `OrderNo`         DOUBLE comment '排序号'
      
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='剧本线索表';

-- play_drama_type
create table  `play_drama_type`
(
       `Id`              bigINT auto_increment primary key not null comment '编号',
       `Pid`             bigINT comment '剧本编号',
       `PTid`            bigINT comment '类型编号',
       `CreatorId`       bigINT comment '创建人编号',
       `Version`         INT comment '版本',
       `CreatorName`     VARCHAR(20) comment '创建人姓名',
       `CreateDate`      DATETIME comment '创建日期',
       `OrderNo`         DOUBLE comment '排序号'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='剧本类型关系表';


-- play_difficulty
create table  `play_difficulty`
(
       `Did`             bigINT auto_increment primary key not null comment '编号',
       `Key`             TINYINT comment '键值',
       `Name`            VARCHAR(20) comment '名称',
       `Version`         INT comment '版本号',
       `CreatorId`       INT comment '创建人编号',
       `CreatorName`     VARCHAR(20) comment '创建人姓名',
       `CreateDate`      DATETIME comment '创建日期',
       `OrderNo`         DOUBLE comment '排序号'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='难度表';



alter  table `play_drama`
       add constraint `FK_play_drama_difficuyIdF33F` foreign key (`difficultyId`)
       references `play_difficulty`(`Did`);

create index `IDX_play_difficulty_Key` on `play_difficulty`(`Key`);

alter  table `play_drama_type`
       add constraint `FK_play_drama_type_Pid` foreign key (`Pid`)
       references `play_drama`(`Pid`);
alter  table `play_drama_type`
       add constraint `FK_play_drama_type_PTid` foreign key (`PTid`)
       references `play_type`(`PTid`);
create index `IDX_play_drama_type_Pid` on `play_drama_type`(`Pid`);
create index `IDX_play_drama_type_PTid` on `play_drama_type`(`PTid`);


alter  table `play_clue`
       add constraint `FK_play_clue_Pid` foreign key (`Pid`)
       references `play_drama`(`Pid`);
alter  table `play_clue`
       add constraint `FK_play_clue_Sid` foreign key (`Sid`)
       references `play_scene`(`Sid`);
create index `IDX_play_clue_Pid` on `play_clue`(`Pid`);
create index `IDX_play_clue_Sid` on `play_clue`(`Sid`);

-- alter  table `play_drama`
--       add constraint `FK_play_drama_PT_id` foreign key (`PT_id`)
--       references `play_type`(`PTid`);
-- alter table `play_drama` drop foreign key `FK_play_drama_PT_id`;  
alter  table `play_drama`
       add constraint `FK_play_drama_CreatorId` foreign key (`CreatorId`)
       references `Sys_User`(`Uid`);
-- drop index `IDX_play_drama_PT_id` on `play_drama`;
create index `IDX_play_drama_CreatorId` on `play_drama`(`CreatorId`);
alter  table `play_player`
       add constraint `FK_play_player_Pid` foreign key (`Pid`)
       references `play_drama`(`Pid`);
create index `IDX_play_player_Pid` on `play_player`(`Pid`);
alter  table `play_scene`
       add constraint `FK_play_scene_Pid` foreign key (`Pid`)
       references `play_drama`(`Pid`);

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
-- alter table   play_drama add Role_Num TINYINT comment '角色数量';
-- alter table   play_drama add name varchar(50) comment '剧本名称';
-- alter table   play_drama drop pt_id ;-- TINYINT comment '角色数量';
-- alter table   play_drama add `DifficultyId`      TINYINT comment '难度';
-- alter table   play_type  add `Key`             TINYINT(3) comment '键值';
-- alter table   play_drama add  `TimePeriods`     TINYINT(3) comment '大约时间,单位分钟';
create index `IDX_play_drama_Role_Num` on `play_drama`(`Role_Num`);
create index `IDX_play_drama_Difficulty` on `play_drama`(`Difficulty`);
create index `IDX_play_type_Key` on `play_type`(`Key`);


