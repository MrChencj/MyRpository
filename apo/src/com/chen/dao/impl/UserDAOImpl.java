package com.chen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chen.dao.UserDAO;
import com.chen.entity.User;
import com.chen.util.MyDataSource;

public class UserDAOImpl implements UserDAO {
	private QueryRunner qr = new QueryRunner(MyDataSource.getDataSource());

	@Override
	public int addUser(User user) {
		int i = -1;
		try {
			i = qr.update(
					"insert `users`(`name`,`pwd`,`realName`,`sex`,`birthday`,`card`,`address`,`tel`,`email`,`code`) values(?,?,?,?,?,?,?,?,?,?)",
					user.getName(), user.getPwd(), user.getRealName(), user.isSex(), user.getBirthday(),
					user.getCard(), user.getAddress(), user.getTel(), user.getEmail(), user.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delUser(int id) {
		int i = -1;
		try {
			i = qr.update("delete from `users` where id = ?;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updUser(User user) {
		int i = -1;
		try {
			i = qr.update(
					"update `users` set `name`=?,`pwd`=?,`realName`=?,`sex`=?,`birthday`=?,`card`=?,`address`=?,`tel`=?,`email`=?,`code`=? where id = ?;",
					user.getName(), user.getPwd(), user.getRealName(), user.isSex(), user.getBirthday(),
					user.getCard(), user.getAddress(), user.getTel(), user.getEmail(), user.getCode(),user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = null;
		try {
			list = qr.query("select * from `users`", new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		try {
			user = qr.query("select * from  `users` where id = ?", new BeanHandler<User>(User.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
