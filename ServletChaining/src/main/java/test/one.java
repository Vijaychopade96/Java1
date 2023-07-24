package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/billlink")
public class one extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qty=req.getParameter("qty");
		String price=req.getParameter("price");
		
		int qty1=Integer.parseInt(qty);
		double price1=Double.parseDouble(price);
		
		double totalAmt=qty1*price1;
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Total Amount :</h1>");
		pw.print("<h1>"+totalAmt+"</h1>");
		
		req.setAttribute("total", totalAmt);
		
		RequestDispatcher rd=req.getRequestDispatcher("gstlink");
		rd.include(req, resp);
		
		
	}

}
