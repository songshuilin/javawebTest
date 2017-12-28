package com.snowfish.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/AUpLoadServlet")
public class AUpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("HELLLLL");
		/*
		 * 上传三步
		 */
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File("h:/temp"));
		// 解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
//		sfu.setFileSizeMax(100 * 1024);//限制单个文件大小为100K
//		sfu.setSizeMax(1024 * 1024);//限制整个表单大小为1M
		
		// 解析，得到List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);
			
			
			//////////////////////////////////////////////////////
			
			/*
			 * 1. 得到文件保存的路径
			 */
			String root = this.getServletContext().getRealPath("/WEB-INF/files/");
			
			System.out.println(root);
			/*
			 * 2. 生成二层目录
			 *   1). 得到文件名称
			 *   2). 得到hashCode
			 *   3). 转发成16进制
			 *   4). 获取前二个字符用来生成目录
			 */
			String filename = fi.getName();//获取上传的文件名称
			/*
			 * 处理文件名的绝对路径问题
			 */
			int index = filename.lastIndexOf("\\");
			if(index != -1) {
				filename = filename.substring(index+1);
			}
			/*
			 * 给文件名称添加uuid前缀，处理文件同名问题
			 */
			String savename = System.currentTimeMillis() + "_" + filename;
			System.out.println(savename);
			/*
			 * 1. 得到hashCode
			 */
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);
			
			/*
			 * 2. 获取hex的前两个字母，与root连接在一起，生成一个完整的路径
			 */
			File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));
			System.out.println("fff");
			/*
			 * 3. 创建目录链
			 */
			dirFile.mkdirs();
			System.out.println("2222eeee");
			/*
			 * 4. 创建目录文件
			 */
			File destFile = new File(dirFile, savename);
			System.out.println("3333");
			/*
			 * 5. 保存
			 */
			fi.write(destFile);
		System.out.println("22222222");
			///////////////////////////////////////////////////////
			
		} catch (FileUploadException e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件超出了100KB！");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
