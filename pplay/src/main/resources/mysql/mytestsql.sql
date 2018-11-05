create database testdb;
use  testdb;
create table `sys_user`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`username` varchar(255) DEFAULT NULL COMMENT '用户名',
`password` varchar(255) DEFAULT NULL COMMENT '密码',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='用户表';
insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'abel', 'abel');

create table `sys_role`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(255) DEFAULT NULL COMMENT '角色',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='角色表';
insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

drop table if EXISTS sys_role_user;
create table `sys_role_user`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`sys_user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
`sys_role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';
insert into SYS_ROLE_USER(SYS_USER_ID,SYS_ROLE_ID) values(1,1);
insert into SYS_ROLE_USER(SYS_USER_ID,SYS_ROLE_ID) values(2,2);



create table `sys_permission`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`sys_user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
`sys_role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';
insert into SYS_ROLE_USER(SYS_USER_ID,SYS_ROLE_ID) values(1,1);
insert into SYS_ROLE_USER(SYS_USER_ID,SYS_ROLE_ID) values(2,2);
