package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fifthlink")
public class m5 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw =resp.getWriter();
		String name=req.getParameter("name");
		String salary=req.getParameter("salary");
		String designation=req.getParameter("designation");
		
		int sal=Integer.parseInt(salary);
		
		pw.print("<h1>"+name+"</h1>");
		pw.print("<h1>"+sal+"</h1>");
		pw.print("<h1>"+designation+"</h1>");
		double total=0;
		if(designation.equals("HR")) {
			total=(sal+sal*0.2);
		}else if(designation.equals("Manager")) {
			total=(sal+sal*0.3);
		}
		pw.print("<h1>"+total+"</h1>");

		
	}

}
