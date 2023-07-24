package Authentication;

import java.sql.*;

import java.util.Scanner;

public class CheckLoginCredentials 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String user = sc.next();
		System.out.println("Enter Password");
		String pwd = sc.next();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "select username,password from login_info";
		
	    try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
	
			
			while(rs.next())
			{
				String dbuser=rs.getString(1);
				String dbpwd = rs.getString(2);
				
				if(dbuser.equals(user) && dbpwd.equals(pwd))
				{
					System.out.println("Login Successful");
					return;
				}
				else
				{
					System.out.println("Invalid Login Details");
					return;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
