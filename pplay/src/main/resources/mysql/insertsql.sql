INSERT INTO
		Sys_user(
		Name,Account,Password,Icon,NickName,
		Gender,
		Age,
		PhoneNo,
		Mail,
		CreateDate,
		Version,
		Status,
		Remark,
		OrderNo,
		OnlineStatus,
		LastAccessTime
		)
		VALUES(
	'2b','admin','$2a$10$.o993Q.EijUWLx.qqqGPsug8i7lpZxyq2Qfx0axblRfeSNbfrUqua',
    null,
    '2b',
    0,
    1,
    1234567890,
    '1395067756@qq.com',
    now(),
    0,
    01,
    null,
    0,
    0,
    now()
		);
        
insert into sys_role(
role_name,description,remark,status,version,orderno,createdate
)values(
'admin',null,null,0,1,0,now());

insert into sys_user_role(uid,rid)values(1,1);




insert into `play_type`
(
  `Name`,
  `Description`,
  `CreatorId`,
  `CreatorName`,
  `CreateDate`,
  `OrderNo`,
  `Version`
)
values(
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
);


insert into `play_difficulty`
(
  `Key`,
  `Name`,
  `Version`,
  `CreatorId`,
  `CreatorName`,
  `CreateDate`,
  `OrderNo`
)
values(
   2,
  '困难',-- '普通',-- '简单',
  1,
  1,
  '2b',
  now(),
  null
);
insert into `play_drama`
(
  `CreatorId`,
  `CreatorName`,
  `Role_Num`,
  `difficultyId`,
  `Introduction`,
  `Brief`,
  `Details`,
  `CreateDate`,
  `Version`,
  `Status`,
  `OrderNo`
)
values(
  '1',
  '2b',
   5,
  (select did from play_difficulty  where name='困难' ),
  'N年前，他是公立的太医，当她遇到她的时候，她有死了。。。',
  null,
  null,
  now(),
  1,
  null,
  null
);

insert into `play_drama_type`
(
 
  `Pid`,
  `PTid`,
  `CreatorId`,
  `Version`,
  `CreatorName`,
  `CreateDate`,
  `OrderNo`
)
values(
  
  1,
  4,
  1,
  1,
  '2b',
  now(),
  null
);