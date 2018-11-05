package com.yimoom.pplay.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.dao.SysUserRoleMapper;
import com.yimoom.pplay.domain.sys.SysRole;
import com.yimoom.pplay.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	SysUserRoleMapper userRoleMapper;
	@Override
	//@Cacheable(value = "people", key = "#userId")
	public List<SysRole> listByUserId(long userId) {
		return userRoleMapper.listByUserId(userId);
	}

}
