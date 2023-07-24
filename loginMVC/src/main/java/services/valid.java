package services;

import java.sql.*;

public class valid {
	
	static Connection con=null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean validate(String username, String password) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String name = null;
		String pass = null;
		
		String query="select * from logindata where name=?";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				name=rs.getString(2);
				pass=rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(username.equals(name) && password.equals(pass)) {
			return true;
		}else {
		return false;
		}
		
	}

}
