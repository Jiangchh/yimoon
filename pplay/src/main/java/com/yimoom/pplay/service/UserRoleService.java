package com.yimoom.pplay.service;

import java.util.List;

import com.yimoom.pplay.domain.sys.SysRole;

public interface UserRoleService {
	public List<SysRole> listByUserId(long userId) ;
}
