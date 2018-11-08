use  yimosystemdb;

		select u.*,r.rid,r.Description,r.Role_Name from
		Sys_User u,Sys_user_role ur,Sys_role r
        where u.uid=ur.uid
        and ur.rid=r.rid;
        
   select Uid,Name,Account,Password,Icon,NickName,Gender,Age,PhoneNo,Mail,CreateDate,Version,
		Status,Remark,OrderNo,OnlineStatus,LastAccessTime from Sys_User where account='admin';
 select u.uid,r.rid from sys_user u,sys_role r;
 select * from sys_user;
 select * from sys_role ; 
 select * from sys_user_role;
 select
		su.Uid,su.Name,su.Gender,sr.role_name,su.PhoneNo,su.Mail,su.LastAccessTime,su.version,su.status
		FROM Sys_User su,sys_role sr,sys_user_role sur
		where
			su.uid=sur.uid and sr.rid=sur.rid
			And su.Name='2b'
			 And su.Gender=''
			And sr.Role_Name='';
            
            
select
  `PTid`            as 编号,
  `Name`            as 类型名称,
  `Description`     as 描述,
  `CreatorId`       as 创建人编号,
  `CreatorName`     as 创建人姓名,
  `CreateDate`      as 创建日期,
  `OrderNo`         as 排序号,
  `Version`         as 版本号
from `play_type` t;
select did from play_difficulty  where name='简单';

select * from play_type;
select d.timeperiods,d.name,d.role_num,df.name dfname,t.name typename,d.Introduction from play_drama d,play_difficulty df,play_type t,play_drama_type dt
where d.DifficultyId=df.did and t.ptid=dt.ptid and dt.pid=d.pid and d.Role_Num=3
and t.key=0 and df.key=0

;

