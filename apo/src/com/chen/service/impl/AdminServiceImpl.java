package com.chen.service.impl;

import java.util.List;

import com.chen.dao.AdminDAO;
import com.chen.dao.impl.AdminDAOImpl;
import com.chen.entity.Admin;
import com.chen.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDAO ad = new AdminDAOImpl();
	@Override
	public int addAdmin(Admin admin) {
		return ad.addAdmin(admin);
	}

	@Override
	public int delAdmin(int id) {
		return ad.delAdmin(id);
	}

	@Override
	public int updAdmin(Admin admin) {
		return ad.updAdmin(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return ad.getAllAdmin();
	}

	@Override
	public Admin getAdminById(int id) {
		return ad.getAdminById(id);
	}

}
