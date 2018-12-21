package com.chen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chen.dao.AdminDAO;
import com.chen.entity.Admin;
import com.chen.util.MyDataSource;

public class AdminDAOImpl implements AdminDAO {
	private QueryRunner qr = new QueryRunner(MyDataSource.getDataSource());
	@Override
	public int addAdmin(Admin admin) {
		int i = -1;
		try {
			i = qr.update("insert into `admin`(`name`,`password`) values(?,?)",admin.getName(),admin.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delAdmin(int id) {
		int i = -1;
		try {
			i = qr.update("delete from `admin` where id = ?;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updAdmin(Admin admin) {
		int i = -1;
		try {
			i = qr.update("update `admin` set `name`=?,`password`=? where id = ?;", admin.getName(),admin.getPassword(),admin.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> list = null;
		try {
			list = qr.query("select * from `admin`", new BeanListHandler<Admin>(Admin.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin getAdminById(int id) {
		Admin admin = null;
		try {
			admin = qr.query("select * from  `admin` where id = ?", new BeanHandler<Admin>(Admin.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

}
