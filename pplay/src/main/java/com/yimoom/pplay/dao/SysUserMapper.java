package com.yimoom.pplay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.common.base.dao.GenericDao;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;

@Mapper
public interface SysUserMapper extends GenericDao<SysUser, QuerySysUser>{

}