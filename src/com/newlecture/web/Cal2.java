package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Cal3")
public class Cal2 extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		

	
	
	
		String v_ = req.getParameter("v");
		
		String btn = req.getParameter("button");
		int v = 0;
		if(!v_.equals(""))
			v = Integer.parseInt(v_);
		if(btn.equals("=")) {
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c: cookies) {
			if(c.getName().equals("value"))
				x = Integer.parseInt(c.getValue());
				break;
			}
			int y = v;
			//String button = (String)application.getAttribute("btn");
			//String button = (String)session.getAttribute("btn")
			String button ="";
			for(Cookie c: cookies) {
				if(c.getName().equals("btn"))
					button = c.getValue();
					break;
				}
			int result = 0;
			if(button.equals("+"))
				result= x + y;
			else
				result= x - y;
			resp.getWriter().printf("%d",result);
		}	
		else {
		//application.setAttribute("value", v);
		//application.setA`ttribute("btn", btn);
		//session.setAttribute("value", v);
		//session.setAttribute("btn", btn);
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie btnCookie = new Cookie("btn", btn);
			valueCookie.setPath("/");
			btnCookie.setPath("/");
			resp.addCookie(valueCookie);
			resp.addCookie(btnCookie);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
