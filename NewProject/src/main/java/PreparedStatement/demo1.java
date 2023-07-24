package PreparedStatement;

import java.sql.*;

public class demo1 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="insert into productinfo values(?,?,?)";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 5);
			pstmt.setString(2, "tv");
			pstmt.setDouble(3,30000);
			int count1 = pstmt.executeUpdate();
			
			pstmt.setInt(1, 6);
			pstmt.setString(2, "grinder");
			pstmt.setDouble(3,25000);
			int count2 = pstmt.executeUpdate();
			
			System.out.println(count1+count2+" recordes inserted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
