package com.yimoom.pplay.service;

import java.util.List;

import com.yimoom.pplay.domain.sys.SysRole;

public interface SysUserRoleService {
	public List<SysRole> listByUserId(long userId) ;
}
