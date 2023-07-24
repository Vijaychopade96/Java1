package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class discount {
	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter Bill Amount");
		double a=sc1.nextInt();
		System.out.println("Enter type of customer");
		String b=sc1.next();
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			cstmt=con.prepareCall("{?=call decideDiscount(?,?)}");
			cstmt.setDouble(2, a);
			cstmt.setString(3, b);
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			System.out.println("Total Discounted Amount of products is "+cstmt.getDouble(1)+"$.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
