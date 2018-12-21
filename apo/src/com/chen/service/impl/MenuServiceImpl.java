package com.chen.service.impl;

import java.util.List;

import com.chen.dao.MenuDAO;
import com.chen.dao.impl.MenuDAOImpl;
import com.chen.entity.Menu;
import com.chen.service.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDAO md = new MenuDAOImpl();
	@Override
	public int addMenu(Menu menu) {
		return md.addMenu(menu);
	}

	@Override
	public int delMenu(int id) {
		return md.delMenu(id);
	}

	@Override
	public int updMenu(Menu menu) {
		return md.updMenu(menu);
	}

	@Override
	public List<Menu> getAllMenu() {
		return md.getAllMenu();
	}

	@Override
	public Menu getMenuById(int id) {
		return md.getMenuById(id);
	}

	@Override
	public Long getCount() {
		return md.getCount();
	}

	@Override
	public List<Menu> getPage(int pageNum, int pageSize) {
		return md.getPage(pageNum, pageSize);
	}

	@Override
	public List<Menu> getSortSumsl() {
		return md.getSortSumsl();
	}

}
