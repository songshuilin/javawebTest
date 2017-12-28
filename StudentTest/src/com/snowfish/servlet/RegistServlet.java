package com.snowfish.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snowfish.domain.Manager;
import com.snowfish.service.ManagerService;


@WebServlet("/RegistServlet")
public class RegistServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	ManagerService managerService=new ManagerService();
	public String regist(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hello regist");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Manager manager=new Manager(username,password);
		managerService.regist(manager);
		return "f:/login.jsp";
	}
       
}
