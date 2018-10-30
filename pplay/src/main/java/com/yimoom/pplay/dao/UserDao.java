package com.yimoom.pplay.dao;

import org.springframework.stereotype.Repository;


import com.yimoom.pplay.domain.sys.SysUser;

import tk.mybatis.mapper.common.Mapper;
/**
 * 这个是借用了tk.mapper的通用方法
 * @author PC
 *
 */
@Repository
public interface UserDao extends Mapper<SysUser>{}
