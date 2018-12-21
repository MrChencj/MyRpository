package com.chen.dao;

import java.util.List;
import java.util.Map;

import com.chen.entity.Order;
public interface OrderDAO {
	/**
	 * 添加
	 * 
	 * @param Order
	 * @return
	 */
	public int addOrder(Order order);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delOrder(int id);

	/**
	 * 修改
	 * 
	 * @param Order
	 * @return
	 */
	public int updOrder(Order order);

	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	public List<Order> getAllOrder();

	/**
	 * 根据ID查找订单
	 * 
	 * @param id
	 * @return
	 */
	public  List<Order> getOrderByUserId(int id);

	/**
	 * 根据条件查询
	 * 
	 * @return
	 */
	public List<Order> getOrdByParam(Map<String, String> mapParam);
	/**
	 * 根据订单id 查询订单
	 * @param id
	 * @return
	 */
	public Order getOrderById(int id);
}
