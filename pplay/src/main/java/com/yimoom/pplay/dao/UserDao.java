package com.yimoom.pplay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.domain.SysUser;
import com.yimoom.pplay.log.DbLog;
@Mapper
public interface UserDao {
	@DbLog("账号密码")
	public SysUser findByUserName(String username);
}

