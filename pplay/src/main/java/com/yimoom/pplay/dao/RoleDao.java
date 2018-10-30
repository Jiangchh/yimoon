package com.yimoom.pplay.dao;

import org.springframework.stereotype.Repository;

import com.yimoom.pplay.domain.sys.SysRole;

import tk.mybatis.mapper.common.Mapper;
@Repository
public interface RoleDao extends Mapper<SysRole>{

}
