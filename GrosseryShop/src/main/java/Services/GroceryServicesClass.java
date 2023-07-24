package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroceryServicesClass {
	static Connection con=null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public double billCalculate(String item, String dtype) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		double price=0;
		double bill = 0;
		
		String query="select * from grocery_shop where item=?";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, item);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				price=rs.getDouble(3);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dtype.equals("regular")) {
			bill=30+price;
		}else if(dtype.equals("quick")) {
			bill=60+price;
		}
		return bill;
	}
	
	

}
