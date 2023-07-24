package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class customerType {

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
			cstmt=con.prepareCall("{?=call billCalculator(?,?)}");
			cstmt.setInt(2, a);
			cstmt.setDouble(3, b);
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			System.out.println("Total Amount of products is "+cstmt.getDouble(1)+"$.");
			
			double c=cstmt.getDouble(1);
			cstmt=con.prepareCall("{?=call customerType(?)}");
			cstmt.setDouble(2, c);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.execute();
			System.out.println("Customer Type is "+ cstmt.getNString(1));
			
			String d=cstmt.getNString(1);
			cstmt=con.prepareCall("{?=call decideDiscount1(?,?)}");
			cstmt.setDouble(2, c);
			cstmt.setString(3, d);
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			System.out.println("Total Discounted Amount of Customer is "+cstmt.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
