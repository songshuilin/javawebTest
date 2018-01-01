package com.snowfish.servlet;


import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snowfish.domain.PageBean;
import com.snowfish.domain.Student;
import com.snowfish.service.StudentService;
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	StudentService service=new StudentService();
	public String find(HttpServletRequest request, HttpServletResponse response) {
		String number=request.getParameter("number");
		Student student=service.find(number);
		request.setAttribute("student", student);
		return "f:/edit_student.jsp";
	}
	public String edit(HttpServletRequest request, HttpServletResponse response) {

		String desc=request.getParameter("desc");
		String number=request.getParameter("number");
		String hobby=request.getParameter("hobby");
		String major=request.getParameter("major");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		
		
		Student student=new Student();
		student.setT_desc(desc);
		student.setT_hobby(hobby);
		student.setT_major(major);
		student.setT_name(name);
		student.setT_number(number);
		student.setT_sex(sex);
		student.setT_phone(phone);
		service.edit(student);
		request.setAttribute("msg", "edit 成功！");
		return "f:/msg.jsp";
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) {
	    String number=request.getParameter("number");
		service.delete(number);
     	request.setAttribute("msg", "delete 成功！");
		return "f:/msg.jsp";
	}
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) {
		String currentPage=request.getParameter("currentPage");
		if (currentPage==null||currentPage.trim().isEmpty()) {
			currentPage="1";
		}
		int recoderForPage=8;
		PageBean<Student> bean=service.findAll(Integer.parseInt(currentPage),recoderForPage);
		request.setAttribute("bean", bean);
		
		return "f:/list_student.jsp";
		
	}
}
