package com.yimoom.pplay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.dao.SysUserMapper;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;
import com.yimoom.pplay.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	SysUserMapper usermapper;
	@Override
	public List<SysUser> getUser(SysUser user) {
		return usermapper.getUser(user);
	}
	@Override
	public List<SysUser> SearchUser(QuerySysUser user) {
		return usermapper.SearchUser(user);
	}

}
