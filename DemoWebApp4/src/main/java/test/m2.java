package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class m2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw =resp.getWriter();
		
		String user="root";
		String pass="Nik@21";
		
		String username=req.getParameter("user");
		String password=req.getParameter("pass");
		
		if(username.equals(user)) {
			if(password.equals(pass)) {
				pw.print("<h1>Login Successfull</h1>");
			}
		}
	}

}
