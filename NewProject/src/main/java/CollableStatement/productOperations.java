package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class productOperations {
	public static void main(String []args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc1.nextInt();
		System.out.println("Enter product name");
		String name=sc1.next();
		System.out.println("Enter price");
		double price=sc1.nextDouble();
		System.out.println("Enter id to delete");
		int did=sc1.nextInt();
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			cstmt=con.prepareCall("{call productOperations(?,?,?,?)}");
			cstmt.setInt(1, id);
			cstmt.setString(2, name);
			cstmt.setDouble(3, price);
			cstmt.setInt(4, did);
			cstmt.execute();
			System.out.println("Insert and Deleted Successfully.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
