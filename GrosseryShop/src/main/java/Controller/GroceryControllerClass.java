package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.GroceryServicesClass;
@WebServlet("/grocerylink")
public class GroceryControllerClass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String item=req.getParameter("items");
		String dtype=req.getParameter("dtype");
		
		GroceryServicesClass gsc=new GroceryServicesClass();//object of model class
		double bill=gsc.billCalculate(item,dtype); //method of model class
		
		req.setAttribute("bill", bill);
		
		RequestDispatcher rd= req.getRequestDispatcher("grocery.jsp");
		rd.include(req, resp);
	}

}
