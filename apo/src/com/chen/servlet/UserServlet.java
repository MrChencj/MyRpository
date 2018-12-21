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

import com.chen.entity.User;
import com.chen.service.UserService;
import com.chen.service.impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType.equals("login")) {
			login(request, response);
		}else if(oprationType.equals("logout")) {
			logout(request, response);
		}else if(oprationType.equals("addUser")) {
			addUser(request, response);
		}else if(oprationType.equals("userCenter")) {
			userCenter(request, response);
		}else if(oprationType.equals("updUser")) {
			updUser(request, response);
		}
	}
	private void updUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User newUser = new User();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(newUser, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		us.updUser(newUser);
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.setAttribute("user", newUser);
		response.sendRedirect("frontDesk/updSuccess.html");
	}
	
	private void userCenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id==null||id=="") {
			response.sendRedirect("frontDesk/userLogin.jsp");
		}else{
			User user = new User();
			user = us.getUserById(Integer.parseInt(id));
			request.setAttribute("user", user);
			request.getRequestDispatcher("frontDesk/userRegister.jsp").forward(request, response);
		}

	}
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = new User();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		us.addUser(user);
		login(request, response);;
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.sendRedirect("frontDesk/userLogin.jsp");

	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		List<User> list =  new ArrayList<User>();
		list = us.getAllUser();
		boolean flag=false;
		for(User user : list) {
			if((user.getName()).equals(name)&&(user.getPwd()).equals(pwd)) {
				flag = true;
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("MenuServlet?oprationType=getAllMenu").forward(request, response);
				break;
			}
		}
		if(!flag) {
			response.sendRedirect("frontDesk/userLogin.jsp");

		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
