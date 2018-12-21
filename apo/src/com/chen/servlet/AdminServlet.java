package com.chen.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.chen.entity.Admin;
import com.chen.service.AdminService;
import com.chen.service.impl.AdminServiceImpl;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType.equals("login")) {
			login(request, response);
		} else if (oprationType.equals("logOut")) {
			logOut(request, response);
		} else if (oprationType.equals("updBeforeAdmin")) {
			updBeforeAdmin(request, response);
		} else if (oprationType.equals("updAdmin")) {
			updAdmin(request, response);
		}
	}


	
	private void updAdmin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Admin admin = new Admin();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(admin, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		as.updAdmin(admin);
		response.sendRedirect("bgindex.jsp");
	}

	private void updBeforeAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Admin a = as.getAdminById(Integer.parseInt(id));
		
		request.setAttribute("admin", a);
		request.getRequestDispatcher("bgDesk/updAdmin.jsp").forward(request, response);

	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		response.sendRedirect("bgindex.jsp");

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String check = request.getParameter("check");
		List<Admin> list = new ArrayList<Admin>();
		list = as.getAllAdmin();
		boolean flag = false;
		for (Admin admin : list) {
			if ((admin.getName()).equals(name) && (admin.getPassword()).equals(password)) {
				flag = true;
				if (check != null) {
					if (check.equals("check")) {
						Cookie cooAccount = new Cookie("account", name);
						Cookie cooPassword = new Cookie("password", password);

						cooAccount.setMaxAge(60 * 60 * 24 * 5);
						cooPassword.setMaxAge(60 * 60 * 24 * 5);

						response.addCookie(cooAccount);
						response.addCookie(cooPassword);
					}
				}
				Admin a = new Admin();
				a.setId(admin.getId());
				a.setName(name);
				a.setPassword(password);
				HttpSession session = request.getSession();
				session.setAttribute("admin", a);
				request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);
				break;
			}
		}
		if (!flag) {
			String error = "´íÎó";
			HttpSession session = request.getSession();
			session.setAttribute("error", error);
			request.getRequestDispatcher("bgindex.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
