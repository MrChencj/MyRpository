package com.chen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.entity.Order;
import com.chen.entity.ShoppingCar;
import com.chen.entity.User;
import com.chen.service.OrderService;
import com.chen.service.impl.OrderServiceImpl;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType.equals("addOrder")) {
			addOrder(request, response);
		}else if(oprationType.equals("bgUpdOrder")) {
			bgUpdOrder(request, response);
		}else if(oprationType.equals("bgDelOrder")) {
			bgDelOrder(request, response);
		}
	}
	
	private void bgDelOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		os.delOrder(Integer.parseInt(id));
		request.getRequestDispatcher("SearchServlet?oprationType=bgQueryAllOrder").forward(request, response);

	}

	private void bgUpdOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Order o = os.getOrderById(Integer.parseInt(id));
		Order order = new Order();
		order.setId(o.getId());
		order.setUserId(o.getUserId());
		order.setMenuId(o.getMenuId());
		order.setOrderSum(o.getOrderSum());
		order.setPrice(o.getPrice());
		order.setCount(o.getCount());
		order.setOrderTime(o.getOrderTime());
		order.setSend(true);
		order.setUserName(o.getUserName());
		order.setUserTel(o.getUserTel());
		order.setUserAddress(o.getUserAddress());
		order.setMenuName(o.getMenuName());
		os.updOrder(order);
		request.getRequestDispatcher("SearchServlet?oprationType=bgQueryAllOrder").forward(request, response);
	}
	
	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<ShoppingCar> shopList = (List<ShoppingCar>) session.getAttribute("shoppingList");
		if (user == null) {
			response.sendRedirect("/apo/frontDesk/userLogin.jsp");
		} else {
			for (ShoppingCar sc : shopList) {
				Order order = new Order();
				order.setUserId(user.getId());
				order.setMenuId(sc.getId());
				order.setOrderSum(sc.getSum());
				order.setPrice(sc.getPrice());
				order.setCount(sc.getCount());
				order.setSend(false);
				order.setUserName(user.getName());
				order.setUserTel(user.getTel());
				order.setUserAddress(user.getAddress());
				order.setMenuName(sc.getName());
				os.addOrder(order);
			}
			session.removeAttribute("shoppingList");
			response.sendRedirect("frontDesk/successOrder.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
