package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/salarylink")
public class sal1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String basic=req.getParameter("salary");
		
		double basicSal=Double.parseDouble(basic);
		double hra=basicSal*0.3;
		double gross=basicSal+hra;
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Name Of Employee : "+id+"</h1>");
		pw.print("<h1>Id Of Employee : "+name+"</h1>");
		pw.print("<h1>Gross salary Of Employee : "+gross+"</h1>");
		
		req.setAttribute("gross", gross);
		RequestDispatcher rd=req.getRequestDispatcher("sallink");
		rd.include(req, resp);
	}

}
