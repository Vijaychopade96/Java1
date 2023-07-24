package Operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addAccount")
public class add extends HttpServlet{
	Connection con=null;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1esa2","root","Nikhil@21");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accNo = req.getParameter("account");
		String name = req.getParameter("name");
		String initBal = req.getParameter("balance");
		
		double initialBalance = Double.parseDouble(initBal);
		
		PreparedStatement pstmt=null;
		
		String query="insert into bank_info values(?,?,?)";
		int count=0;
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, accNo);
			pstmt.setString(2, name);
			pstmt.setDouble(3, initialBalance);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>"+count+" recordes inserted.</h1>");
	}
}
