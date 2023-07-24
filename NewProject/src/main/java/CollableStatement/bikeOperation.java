package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class bikeOperation {
	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc1.nextInt();
		System.out.println("Enter Model");
		String model=sc1.next();
		System.out.println("Enter company");
		String company=sc1.next();
		System.out.println("Enter price");
		double price=sc1.nextDouble();
		
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			cstmt=con.prepareCall("{call bikeOperations(?, ?, ?, ?)}");
			cstmt.setInt(1, id);
			cstmt.setString(2, model);
			cstmt.setString(3, company);
			cstmt.setDouble(4, price);
			cstmt.execute();
			System.out.println("Record Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
