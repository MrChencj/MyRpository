package com.chen.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.entity.ShoppingCar;
import com.chen.service.ShoppingCarService;
import com.chen.service.impl.ShoppingCarServiceImpl;


@WebServlet("/ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oprationType = request.getParameter("oprationType");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		List<ShoppingCar> list = null;

		ShoppingCarService shoppingCarService = new ShoppingCarServiceImpl();
		if (oprationType.equals("add")) {
			if (session.getAttribute("shoppingList") != null && session.getAttribute("shoppingList") != "") {
				list = (List<ShoppingCar>) session.getAttribute("shoppingList");
				boolean b = false;
				for (ShoppingCar sc : list) {
					if (sc.getId() == Integer.parseInt(id)) {
						b = true;
						break;
					}
				}
				if (b) {
					list = (List<ShoppingCar>) session.getAttribute("shoppingList");
					list = shoppingCarService.increment(list, Integer.parseInt(id));
				} else {
					list = shoppingCarService.add(list, Integer.parseInt(id));
				}
			} else {
				list = new ArrayList<ShoppingCar>();
				list = shoppingCarService.add(list, Integer.parseInt(id));
			}
		} else if (oprationType.equals("remove")) {
			list = (List<ShoppingCar>) session.getAttribute("shoppingList");
			list = shoppingCarService.remove(list, Integer.parseInt(id));
		} else if (oprationType.equals("increment")) {
			list = (List<ShoppingCar>) session.getAttribute("shoppingList");
			list = shoppingCarService.increment(list, Integer.parseInt(id));
		} else if (oprationType.equals("reduce")) {
			list = (List<ShoppingCar>) session.getAttribute("shoppingList");
			list = shoppingCarService.reduce(list, Integer.parseInt(id));
		}
		session.setAttribute("shoppingList", list);
		int sum = 0;
		float priceCountSum = 0;
		for (ShoppingCar sc : list) {
			sum += sc.getSum();
			priceCountSum += sc.getPrice() * sc.getSum();
		}
		session.setAttribute("sum", sum);
		session.setAttribute("priceCountSum", priceCountSum);
		request.getRequestDispatcher("frontDesk/shoppingCar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
