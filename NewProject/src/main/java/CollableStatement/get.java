package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class get {
	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter quantity of product");
		int a=sc1.nextInt();
		System.out.println("Enter Price of product");
		double b=sc1.nextDouble();
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			cstmt=con.prepareCall("{?=call multinumbers(?,?)}");
			cstmt.setInt(2, a);
			cstmt.setDouble(3, b);
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			System.out.println("Total Amount of products is "+cstmt.getDouble(1)+"$.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
