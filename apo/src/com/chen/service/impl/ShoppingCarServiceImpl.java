package com.chen.service.impl;

import java.util.List;

import com.chen.entity.Menu;
import com.chen.entity.ShoppingCar;
import com.chen.service.MenuService;
import com.chen.service.ShoppingCarService;


public class ShoppingCarServiceImpl implements ShoppingCarService {

	private MenuService menuService = new MenuServiceImpl();

	@Override
	public List<ShoppingCar> add(List<ShoppingCar> list, int id) {
		Menu menu = new Menu();
		menu = menuService.getMenuById(id);
		ShoppingCar sc = new ShoppingCar();
		sc.setId(menu.getId());
		sc.setName(menu.getName());
		sc.setPrice(menu.getPricel());
		list.add(sc);
		return list;
	}

	@Override
	public List<ShoppingCar> remove(List<ShoppingCar> list, int id) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		if (index > -1) {
			list.remove(index);
		}
		return list;
	}

	@Override
	public List<ShoppingCar> increment(List<ShoppingCar> list, int id) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		if (index > -1) {
			ShoppingCar sc = list.get(index);
			sc.setSum(sc.getSum() + 1);
			list.set(index, sc);
		}
		return list;
	}

	@Override
	public List<ShoppingCar> reduce(List<ShoppingCar> list, int id) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		if (index > -1) {
			ShoppingCar sc = list.get(index);
			sc.setSum(sc.getSum() - 1);
			if (sc.getSum() == 0) {
				list.remove(index);
			} else {
				list.set(index, sc);
			}
		}
		return list;
	}

}
