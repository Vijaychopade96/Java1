package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class demo1 {
	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter no 1");
		int a=sc1.nextInt();
		System.out.println("Enter no 2");
		int b=sc1.nextInt();
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			
			//create platform using callable statement
			cstmt=con.prepareCall("{?=call addnumbers(?,?)}");
			
			//set input to 2nd & 3rd placeholder
			cstmt.setInt(2, a);
			cstmt.setInt(3, b);
			
			//store output into 1st placeholder
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			
			//get output from 1st placeholder
			System.out.println("Addition is "+cstmt.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
