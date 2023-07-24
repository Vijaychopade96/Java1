package crudOperations;

import java.sql.*;

public class select {

	public void select() {
			Connection con=null;
			Statement stmt=null;
			ResultSet rslt=null;
			
			String query="select * from emptable";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nikhil@21");
				
				stmt=con.createStatement();
				rslt=stmt.executeQuery(query);
				
				System.out.println("eid\t\tename\t\tesal\t\tdes");
				while(rslt.next()) {
					int id=rslt.getInt(1);
					String name=rslt.getString(2);
					double sal=rslt.getDouble(3);
					String des=rslt.getString(4);

					System.out.println(id+"\t\t"+name+"\t\t"+sal+"\t\t"+des);
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
