package com.chen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chen.dao.MenuDAO;
import com.chen.entity.Menu;
import com.chen.util.MyDataSource;

public class MenuDAOImpl implements MenuDAO {
	private QueryRunner qr = new QueryRunner(MyDataSource.getDataSource());

	@Override
	public int addMenu(Menu menu) {
		int i = -1;
		try {
			i = qr.update(
					"insert into `menus`(`name`,`typeId`,`burden`,`brief`,`price`,`sums`,`pricel`,`sumsl`,`imgPath`) values(?,?,?,?,?,?,?,?,?)",
					menu.getName(), menu.getTypeId(), menu.getBurden(), menu.getBrief(), menu.getPrice(),
					menu.getSums(), menu.getPricel(), menu.getSumsl(), menu.getImgPath());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delMenu(int id) {
		int i = -1;
		try {
			i = qr.update("delete from `menus` where id = ?;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updMenu(Menu menu) {
		int i = -1;
		try {
			i = qr.update(
					"update `menus` set `name`=?,`typeId`=?,`burden`=?,`brief`=?,`price`=?,`sums`=?,`pricel`=?,`sumsl`=?,`imgPath`=? where id = ?;",
					menu.getName(), menu.getTypeId(), menu.getBurden(), menu.getBrief(), menu.getPrice(),
					menu.getSums(), menu.getPricel(), menu.getSumsl(), menu.getImgPath(),menu.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> list = null;
		try {
			list = qr.query("select * from `menus`", new BeanListHandler<Menu>(Menu.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Menu getMenuById(int id) {
		Menu menu = null;
		try {
			menu = qr.query("select * from `types` a, `menus` b where a.id=b.typeId and b.id= ?", new BeanHandler<Menu>(Menu.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public Long getCount() {
		Long sum = null;
		try {
			sum = (Long) qr.query("select count(*) from menus", new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	@Override
	public List<Menu> getPage(int pageNum, int pageSize) {
		List<Menu> list = null;
		try {
			list = qr.query("select * from `types` a, `menus` b where a.id=b.typeId limit ?,?", new BeanListHandler<Menu>(Menu.class),
					(pageNum - 1) * pageSize, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Menu> getSortSumsl() {
		List<Menu> list = null;
		try {
			list = qr.query("select * from `menus` ORDER BY `sumsl` desc", new BeanListHandler<Menu>(Menu.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
