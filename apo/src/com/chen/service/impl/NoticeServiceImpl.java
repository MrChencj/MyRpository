package com.chen.service.impl;

import java.util.List;

import com.chen.dao.NoticeDAO;
import com.chen.dao.impl.NoticeDAOImpl;
import com.chen.entity.Notice;
import com.chen.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO nd = new NoticeDAOImpl();
	@Override
	public int addNotice(Notice notice) {
		return nd.addNotice(notice);
	}

	@Override
	public int delNotice(int id) {
		return nd.delNotice(id);
	}

	@Override
	public int updNotice(Notice notice) {
		return nd.updNotice(notice);
	}

	@Override
	public List<Notice> getAllNotice() {
		return nd.getAllNotice();
	}

	@Override
	public Notice getNoticeById(int id) {
		return nd.getNoticeById(id);
	}

	@Override
	public Long getCount() {
		return nd.getCount();
	}

	@Override
	public List<Notice> getPage(int pageNum, int pageSize) {
		return nd.getPage(pageNum, pageSize);
	}

}
