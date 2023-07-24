package crudDemo1;

import java.sql.*;

public class insertConnectionDemo1 {
		
	public static void main(String[] args) {
		//import connection and statement from sql package
		Connection con=null;
		Statement stmt=null;
		
		//query
		String query="insert into productInfo values(4,'laptop',50000)";

		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			
			//to connect to the database(database path with database name, id, password) 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			System.out.println("connected");
			
			//create statement platform
			stmt=con.createStatement();
			
			//execute sql query
			int count=stmt.executeUpdate(query);
			System.out.println(count+" records updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
