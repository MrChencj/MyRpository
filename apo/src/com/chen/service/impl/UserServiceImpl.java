package com.chen.service.impl;

import java.util.List;

import com.chen.dao.UserDAO;
import com.chen.dao.impl.UserDAOImpl;
import com.chen.entity.User;
import com.chen.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO ud = new UserDAOImpl();
	@Override
	public int addUser(User user) {
		return ud.addUser(user);
	}

	@Override
	public int delUser(int id) {
		return ud.delUser(id);
	}

	@Override
	public int updUser(User user) {
		return ud.updUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return ud.getAllUser();
	}

	@Override
	public User getUserById(int id) {
		return ud.getUserById(id);
	}

}
