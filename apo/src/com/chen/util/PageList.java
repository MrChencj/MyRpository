package com.chen.util;
import java.util.ArrayList;
import java.util.List;

public class PageList {
	private List list;
	private int pageSize;
	private int pageCount;

	public int getPageCount() {
		return pageCount;
	}

	public PageList(int pageSize) {
		super();
		this.pageSize = pageSize;
	}

	public PageList(List list, int pageSize) {
		super();
		this.list = list;
		this.pageSize = pageSize;
		this.pageCount = list.size() / pageSize + ((list.size() % pageSize == 0) ? 0 : 1);
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getListByPage(int pageNum) {
		List pages = new ArrayList();

		int pageMax;
		if (pageNum != pageCount) {
			pageMax = pageNum * pageSize;
		} else {
			pageMax = list.size();
		}
		for (int i = (pageNum - 1) * pageSize; i < pageMax; i++) {
			pages.add(list.get(i));
		}
		return pages;
	}

}
