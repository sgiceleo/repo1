package com.hzgaoke.sg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destroy....");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init....");
		
		String jdbc = config.getInitParameter("jdbc");
		String count = config.getInitParameter("count");
		
		System.out.println("jdbc: " + jdbc );
		System.out.println("count: " + count );
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service is running");
		
		PrintWriter writer = response.getWriter();
		writer.write("Hello, Servlet World!!!");
		
	}

}
