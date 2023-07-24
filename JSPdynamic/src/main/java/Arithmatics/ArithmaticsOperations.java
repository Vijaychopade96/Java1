package Arithmatics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arithmatics")
public class ArithmaticsOperations extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val1=req.getParameter("no1");
		String val2=req.getParameter("no2");
		
		double num1=Double.parseDouble(val1);
		double num2=Double.parseDouble(val2);
		
		double add=num1+num2;
		req.setAttribute("add", add);
		double sub=num1-num2;
		req.setAttribute("sub", sub);
		double mul=num1*num2;
		req.setAttribute("mul", mul);
		double div=num1/num2;
		req.setAttribute("div", div);
		
		RequestDispatcher rd=req.getRequestDispatcher(val2)
		
		

		
	}

}
