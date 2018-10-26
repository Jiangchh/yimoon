package com.yimoom.pplay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.domain.UserInfo;
@Mapper
public interface UserDao {
	public UserInfo findByUserName(String username);
}

