package com.yimoom.pplay.common.base.service;

import java.util.List;

import com.yimoom.pplay.common.base.dao.GenericDao;
import com.yimoom.pplay.common.base.entity.Page;
import com.yimoom.pplay.common.base.entity.QueryBase;

/**
 * 通用Service
 * */
public abstract class GenericService<T, Q extends QueryBase> {
	protected abstract GenericDao<T, Q> getDao();
	
	/**
	 * 根据主键值获取对象
	 * @param entity
	 * */
	public T get(T entity){
		return getDao().get(entity);
	}
 
	/**
	 * 获取全部实体
	 * */
    public List<T> loadAll(){
    	return getDao().loadAll();
    }
 
	/**
	 * 查找是否存在
	 * @param queryModel 查询条件
	 * */
	public boolean isExist(Q queryModel){
		return getDao().isExist(queryModel)>0;
	}
 
	/** 
	 * 保存
	 * @param entity 保存对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean save(T entity) throws Exception{
		return getDao().save(entity)>0;
	}
 
	/** 
	 * 更新 
	 * @param entity 修改对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean update(T entity) throws Exception{
		return getDao().update(entity)>0;
	}
 
	/**
	 * 删除 
	 * @param entity 删除对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean delete(T entity) throws Exception{
		return getDao().delete(entity)>0;
	}
 
	/**
	 * 分页查询
	 * @param queryModel 查询条件
	 *  */
	public Page findByPage(Q queryModel){
		List<T> list =  getDao().findByPage(queryModel);
		int count = getDao().count(queryModel);
		return new Page(list, count);
	}
	
	/**
	 * 统计
	 * @param queryModel 查询条件
	 * @return int
	 * */
	public int count(Q queryModel){
		return getDao().count(queryModel);
	}
 
	/**
	 * 查询
	 * @param queryModel 查询条件
	 *  */
	public List<T> query(Q queryModel){
		return getDao().query(queryModel);
	}
	/**
	 * 根据id数组删除记录
	 * @param ids 数组
	 * @return boolean
	 * */
	public boolean deleteByIds(String[] ids) throws Exception{
		return getDao().deleteByIds(ids)>0;
	}
 
	/**
	 * 功能描述：批量删除数据
	 * @param entityList
	 * @return
	 */
	public boolean removeBath(List<T> entityList) throws Exception{
		for(T t:entityList){
			if(!delete(t)){
				return false;
			}
		}
       return true;
	}
}

