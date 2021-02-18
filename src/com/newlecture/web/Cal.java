package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Cal")
public class Cal extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		int x = 0;
		int y = 0;
	
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String btn = req.getParameter("button");
		if(x_!=null && !x_.equals(""))
			x = Integer.parseInt(x_);
		if(y_!=null && !y_.equals(""))
			y = Integer.parseInt(y_);
		int result = 0;
		if(btn.equals("µ¡¼À"))
			result = x+y;
		if(btn.equals("»¬¼À"))
			result = x-y;
		
		
		out.println(result);
		
		
		
		
		
	}

}
