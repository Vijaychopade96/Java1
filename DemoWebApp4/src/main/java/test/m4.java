package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forthlink")
public class m4 extends HttpServlet{
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw =resp.getWriter();
		String name=req.getParameter("name");
		String lname=req.getParameter("lname");
		String contact=req.getParameter("contact");
		String gender=req.getParameter("gender");
		String branch=req.getParameter("branch");
		
		pw.print("<h1><center>INFO TABLE</center></h1>");
		pw.println("<h1><center><table border=1 cellspacing=5 cellpadding=20 style='text-align:center;'><tr><th>NAME</th><th>LAST NAME</th><th>CONTACT NO.</th><th>GENDER</th><th>BRANCH</th></tr>");
		pw.println("<tr><td>"+name+"</td>"+"<td>"+lname+"</td>"+"<td>"+contact+"</td>"+"<td>"+gender+"</td>"+"<td>"+branch+"</td></tr></table></center></h1>");
	}
}
