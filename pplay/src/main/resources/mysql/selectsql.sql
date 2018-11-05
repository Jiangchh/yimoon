use  yimosystemdb;

		select u.*,r.rid,r.Description,r.Role_Name from
		Sys_User u,Sys_user_role ur,Sys_role r
        where u.uid=ur.uid
        and ur.rid=r.rid;
        
   select Uid,Name,Account,Password,Icon,NickName,Gender,Age,PhoneNo,Mail,CreateDate,Version,
		Status,Remark,OrderNo,OnlineStatus,LastAccessTime from Sys_User where account='admin';
 select u.uid,r.rid from sys_user u,sys_role r;