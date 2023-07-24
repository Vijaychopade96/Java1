package crudDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertDynamicRecords {
	public static void main(String[]args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc1.nextInt();
		System.out.println("Enter name");
		String name=sc1.next();
		System.out.println("Enter price");
		double price=sc1.nextDouble();
		
		//import connection and statement from sql package
				Connection con=null;
				Statement stmt=null;
				
				//query
				String query="insert into productinfo values("+id+",'"+name+"',"+price+")";
				
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
				finally {
					if (con!=null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (stmt!=null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
	}

}
