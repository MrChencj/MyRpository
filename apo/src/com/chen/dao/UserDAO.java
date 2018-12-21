package com.chen.dao;

import java.util.List;

 import com.chen.entity.User;

public interface UserDAO {
	/**
	 * 添加
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delUser(int id);

	/**
	 * 修改
	 * 
	 * @param User
	 * @return
	 */
	public int updUser(User user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> getAllUser();

	/**
	 * 根据ID查找用户
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
}
