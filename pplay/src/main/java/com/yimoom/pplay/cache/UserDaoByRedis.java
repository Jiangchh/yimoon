package com.yimoom.pplay.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.domain.sys.SysUser;
@Service
public class UserDaoByRedis extends GenericDaoByRedis<SysUser> {
	private static final Logger logger=LoggerFactory.getLogger(UserDaoByRedis.class);

	public void saveUser(com.yimoom.pplay.domain.sys.SysUser user,String key) {
		if(user!=null){
			saveObject(user, key);
			logger.info("将用户插入缓存 >> " +"id: "+ user.getUid()+", username: "+user.getAccount()+",password: "+user.getPassword());
		}
	}
	public SysUser getUser(String key) {
		SysUser user=getObject(key);
		if(user!=null)
		logger.info("从缓存中获取了用户 >> " +"id: "+ user.getUid()+", username: "+user.getAccount()+",password: "+user.getPassword());
		return user;

	}

}
