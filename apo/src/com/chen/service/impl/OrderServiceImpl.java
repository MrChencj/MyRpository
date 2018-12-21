package com.chen.service.impl;

import java.util.List;
import java.util.Map;

import com.chen.dao.OrderDAO;
import com.chen.dao.impl.OrderDAOImpl;
import com.chen.entity.Order;
import com.chen.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDAO od = new OrderDAOImpl();
	@Override
	public int addOrder(Order order) {
		return od.addOrder(order);
	}

	@Override
	public int delOrder(int id) {
		return od.delOrder(id);
	}

	@Override
	public int updOrder(Order order) {
		return od.updOrder(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return od.getAllOrder();
	}

	@Override
	public List<Order> getOrderByUserId(int id) {
		return od.getOrderByUserId(id);
	}

	@Override
	public List<Order> getOrdByParam(Map<String, String> mapParam) {
		return od.getOrdByParam(mapParam);
	}

	@Override
	public Order getOrderById(int id) {
		return od.getOrderById(id);
	}

}
