package com.spsp.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spsp.model.UserBean;
import com.spsp.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();
		String id = request.getParameter("id");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		if (id == null || id.equals("")) {
			 response.getWriter().print("id 不能为空");
			 return;
		}
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		if (age != null && !age.equals("")) {
			user.setAge(Integer.parseInt(age));
		} else {
			user.setAge(0);
		}
		user.setId(id);
		user.setName(name);
		user.setStatus("A");
		user.setRdate(new Timestamp(System.currentTimeMillis()));
		
		UserService service = new UserService();
		service.save(user);
		response.sendRedirect("list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
