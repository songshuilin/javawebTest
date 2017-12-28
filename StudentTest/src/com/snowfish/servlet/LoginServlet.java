package com.snowfish.servlet;


import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snowfish.domain.Manager;
import com.snowfish.domain.Student;
import com.snowfish.service.ManagerService;
import com.snowfish.service.StudentService;


@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	ManagerService managerService=new ManagerService();
	StudentService studentService=new StudentService();
	/**
	 * 登录
	 * @param request
	 * @param response
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hello");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Manager manager=new Manager(username,password);
		boolean flag= managerService.find(manager);
		if (flag) {
//			List<Student> list_student=studentService.findAll();
//			System.out.println("list_student:" + list_student.size());
//			request.setAttribute("list_student", list_student);
			return "f:/welcome.jsp";
		}
		request.setAttribute("msg", "登录失败，没有账号，请注册账号再登录！");
		return "f:/login.jsp";
	}



}
