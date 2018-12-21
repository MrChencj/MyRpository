package com.chen.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chen.dao.NoticeDAO;
import com.chen.entity.Notice;
import com.chen.util.MyDataSource;

public class NoticeDAOImpl implements NoticeDAO {
	private QueryRunner qr = new QueryRunner(MyDataSource.getDataSource());

	@Override
	public int addNotice(Notice notice) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = sdf.format(d);
		int i = -1;
		try {
			i = qr.update("insert into `notice`(`name`,`content`,`times`) values(?,?,?)", notice.getName(),
					notice.getContent(), createTime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delNotice(int id) {
		int i = -1;
		try {
			i = qr.update("delete from `notice` where id = ?;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updNotice(Notice notice) {
		int i = -1;
		try {
			i = qr.update("update `notice` set `name`=?,`content`=?,`times`=? where id = ?;", notice.getName(),
					notice.getContent(), notice.getTimes(), notice.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Notice> getAllNotice() {
		List<Notice> list = null;
		try {
			list = qr.query("select * from `notice`", new BeanListHandler<Notice>(Notice.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Notice getNoticeById(int id) {
		Notice notice = null;
		try {
			notice = qr.query("select * from  `notice` where id = ?", new BeanHandler<Notice>(Notice.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
	@Override
	public Long getCount() {
		Long sum = null;
		try {
			sum = (Long) qr.query("select count(*) from notice", new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	@Override
	public List<Notice> getPage(int pageNum, int pageSize) {
		List<Notice> list = null;
		try {
			list = qr.query("select * from `notice` limit ?,?", new BeanListHandler<Notice>(Notice.class),
					(pageNum - 1) * pageSize, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
