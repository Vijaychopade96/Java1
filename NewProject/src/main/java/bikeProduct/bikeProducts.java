package bikeProduct;

import java.sql.*;

public class bikeProducts {
	
	static Connection con = null;
	static PreparedStatement pstmt=null;
	static ResultSet rs=null;
	
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void addBikes(String model, String company, double price) {
		String query="insert into bikeinfo(model,company,price) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,model);
			pstmt.setString(2,company);
			pstmt.setDouble(3, price);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+" recordes updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void byModel(String model) {
		String query="Select * from bikeinfo where model='"+model+"'";
		try {
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery(query);
			System.out.println("id\t\tmodel\t\tcompany\t\tprice");
			while(rs.next()) {
				int id=rs.getInt(1);
				String model1=rs.getString(2);
				String company=rs.getString(3);
				double price =rs.getDouble(4);
				System.out.println(id+"\t\t"+model1+"\t\t"+company+"\t\t"+price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void byCompany(String company) {
		String query="Select * from bikeinfo where company='"+company+"'";
		try {
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery(query);
			System.out.println("id\t\tmodel\t\tcompany\t\tprice");
			while(rs.next()) {
				int id=rs.getInt(1);
				String model=rs.getString(2);
				String company2=rs.getString(3);
				double price =rs.getDouble(4);
				System.out.println(id+"\t\t"+model+"\t\t"+company2+"\t\t"+price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void display() {
		String query="Select * from bikeinfo";
		try {
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery(query);
			System.out.println("id\t\tmodel\t\tcompany\t\tprice");
			while(rs.next()) {
				int id=rs.getInt(1);
				String model=rs.getString(2);
				String company=rs.getString(3);
				double price =rs.getDouble(4);
				System.out.println(id+"\t\t"+model+"\t\t"+company+"\t\t"+price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}

}
