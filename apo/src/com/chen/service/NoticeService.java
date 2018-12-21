package com.chen.service;

import java.util.List;

import com.chen.entity.Notice;

public interface NoticeService {
	/**
	 * ���
	 * 
	 * @param menu
	 * @return
	 */
	public int addNotice(Notice notice);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public int delNotice(int id);

	/**
	 * �޸�
	 * 
	 * @param Menu
	 * @return
	 */
	public int updNotice(Notice notice);

	/**
	 * ��ѯ����ͨ��
	 * 
	 * @return
	 */
	public List<Notice> getAllNotice();

	/**
	 * ����ID����ͨ��
	 * 
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(int id);
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
	public List<Notice> getPage(int pageNum, int pageSize);
}
