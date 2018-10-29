package com.yimoom.pplay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.domain.sys.SysUser;
@Mapper
public interface UserDao {
	public SysUser findByUserName(String username);
}

