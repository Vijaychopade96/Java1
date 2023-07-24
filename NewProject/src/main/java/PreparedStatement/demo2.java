package PreparedStatement;

import java.sql.*;

public class demo2 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from productinfo where product_id=?";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 5);
			int count1 = pstmt.executeUpdate();
			
			pstmt.setInt(1, 6);
			int count2 = pstmt.executeUpdate();
			
			pstmt.setInt(1, 4);
			int count3 = pstmt.executeUpdate();
			
			System.out.println(count1+count2+count3+" recordes deleted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
