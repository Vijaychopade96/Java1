package com.qsp.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookieslink")
public class CreateCookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   resp.setContentType("text/html");
	   PrintWriter writer=resp.getWriter();
	   
	   
       Cookie ck=	new Cookie("browser","chrome");
       ck.setMaxAge(90);
       resp.addCookie(ck);
       
       Cookie ck1=	new Cookie("OS","DELL");
       ck1.setMaxAge(90);
       resp.addCookie(ck1);
       
       writer.println("<h3>Cookies has been created...</h3>");
       
       
	
	
	}
}
