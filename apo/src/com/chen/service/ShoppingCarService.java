package com.chen.service;
import java.util.List;

import com.chen.entity.ShoppingCar;

public interface ShoppingCarService {

	public List<ShoppingCar> add(List<ShoppingCar> list, int id);

	public List<ShoppingCar> remove(List<ShoppingCar> list, int id);

	public List<ShoppingCar> increment(List<ShoppingCar> list, int id);

	public List<ShoppingCar> reduce(List<ShoppingCar> list, int id);

}
