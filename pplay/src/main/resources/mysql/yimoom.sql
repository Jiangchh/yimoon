create database yimoondb;
use  yimoondb;
drop table `user_info`;-- 当心这里有删表语句
create table `user_info`(
`uid` bigint(20) NOT NULL AUTO_INCREMENT,
`username` varchar(25) DEFAULT NULL COMMENT '用户名',
`name` varchar(25) DEFAULT NULL COMMENT '真实姓名',
`identifyId` varchar(18) DEFAULT NULL COMMENT '身份证号',
`phoneId` int(18) DEFAULT NULL COMMENT '手机号',
`password` varchar(255) DEFAULT NULL COMMENT '密码',
`passwordsalt` varchar(255) DEFAULT NULL COMMENT '密码盐',
`state` int(2) DEFAULT NULL COMMENT '状态',
 PRIMARY KEY (`uid`)
)ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='用户表';

create table `sys_role`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`role` varchar(20) DEFAULT NULL COMMENT '角色',
`description` varchar(50)DEFAULT NULL COMMENT '角色描述',
`available` tinyint(1) DEFAULT NULL COMMENT '是否可用',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='角色表';

create table `SysPermission`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name`varchar(20)DEFAULT NULL COMMENT '名称',
`resourceType` varchar(20)DEFAULT NULL COMMENT '控件类型',
`url`varchar(20)DEFAULT NULL COMMENT '资源路径',
`permission`varchar(20)DEFAULT NULL COMMENT '权限功能',
`parentId`varchar(20)DEFAULT NULL COMMENT '父编号',
`parentIds`varchar(20)DEFAULT NULL COMMENT '父编号列表',
`available`  tinyint(1) DEFAULT NULL COMMENT '是否可用',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';


INSERT INTO SysPermission VALUES ('1',  '用户管理', '0', '0/', 'userInfo:view', 'menu', 'userInfo/userList',1);
INSERT INTO SysPermission VALUES ('2',  '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd',1);
INSERT INTO SysPermission VALUES ('3',  '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel',1);

INSERT INTO sys_role VALUES ('1', '管理员', 'admin',1);
INSERT INTO sys_role VALUES ('2', 'VIP会员', 'vip',1);

INSERT INTO user_info  VALUES ('1', 'admin','管理员' ,'',null,'d3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);


create table `sys_role_permission`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`role_id` varchar(20) DEFAULT NULL COMMENT '角色',
`permission_id` varchar(50)DEFAULT NULL COMMENT '权限id',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';
INSERT INTO sys_role_permission VALUES (0,'1', '1');
INSERT INTO sys_role_permission VALUES (1,'1', '2');
create table `sys_user_role`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`user_id` varchar(20) DEFAULT NULL COMMENT '用户id',
`prole_id` varchar(50)DEFAULT NULL COMMENT '角色id',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';
INSERT INTO sys_user_role VALUES (0,'1', '1');

