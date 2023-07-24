package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validationlink")
public class validation extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid=req.getParameter("id");
		String password=req.getParameter("password");
		
		String id="bluenik";
		String pass="Nikhil@21";
		
		PrintWriter pw=resp.getWriter();
		
		if(userid.equals(id) && pass.equals(password)) {
				RequestDispatcher rd=req.getRequestDispatcher("welcomelink");
				rd.include(req, resp);
			}else {
				pw.print("<h1>INVALID ID OR PASSWORD</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, resp);
		}
	}

}
