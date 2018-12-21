package com.chen.service.impl;

import java.util.List;

import com.chen.dao.TypeDAO;
import com.chen.dao.impl.TypeDAOImpl;
import com.chen.entity.Type;
import com.chen.service.TypeService;

public class TypeServiceImpl implements TypeService {
	private TypeDAO td = new TypeDAOImpl();
	@Override
	public int addType(Type type) {
		return td.addType(type);
	}

	@Override
	public int delType(int id) {
		return td.delType(id);
	}

	@Override
	public int updType(Type type) {
		return td.updType(type);
	}

	@Override
	public List<Type> getAllType() {
		return td.getAllType();
	}

	@Override
	public Type getTypeById(int id) {
		return td.getTypeById(id);
	}

	@Override
	public List<Type> getPage(int pageNum, int pageSize) {
		return td.getPage(pageNum, pageSize);
	}

	@Override
	public Long getCount() {
		return td.getCount();
	}

}
