package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.cabService;

@WebServlet("/cabpage")
public class cabServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String km1=req.getParameter("km");
		String cabtype=req.getParameter("cabtype");
		
		double km=Double.parseDouble(km1);
		
		cabService c1= new cabService();
		double billAmt=c1.bill(km,cabtype);

		req.setAttribute("km", km);
		req.setAttribute("cabtype", cabtype);
		req.setAttribute("billAmt", billAmt);
		
		RequestDispatcher rd=req.getRequestDispatcher("cab.jsp");
		rd.include(req, resp);
	}


}
