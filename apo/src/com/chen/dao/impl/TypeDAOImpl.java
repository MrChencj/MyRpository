package com.chen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chen.dao.TypeDAO;
import com.chen.entity.Type;
import com.chen.util.MyDataSource;

public class TypeDAOImpl implements TypeDAO {
	private QueryRunner qr = new QueryRunner(MyDataSource.getDataSource());

	@Override
	public int addType(Type type) {
		int i = -1;
		try {
			i = qr.update("insert into `types`(typename) values(?)", type.getTypename());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delType(int id) {
		int i = -1;
		try {
			i = qr.update("delete from `types` where id = ?;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updType(Type type) {
		int i = -1;
		try {
			i = qr.update("update `types` set `typename`=? where id = ?;",type.getTypename(),type.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Type> getAllType() {
		List<Type> list = null;
		try {
			list = qr.query("select * from `types`", new BeanListHandler<Type>(Type.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Type getTypeById(int id) {
		Type type = null;
		try {
			type = qr.query("select * from  `types` where id = ?", new BeanHandler<Type>(Type.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}
	@Override
	public Long getCount() {
		Long sum = null;
		try {
			sum = (Long) qr.query("select count(*) from types", new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	@Override
	public List<Type> getPage(int pageNum, int pageSize) {
		List<Type> list = null;
		try {
			list = qr.query("select * from `types` limit ?,?", new BeanListHandler<Type>(Type.class),
					(pageNum - 1) * pageSize, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
