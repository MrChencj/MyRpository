package com.chen.dao;

import java.util.List;

import com.chen.entity.Type;

public interface TypeDAO {
	/**
	 * 添加
	 * 
	 * @param Type
	 * @return
	 */
	public int addType(Type type);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delType(int id);

	/**
	 * 修改
	 * 
	 * @param Type
	 * @return
	 */
	public int updType(Type type);

	/**
	 * 查询所有菜品类型
	 * 
	 * @return
	 */
	public List<Type> getAllType();

	/**
	 * 根据ID查找菜品类型
	 * 
	 * @param id
	 * @return
	 */
	public Type getTypeById(int id);
	/**
	 * 得到总数
	 * @return
	 */
	public Long getCount() ;
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Type> getPage(int pageNum, int pageSize);
}
