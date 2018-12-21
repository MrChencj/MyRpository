package com.chen.service;

import java.util.List;

import com.chen.entity.User;

public interface UserService {
	/**
	 * ���
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public int delUser(int id);

	/**
	 * �޸�
	 * 
	 * @param User
	 * @return
	 */
	public int updUser(User user);

	/**
	 * ��ѯ�����û�
	 * 
	 * @return
	 */
	public List<User> getAllUser();

	/**
	 * ����ID�����û�
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
}
