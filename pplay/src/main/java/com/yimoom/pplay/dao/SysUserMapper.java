package com.yimoom.pplay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.common.base.dao.GenericDao;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;

@Mapper
public interface SysUserMapper extends GenericDao<SysUser, QuerySysUser>{
	public SysUser findByUserName(String account);
	public SysUser getUserById(long id);
	public List<SysUser>getUser(SysUser user);
	public List<SysUser>SearchUser(QuerySysUser user);
}
