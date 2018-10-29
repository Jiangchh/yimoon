package com.yimoom.pplay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.base.MyMapper;
import com.yimoom.pplay.domain.sys.SysUser;
/**
 * 这个是借用了tk.mapper的通用方法
 * @author PC
 *
 */
@Mapper
public interface UserMapper extends MyMapper<SysUser>{}
