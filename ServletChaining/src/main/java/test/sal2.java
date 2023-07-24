package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sallink")
public class sal2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double gross=(double) req.getAttribute("gross");
		
		double deduction=gross*0.05;
		double net=gross-deduction;
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Net salary Of Employee : "+net+"</h1>");
		
	}

}
