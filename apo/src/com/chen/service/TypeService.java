package com.chen.service;

import java.util.List;

import com.chen.entity.Type;

public interface TypeService {
	/**
	 * ���
	 * 
	 * @param Type
	 * @return
	 */
	public int addType(Type type);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public int delType(int id);

	/**
	 * �޸�
	 * 
	 * @param Type
	 * @return
	 */
	public int updType(Type type);

	/**
	 * ��ѯ���в�Ʒ����
	 * 
	 * @return
	 */
	public List<Type> getAllType();

	/**
	 * ����ID���Ҳ�Ʒ����
	 * 
	 * @param id
	 * @return
	 */
	public Type getTypeById(int id);
	/**
	 * �õ�����
	 * @return
	 */
	public Long getCount() ;
	/**
	 * ��ҳ��ѯ
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Type> getPage(int pageNum, int pageSize);
}

