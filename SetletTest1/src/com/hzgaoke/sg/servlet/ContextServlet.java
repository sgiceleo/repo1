package com.hzgaoke.sg.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		context.setAttribute("name", "jacket");
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().write("hello haohao...");
		
		ServletContext context = getServletContext();
		String parameter = context.getInitParameter("contextpackage");
		System.out.println(parameter);
		
		
		
		
		// 获取文件路径
		String realPath_A = context.getRealPath("/WEB-INF/lib/a.txt");
		String realPath_B = context.getRealPath("/WEB-INF/b.txt");
		String realPath_C = context.getRealPath("/c.txt");
		
		System.out.println(realPath_A);
		System.out.println(realPath_B);
		System.out.println(realPath_C);
		
		response.getWriter().write(realPath_A);
		response.getWriter().write(realPath_B);	
		response.getWriter().write(realPath_C);
	
		
		
		String path = ContextServlet.class.getClassLoader().getResource("a.txt").getPath();
		System.out.println(path);
		response.getWriter().write(path);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}