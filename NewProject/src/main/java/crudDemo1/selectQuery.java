package crudDemo1;

import java.sql.*;

public class selectQuery {
		
	public static void main(String[] args) {
		//import connection and statement from sql package
		Connection con=null;
		Statement stmt=null;
		ResultSet rslt=null;
		
		//query
		String query="select * from productinfo";

		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			
			//to connect to the database(database path with database name, id, password) 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			System.out.println("connected");
			
			//create statement platform
			stmt=con.createStatement();
			rslt=stmt.executeQuery(query);
			
			//execute sql query
			System.out.println("id\t\tname\t\tprice");
			while(rslt.next()) {
				int id=rslt.getInt(1);
				String name=rslt.getString(2);
				double price=rslt.getDouble(3);
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
