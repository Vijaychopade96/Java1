package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gstlink")
public class two extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		double totalAmt=(double) req.getAttribute("total");
		
		double finalAmt=totalAmt + totalAmt*0.05;
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Final Amount with 5% GST</h1>");
		pw.print("<h1>"+finalAmt+"</h1>");
		
	}

}
