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
		// 向应用程序中存全局的登录次数
		getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write("hello haohao...");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("tom") && password.equals("123")){
			ServletContext context = getServletContext();
			
			// 获取全局的登录次数
			Integer count = (Integer) context.getAttribute("count");
			// 登录成功，次数加1
			count++;
			response.getWriter().write("Login Successd!---- " + count);
			
			// 再次保存全局的登录次数
			context.setAttribute("count", count);
			
		}else{
			response.getWriter().write("Sorry,your username or password is wrong, Login failed!");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}