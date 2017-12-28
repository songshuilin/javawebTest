package com.snowfish.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		Class clazz=this.getClass();
		String methodName=(String) request.getParameter("method");
		System.out.println("methodName: "+methodName);
		if (methodName==null||methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数！无法确定您想要调用的方法！");
		}
		Method method;
		try {
			method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("没有找到你调用的方法"+methodName+"()");
		}
		try {
			String result= (String) method.invoke(this, request,response);
			if(result == null || result.trim().isEmpty()) {
				return;
			}
			String [] s=result.split(":");
			String path=s[1];
            System.out.println("path:"+path);
			if (result.toLowerCase().startsWith("f:")) {
				request.getRequestDispatcher("/pages"+path)
				.forward(request, response);
			}else if (result.toLowerCase().startsWith("r:")) {
				response.sendRedirect(request.getContextPath() + "/pages"+path);
			}else {
				//request.getRequestDispatcher(result).forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("您调用的方法：" + methodName + ",　抛出了异常！");
			throw new RuntimeException(e);
		} 
	}




}
