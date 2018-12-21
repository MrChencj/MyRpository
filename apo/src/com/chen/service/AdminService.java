package com.chen.service;

import java.util.List;

import com.chen.entity.Admin;

public interface AdminService {
	/**
	 * ���
	 * 
	 * @param Admin
	 * @return
	 */
	public int addAdmin(Admin admin);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public int delAdmin(int id);

	/**
	 * �޸�
	 * 
	 * @param Admin
	 * @return
	 */
	public int updAdmin(Admin admin);

	/**
	 * ��ѯ���й���Ա
	 * 
	 * @return
	 */
	public List<Admin> getAllAdmin();

	/**
	 * ����ID���ҹ���Ա
	 * 
	 * @param id
	 * @return
	 */
	public Admin getAdminById(int id);
}
