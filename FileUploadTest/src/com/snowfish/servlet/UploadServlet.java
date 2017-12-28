package com.snowfish.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("HELLO");
		/*
		 * 上传三步
		 * 1. 得到工厂
		 * 2. 通过工厂创建解析器
		 * 3. 解析request，得到FileItem集合
		 * 4. 遍历FileItem集合，调用其API完成文件的保存
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem fi1 = fileItemList.get(0);
			FileItem fi2 = fileItemList.get(1);
			
			System.out.println("普通表单项演示：" + fi1.getFieldName() + 
					"=" + fi1.getString("UTF-8"));
			System.out.println("文件表单项演示：");
			System.out.println("Content-Type: " + fi2.getContentType());
			System.out.println("size: " + fi2.getSize());
			System.out.println("filename: " + fi2.getName());
			
			// 保存文件
			File destFile = new File("c://baibing.jpg");
			fi2.write(destFile);
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
