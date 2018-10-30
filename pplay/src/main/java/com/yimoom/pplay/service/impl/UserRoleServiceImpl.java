package com.yimoom.pplay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.dao.UserRoleMapper;
import com.yimoom.pplay.domain.sys.SysRole;
import com.yimoom.pplay.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleMapper userRoleMapper;
	@Override
	@Cacheable(value = "people", key = "#userId")
	public List<SysRole> listByUserId(long userId) {
		// TODO Auto-generated method stub
		return userRoleMapper.listByUserId(userId);
	}

}
