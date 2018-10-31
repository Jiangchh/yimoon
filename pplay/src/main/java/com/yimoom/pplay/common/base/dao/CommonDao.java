package com.yimoom.pplay.common.base.dao;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;
@Repository
public interface CommonDao<T> extends Mapper<T>{

}
