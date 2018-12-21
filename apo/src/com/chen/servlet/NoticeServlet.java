package com.chen.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.chen.entity.Notice;
import com.chen.service.NoticeService;
import com.chen.service.impl.NoticeServiceImpl;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoticeService ns = new NoticeServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType.equals("getAllNotice")) {
			getAllNotice(request, response);
		}else if(oprationType.equals("getNoticeById")) {
			getNoticeById(request, response);
		}else if(oprationType.equals("bgAddNotice")) {
			bgAddNotice(request, response);
			request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);
		}else if(oprationType.equals("bgAllNotice")) {
			bgAllNotice(request, response);
		}else if(oprationType.equals("bgDelNotice")) {
			bgDelNotice(request, response);
			bgAllNotice(request, response);
		}else if(oprationType.equals("bgUpdBeforeNotice")) {
			bgUpdBeforeNotice(request, response);
		}else if(oprationType.equals("bgUpdNotice")) {
			bgUpdNotice(request, response);
			request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);

		}
	}
	private void bgUpdNotice(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Notice notice = new Notice();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(notice, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ns.updNotice(notice);
	}
	private void bgUpdBeforeNotice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("11");
		Notice notice = ns.getNoticeById(Integer.parseInt(id));
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("bgDesk/bgaddNotice.jsp").forward(request, response);
		
	}
	
	private void bgDelNotice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ns.delNotice(Integer.parseInt(id));
	}

	
	private void bgAllNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 6;
		int num;
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null && pageNum != "") {
			num = Integer.parseInt(pageNum);
		} else {
			num = 1;
		}
		Long count = ns.getCount();
		Long pageCount = count / pageSize + ((count % pageSize == 0) ? 0 : 1);
		List<Notice> list = new ArrayList<Notice>();
		list = ns.getPage(num, pageSize);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", num);
		request.setAttribute("noticeList", list);
		request.getRequestDispatcher("bgDesk/bgallNotice.jsp").forward(request, response);
	}
	
	private void bgAddNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(notice, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ns.addNotice(notice);
	}

	private void getNoticeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Notice notice = new Notice();
		notice = ns.getNoticeById(Integer.parseInt(id));
		
		request.setAttribute("notice", notice);

		request.getRequestDispatcher("frontDesk/getNoticeById.jsp").forward(request, response);
	}
	
	//前台标题窗口的内容，页面只显示两个标题，点击更多全部显示
	private void getAllNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Notice> list = new ArrayList<Notice>();
		list = ns.getAllNotice();
		HttpSession session = request.getSession();
		session.setAttribute("noticeList", list);
		request.getRequestDispatcher("frontDesk/getAllNotice.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
