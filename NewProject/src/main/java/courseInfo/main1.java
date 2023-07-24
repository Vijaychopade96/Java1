package courseInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class main1 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream fin=null;
		
		String query="insert into courseinfo(name,image) values(?,?)";
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, "java");
			fin=new FileInputStream("D:\\java.png");
			pstmt.setBinaryStream(2, fin);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "sql");
			fin=new FileInputStream("D:\\java.png");
			pstmt.setBinaryStream(2, fin);
			pstmt.executeUpdate();
			
			System.out.println("updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
