package com.chen.dao;

import java.util.List;

import com.chen.entity.Notice;

public interface NoticeDAO {
	/**
	 * 添加
	 * 
	 * @param menu
	 * @return
	 */
	public int addNotice(Notice notice);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delNotice(int id);

	/**
	 * 修改
	 * 
	 * @param Menu
	 * @return
	 */
	public int updNotice(Notice notice);

	/**
	 * 查询所有通告
	 * 
	 * @return
	 */
	public List<Notice> getAllNotice();

	/**
	 * 根据ID查找通告
	 * 
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(int id);
	/**
	 * 得到总数
	 * @return
	 */
	public Long getCount() ;
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Notice> getPage(int pageNum, int pageSize);

}
