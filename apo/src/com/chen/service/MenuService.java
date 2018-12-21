package com.chen.service;

import java.util.List;

import com.chen.entity.Menu;

public interface MenuService {
	/**
	 * 添加
	 * 
	 * @param menu
	 * @return
	 */
	public int addMenu(Menu menu);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delMenu(int id);

	/**
	 * 修改
	 * 
	 * @param Menu
	 * @return
	 */
	public int updMenu(Menu menu);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	public List<Menu> getAllMenu();

	/**
	 * 根据ID查找商品
	 * 
	 * @param id
	 * @return
	 */
	public Menu getMenuById(int id);

	/**
	 * 得到菜单总数
	 * @return
	 */
	public Long getCount();

	/**
	 * 
	 *分页
	 * @param pageNum 页数
	 * @param pageSize 页码数量大小
	 * @return
	 */
	public List<Menu> getPage(int pageNum, int pageSize);
	/**
	 * 按会员销量降序查询
	 * @return
	 */
	public List<Menu> getSortSumsl();
}
