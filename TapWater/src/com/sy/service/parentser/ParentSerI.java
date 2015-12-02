package com.sy.service.parentser;

import java.util.List;

/**
 * Service 的父类接口 可以实现该接口 
 * 实现该接口,就要以 T 类为主要的操作对象
 * @author BarryLiu
 * @param <T> 针对哪个 entity 的Service 
 */
public interface ParentSerI<T>{

	/**
	 * 查询全部
	 * @return
	 */
	List<T> getAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(String id);

	/**
	 * 插入一条记录
	 * @param entity
	 * @return
	 */
	int insert(T entity);

	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int delete(String id);
}
