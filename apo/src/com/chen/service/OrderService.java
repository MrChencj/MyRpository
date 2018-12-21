package com.chen.service;

import java.util.List;
import java.util.Map;

import com.chen.entity.Order;

public interface OrderService {
	/**
	 * ���
	 * 
	 * @param Order
	 * @return
	 */
	public int addOrder(Order order);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public int delOrder(int id);

	/**
	 * �޸�
	 * 
	 * @param Order
	 * @return
	 */
	public int updOrder(Order order);

	/**
	 * ��ѯ���ж���
	 * 
	 * @return
	 */
	public List<Order> getAllOrder();

	/**
	 * ����ID���Ҷ���
	 * 
	 * @param id
	 * @return
	 */
	public List<Order> getOrderByUserId(int id);

	/**
	 * ����������ѯ
	 * 
	 * @return
	 */
	public List<Order> getOrdByParam(Map<String, String> mapParam);
	/**
	 * ���ݶ���id ��ѯ����
	 * @param id
	 * @return
	 */
	public Order getOrderById(int id);
}
