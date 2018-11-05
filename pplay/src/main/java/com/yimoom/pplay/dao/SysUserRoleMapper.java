package com.yimoom.pplay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yimoom.pplay.domain.sys.SysRole;

@Mapper
public interface SysUserRoleMapper{
	 @Select("select role.* from sys_role as role,sys_user_role ur where role.rid=ur.rid and ur.uid= #{userId}")
	  public  List<SysRole> listByUserId(long userId);
}
