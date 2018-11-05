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