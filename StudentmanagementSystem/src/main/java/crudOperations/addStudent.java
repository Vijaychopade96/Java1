package crudOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addlink")
public class addStudent extends HttpServlet{
	Connection con=null;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
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
		String sid=req.getParameter("studentid");
		String name=req.getParameter("studentname");
		String stream=req.getParameter("studentstream");
		String date=req.getParameter("studentdate");
		
		int id=Integer.parseInt(sid);
		
		PreparedStatement pstmt=null;
		
		String query="insert into studentinfo values(?,?,?,?)";
		int count=0;
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			pstmt.setString(2, name);
			pstmt.setString(3, stream);
			pstmt.setString(4, date);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>"+count+" recordes inserted.</h1>");
	}
}
