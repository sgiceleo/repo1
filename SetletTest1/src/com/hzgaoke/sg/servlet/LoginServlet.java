package com.hzgaoke.sg.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		// ��Ӧ�ó����д�ȫ�ֵĵ�¼����
		getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write("hello haohao...");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("tom") && password.equals("123")){
			ServletContext context = getServletContext();
			
			// ��ȡȫ�ֵĵ�¼����
			Integer count = (Integer) context.getAttribute("count");
			// ��¼�ɹ���������1
			count++;
			response.getWriter().write("Login Successd!---- " + count);
			
			// �ٴα���ȫ�ֵĵ�¼����
			context.setAttribute("count", count);
			
		}else{
			response.getWriter().write("Sorry,your username or password is wrong, Login failed!");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}