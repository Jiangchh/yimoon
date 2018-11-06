package com.yimoom.pplay.service;

import java.util.List;

import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;

public interface SysUserService {
	public  List<SysUser>getUser(SysUser user);
	public  List<SysUser>SearchUser(QuerySysUser user);
}
