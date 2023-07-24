package Operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class display extends HttpServlet{
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select acc_no, name from bank_info";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			PrintWriter pw=resp.getWriter();
			pw.print("<table border='2' cellspacing='0' cellpadding='10'>");
			pw.print("<tr>");
			pw.print("<th>Account No</th>");
			pw.print("<th>Customer Name</th>");
			pw.print("</tr>");

			while(rs.next()) {
				String accNo=rs.getString(1);
				String name=rs.getString(2);
				pw.print("<tr>");
				pw.print("<td>"+accNo+"</td>");
				pw.print("<td>"+name+"</td>");
				pw.print("</tr>");

			}
			pw.print("</table>");
			pw.print("<a href=index.html><button>Home</button></a>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
