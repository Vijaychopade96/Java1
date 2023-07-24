package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class areaOfCircle {
	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter radius of circle");
		double a=sc1.nextDouble();
		double b=3.14;
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			
			cstmt=con.prepareCall("{?=call areaOfCircle(?,?)}");
			
			cstmt.setDouble(2, a);
			cstmt.setDouble(3, b);
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			
			cstmt.execute();
			
			System.out.println("Area of circle is "+cstmt.getDouble(1)+"sq.unit.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
