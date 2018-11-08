update Sys_user set icon='/img/a1.jpg' where uid=1;
update Sys_user set status=3 where uid=1;
SET SQL_SAFE_UPDATES = 0;
update sys_role x set x.description='领导' where x.role_name='admin' ;
update play_drama set name='南哥' where pid=2;
update play_drama set timeperiods=80 where pid=2;
update play_type x set x.key=8 where x.name='其他';
-- '奇幻',null,1,'2b',now(),null,1
-- '科幻',null,1,'2b',now(),null,1
-- '宫廷',null,1,'2b',now(),null,1
-- '校园',null,1,'2b',now(),null,1
-- '言情',null,1,'2b',now(),null,1
-- '悬疑',null,1,'2b',now(),null,1
-- '历史',null,1,'2b',now(),null,1
-- '武侠',null,1,'2b',now(),null,1
-- '豪门',null,1,'2b',now(),null,1
-- '惊悚',null,1,'2b',now(),null,1
-- '仙侠',null,1,'2b',now(),null,1
-- '其他',null,1,'2b',now(),null,1
-- '都市',null,1,'2b',now(),null,1
