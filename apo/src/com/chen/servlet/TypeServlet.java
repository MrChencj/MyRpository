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

import org.apache.commons.beanutils.BeanUtils;

import com.chen.entity.Type;
import com.chen.service.TypeService;
import com.chen.service.impl.TypeServiceImpl;

@WebServlet("/TypeServlet")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypeService ts = new TypeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType.equals("bgAddType")) {
			bgAddType(request, response);
			request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);
		}else if(oprationType.equals("bgAllType")) {
			bgAllType(request, response);
		}else if(oprationType.equals("bgDelType")) {
			bgDelType(request, response);
			bgAllType(request, response);
		}else if(oprationType.equals("bgUpdBeforeType")) {
			bgUpdBeforeType(request, response);
		}else if(oprationType.equals("bgUpdType")) {
			bgUpdMenu(request, response);
			request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);
		}
		
		
	}
	private void bgUpdMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Type type = new Type();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(type, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ts.updType(type);
	}
	private void bgUpdBeforeType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Type type = ts.getTypeById(Integer.parseInt(id));
		request.setAttribute("type", type);
		request.getRequestDispatcher("bgDesk/bgaddType.jsp").forward(request, response);
		
	}

	private void bgDelType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ts.delType(Integer.parseInt(id));
	}

	
	private void bgAllType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 6;
		int num;
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null && pageNum != "") {
			num = Integer.parseInt(pageNum);
		} else {
			num = 1;
		}
		Long count = ts.getCount();
		Long pageCount = count / pageSize + ((count % pageSize == 0) ? 0 : 1);
		List<Type> list = new ArrayList<Type>();
		list = ts.getPage(num, pageSize);

		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", num);
		request.setAttribute("typeList", list);
		request.getRequestDispatcher("bgDesk/bgallType.jsp").forward(request, response);
	}
	private void bgAddType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Type type = new Type();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(type, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ts.addType(type);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
