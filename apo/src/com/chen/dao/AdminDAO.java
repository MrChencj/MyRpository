package com.chen.dao;

import java.util.List;

import com.chen.entity.Admin;


public interface AdminDAO {
	/**
	 * 添加
	 * 
	 * @param Admin
	 * @return
	 */
	public int addAdmin(Admin admin);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delAdmin(int id);

	/**
	 * 修改
	 * 
	 * @param Admin
	 * @return
	 */
	public int updAdmin(Admin admin);

	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	public List<Admin> getAllAdmin();

	/**
	 * 根据ID查找管理员
	 * 
	 * @param id
	 * @return
	 */
	public Admin getAdminById(int id);

}
