package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sixthlink")
public class m6 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw= resp.getWriter();
		int num1=Integer.parseInt(req.getParameter("no1"));
		int num2=Integer.parseInt(req.getParameter("no2"));
		String add1=req.getParameter("add");
		String mult=req.getParameter("mult");
		
		if(add1.equals("ADDITION")) {
			
			pw.print("<h1>Addtion:"+(num1+num2)+"</h1>");

		}else if(add1.equals("MULTIPLICATION")) {
		
			pw.print("<h1>multi:"+(num1*num2)+"</h1>");

		}
		
//		if(add1==null) {
//			pw.print("<h1>multi:"+(num1*num2)+"</h1>");
//		}else if(mult==null) {
//			pw.print("<h1>Addtion:"+(num1+num2)+"</h1>");
//		}
	}
	
}
