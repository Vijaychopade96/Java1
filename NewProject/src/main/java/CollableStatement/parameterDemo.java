package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class parameterDemo {

	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter company");
		String company=sc1.next();
		
		Connection con= null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			cstmt=con.prepareCall("{call parameterDemo(?, ?)}");
			cstmt.setString(1, company);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			System.out.println("Total no. of models are "+cstmt.getInt(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
