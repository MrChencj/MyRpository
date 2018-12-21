package com.chen.dao;
import java.util.List;

import com.chen.entity.Menu;


public interface MenuDAO {
	/**
	 * ����
	 * 
	 * @param menu
	 * @return
	 */
	public int addMenu(Menu menu);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public int delMenu(int id);

	/**
	 * �޸�
	 * 
	 * @param Menu
	 * @return
	 */
	public int updMenu(Menu menu);

	/**
	 * ��ѯ���в�Ʒ
	 * 
	 * @return
	 */
	public List<Menu> getAllMenu();

	/**
	 * ����ID������Ʒ
	 * 
	 * @param id
	 * @return
	 */
	public Menu getMenuById(int id);

	/**
	 * �õ��˵���Ʒ
	 * @return
	 */
	public Long getCount();

	/**
	 * 
	 *��ҳ
	 * @param pageNum ҳ��
	 * @param pageSize ҳ��������С
	 * @return
	 */
	public List<Menu> getPage(int pageNum, int pageSize);
	/**
	 * ����Ա���������ѯ
	 * @return
	 */
	public List<Menu> getSortSumsl();
}