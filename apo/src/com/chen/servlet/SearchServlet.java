package com.chen.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.entity.Menu;
import com.chen.entity.Order;
import com.chen.service.MenuService;
import com.chen.service.OrderService;
import com.chen.service.impl.MenuServiceImpl;
import com.chen.service.impl.OrderServiceImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType != null && oprationType.equals("query")) {
			query(request, response);
		} else if (oprationType.equals("getOrderByUserId")) {
			getOrderByUserId(request, response);
		} else if (oprationType.equals("getOrderByUserIdNo")) {
			getOrderByUserIdNo(request, response);
		} else if (oprationType.equals("getOrderByUserIdYes")) {
			getOrderByUserIdYes(request, response);
		} else if (oprationType.equals("bgQuery")) {
			bgQuery(request, response);
			request.getRequestDispatcher("bgDesk/bgSearchOrder.jsp").forward(request, response);
		} else if (oprationType.equals("bgQueryAllOrder")) {
			bgQuery(request, response);
			request.getRequestDispatcher("bgDesk/bgQueryAllOrder.jsp").forward(request, response);
		} else if (oprationType.equals("bgQueryOrderToDay")) {
			bgQueryOrderToDay(request, response);
		}
	}

	private void bgQueryOrderToDay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String orderTime = sdf.format(date);

		Map<String, String> map = new HashMap<String, String>();
		if (orderTime != null && orderTime != "") {
			map.put("orderTime", orderTime);
		}
		List<Order> list = os.getOrdByParam(map);

		MenuService ms = new MenuServiceImpl();
		List<Menu> mlist = new ArrayList<Menu>();
		mlist = ms.getAllMenu();
		// num是单种菜品的销售数量,count是行合计，total 总计
		int num=0;
		float total=0;
		float count = 0;
		for (Menu m : mlist) {
			for (Order o : list) {
				if(m.getName().equals(o.getMenuName())) {
					num +=o.getOrderSum();
				}
			}
			count = num*m.getPricel();
		}
		total +=count; 
		
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("bgDesk/bgQueryOrderToDay.jsp").forward(request, response);

	}

	private void bgQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String menuName = request.getParameter("menuName");
		String orderTime = request.getParameter("orderTime");

		Map<String, String> map = new HashMap<String, String>();
		if (userName != null && userName != "") {
			map.put("userName", userName);
		}
		if (menuName != null && menuName != "") {
			map.put("menuName", menuName);
		}
		if (orderTime != null && orderTime != "") {
			map.put("orderTime", orderTime);
		}
		List<Order> list = os.getOrdByParam(map);
		request.setAttribute("orderList", list);

	}

	private void getOrderByUserIdYes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("id");
		if (userId != null && userId != "") {
			List<Order> list = new ArrayList<Order>();
			list = os.getOrderByUserId(Integer.parseInt(userId));
			List<Order> newlist = new ArrayList<Order>();
			for (Order o : list) {
				if (o.isSend()) {
					newlist.add(o);
				}
			}

			request.setAttribute("orderList", newlist);
			request.getRequestDispatcher("frontDesk/order.jsp").forward(request, response);
		} else {
			response.sendRedirect("frontDesk/errorOrder.jsp");
		}
	}

	private void getOrderByUserIdNo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("id");
		if (userId != null && userId != "") {
			List<Order> list = new ArrayList<Order>();
			list = os.getOrderByUserId(Integer.parseInt(userId));
			List<Order> newlist = new ArrayList<Order>();
			for (Order o : list) {
				if (!o.isSend()) {
					newlist.add(o);
				}
			}

			request.setAttribute("orderList", newlist);
			request.getRequestDispatcher("frontDesk/order.jsp").forward(request, response);
		} else {
			response.sendRedirect("frontDesk/errorOrder.jsp");
		}
	}

	private void getOrderByUserId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("id");
		if (userId != null && userId != "") {
			List<Order> list = new ArrayList<Order>();
			list = os.getOrderByUserId(Integer.parseInt(userId));
			request.setAttribute("orderList", list);
			request.getRequestDispatcher("frontDesk/order.jsp").forward(request, response);
		} else {
			response.sendRedirect("frontDesk/errorOrder.jsp");
		}

	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String menuName = request.getParameter("menuName");
		String orderTime = request.getParameter("orderTime");

		Map<String, String> map = new HashMap<String, String>();
		if (userName != null && userName != "") {
			map.put("userName", userName);
		}
		if (menuName != null && menuName != "") {
			map.put("menuName", menuName);
		}
		if (orderTime != null && orderTime != "") {
			map.put("orderTime", orderTime);
		}
		List<Order> list = os.getOrdByParam(map);
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("frontDesk/order.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
