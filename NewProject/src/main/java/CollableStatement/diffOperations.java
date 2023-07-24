package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class diffOperations {

	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter login id to delete");
		int logid=sc1.nextInt();
		System.out.println("Enter new bike id to insert");
		int bid=sc1.nextInt();
		System.out.println("Enter bike model");
		String model=sc1.next();
		System.out.println("Enter bike company");
		String company=sc1.next();
		System.out.println("Enter bike price");
		double price=sc1.nextDouble();
		System.out.println("Enter product price to update");
		double productprice=sc1.nextDouble();
		System.out.println("Enter product id");
		int productid=sc1.nextInt();
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			cstmt=con.prepareCall("{call nikh(?,?,?,?,?,?,?)}");
			cstmt.setInt(1, logid);
			cstmt.setInt(2, bid);
			cstmt.setString(3, model);
			cstmt.setString(4, company);
			cstmt.setDouble(5, price);
			cstmt.setDouble(6, productprice);
			cstmt.setInt(7, productid);
			cstmt.execute();
			System.out.println("Insert, Delete and update Successfully.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
