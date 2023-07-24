package DAO;

import java.sql.*;

import DTO.Bike;

public class BikeDAO {
	static Connection con=null;
	static PreparedStatement pstmt=null;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addBike(Bike b1){
		
		int count=0;
		String query="insert into bikeinfo(model,company,price) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, b1.getModel());
			pstmt.setString(2, b1.getCompany());
			pstmt.setDouble(3, b1.getPrice());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	public int deleteBike(Bike b1) {
		int count=0;
		String query="delete from bikeinfo where bikeid=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, b1.getId());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	public void displayBike() {
		
	}
	

}
