package com.snowfish.cn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     System.out.println("hello ajax!!!");
		response.getWriter().write("hello ajax!!!");
		System.out.println(request.getParameter("add"));
	}

}
