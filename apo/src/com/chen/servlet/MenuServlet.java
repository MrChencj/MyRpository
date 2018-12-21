package com.chen.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.chen.entity.Menu;
import com.chen.entity.Type;
import com.chen.service.MenuService;
import com.chen.service.TypeService;
import com.chen.service.impl.MenuServiceImpl;
import com.chen.service.impl.TypeServiceImpl;

@WebServlet("/MenuServlet")
@MultipartConfig
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String oprationType = request.getParameter("oprationType");
		if (oprationType.equals("getAllMenu")) {
			getAllMenu(request, response);
			request.getRequestDispatcher("frontDesk/home.jsp").forward(request, response);

		} else if (oprationType.equals("getSumsl")) {
			getSumsl(request, response);
		} else if (oprationType.equals("getMenuById")) {
			getMenuById(request, response);
		} else if (oprationType.equals("bgGetAllMenu")) {
			getAllMenu(request, response);
			request.getRequestDispatcher("bgDesk/allMenu.jsp").forward(request, response);
		} else if (oprationType.equals("bgAddMenuBefore")) {
			bgAddMenuBefore(request, response);
		} else if (oprationType.equals("bgAddMenu")) {
			bgAddMenu(request, response);
			request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);
		}else if(oprationType.equals("bgDelMenu")) {
			bgDelMenu(request, response);
			getAllMenu(request, response);
			request.getRequestDispatcher("bgDesk/allMenu.jsp").forward(request, response);
		}else if(oprationType.equals("bgUpdBeforeMenu")) {
			bgUpdBeforeMenu(request, response);
		}else if(oprationType.equals("bgUpdMenu")) {
			bgUpdMenu(request, response);
			request.getRequestDispatcher("bgDesk/bgMenu.jsp").forward(request, response);

		}
		
		
	}
	
	private void bgUpdMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Part part = request.getPart("file");// 获取到上传的文件
		String fileName = part.getSubmittedFileName();// 上传文件的文件名称
		String fname = new String(fileName.getBytes(), "utf-8");// 统一文件名中文字符集
		String imgpath = this.getServletContext().getRealPath("/") + "/uploade/" + fname;// 构建文件储存的绝对路径
		part.write(imgpath);
		Menu menu = new Menu();
		menu.setImgPath("/apo/uploade/"+fname);
		
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(menu, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ms.updMenu(menu);
	}
	private void bgUpdBeforeMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Menu menu = ms.getMenuById(Integer.parseInt(id));
		//得到菜单类型
		TypeService ts = new TypeServiceImpl();
		Type type = new Type();
		type = ts.getTypeById(menu.getTypeId());
		//得到所有菜单类型列表
		List<Type> typeList = new ArrayList<Type>();
		typeList = ts.getAllType();
		request.setAttribute("typeList", typeList);
		
		request.setAttribute("type", type);
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("bgDesk/bgaddMenu.jsp").forward(request, response);
		
	}
	
	private void bgDelMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ms.delMenu(Integer.parseInt(id));
	}

	
	private void bgAddMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Part part = request.getPart("file");// 获取到上传的文件
		String fileName = part.getSubmittedFileName();// 上传文件的文件名称
		String fname = new String(fileName.getBytes(), "utf-8");// 统一文件名中文字符集
		String imgpath = this.getServletContext().getRealPath("/") + "/uploade/" + fname;// 构建文件储存的绝对路径
		part.write(imgpath);
		
		Menu menu = new Menu();
		menu.setName(request.getParameter("name"));
		menu.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		
		menu.setBurden(request.getParameter("burden"));
		menu.setBrief(request.getParameter("brief"));
		menu.setPrice(Float.parseFloat(request.getParameter("price")));
		menu.setSums(0);
		menu.setPricel(Float.parseFloat(request.getParameter("pricel")));
		menu.setSumsl(0);
		menu.setImgPath("/apo/uploade/"+fname);
		ms.addMenu(menu);
		
		
	}

	private void bgAddMenuBefore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TypeService ts = new TypeServiceImpl();
		List<Type> typeList = new ArrayList<Type>();
		typeList = ts.getAllType();
		request.setAttribute("typeList", typeList);
		request.getRequestDispatcher("bgDesk/bgaddMenu.jsp").forward(request, response);
	}

	private void getMenuById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Menu menu = new Menu();
		menu = ms.getMenuById(Integer.parseInt(id));
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("frontDesk/getMenuById.jsp").forward(request, response);
	}

	private void getSumsl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Menu> listAll = new ArrayList<Menu>();
		listAll = ms.getSortSumsl();
		request.setAttribute("menuListAll", listAll);
		request.getRequestDispatcher("frontDesk/getSortSumsl.jsp").forward(request, response);
	}

	private void getAllMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = 6;
		int num;
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null && pageNum != "") {
			num = Integer.parseInt(pageNum);
		} else {
			num = 1;
		}
		Long count = ms.getCount();
		Long pageCount = count / pageSize + ((count % pageSize == 0) ? 0 : 1);
		List<Menu> list = new ArrayList<Menu>();
		list = ms.getPage(num, pageSize);

		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", num);
		request.setAttribute("menuList", list);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
