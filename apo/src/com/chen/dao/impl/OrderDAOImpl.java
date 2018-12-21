package com.chen.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chen.dao.OrderDAO;
import com.chen.entity.Order;
import com.chen.util.MyDataSource;

public class OrderDAOImpl implements OrderDAO {
	private QueryRunner qr = new QueryRunner(MyDataSource.getDataSource());

	@Override
	public int addOrder(Order order) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = sdf.format(d);
		int i = -1;
		try {
			i = qr.update(
					"insert into `orders`(`userId`,`menuId`,`orderSum`,`price`,`count`,`orderTime`,`send`,`userName`,`userTel`,`userAddress`,`menuName`) values(?,?,?,?,?,?,?,?,?,?,?)",
					order.getUserId(), order.getMenuId(), order.getOrderSum(), order.getPrice(), order.getCount(),
					createTime, order.isSend(), order.getUserName(), order.getUserTel(), order.getUserAddress(),
					order.getMenuName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delOrder(int id) {
		int i = -1;
		try {
			i = qr.update("delete from `orders` where id = ?;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updOrder(Order order) {
		int i = -1;
		try {
			i = qr.update(
					"update `orders` set `userId`=?,`menuId`=?,`orderSum`=?,`price`=?,`count`=?,`orderTime`=?,`send`=?, `userName`=?,`userTel`=?,`userAddress`=?,`menuName`=? where id = ?;",
					order.getUserId(), order.getMenuId(), order.getOrderSum(), order.getPrice(), order.getCount(),
					order.getOrderTime(), order.isSend(), order.getUserName(), order.getUserTel(),
					order.getUserAddress(), order.getMenuName(), order.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public Order getOrderById(int id) {
		Order order = null;
		try {
			order = qr.query("select * from `orders` where id=?", new BeanHandler<Order>(Order.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> list = null;
		try {
			list = qr.query("select * from `orders`", new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getOrderByUserId(int id) {
		List<Order> list = null;
		try {
			list = qr.query("select * from `orders` where userId=?", new BeanListHandler<Order>(Order.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getOrdByParam(Map<String, String> mapParam) {
		List<Order> list = null;
		String sql = "select * from `orders`  where 1 = 1 ";
		Set<String> set = mapParam.keySet();
		List<String> listParam = new ArrayList<String>();
		for (String str : set) {
			if (str.equals("userName")) {
				sql += " and " + str + " like ?";
			} else if (str.equals("menuName")) {
				sql += " and " + str + " like ?";
			} else if (str.equals("orderTime")) {
				sql += " and " + str + " like ?";
			}
			listParam.add(mapParam.get(str));
		}
		try {
			if (listParam.size() == 1) {
				list = qr.query(sql, new BeanListHandler<Order>(Order.class), "%" + listParam.get(0) + "%");
			} else if (listParam.size() == 2) {
				list = qr.query(sql, new BeanListHandler<Order>(Order.class), "%" + listParam.get(0) + "%",
						listParam.get(1));
			} else if (listParam.size() == 3) {
				list = qr.query(sql, new BeanListHandler<Order>(Order.class), "%" + listParam.get(0) + "%",
						listParam.get(1), listParam.get(2));
			} else {
				list = qr.query(sql, new BeanListHandler<Order>(Order.class));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
