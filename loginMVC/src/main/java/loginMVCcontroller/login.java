package loginMVCcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.valid;

@WebServlet("/loginpage")
public class login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		
		valid v1=new valid();
		boolean status=v1.validate(user,pass);
		if(status) {
			resp.sendRedirect("validation.jsp");
		}else {
			resp.sendRedirect("index.html");
		}

	}

}
