package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.Product;
//IMPLEMENTATION CLASS OR DAO CLASS
public class ProductDAO {
	static Connection con=null;
	
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int addProduct(Product p) {
		PreparedStatement pstmt = null;
		String query="insert into productinfo(product_name,product_price) values(?,?)";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, p.getProductName());
			pstmt.setDouble(2, p.getProductPrice());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	public int deleteProduct(Product p) {
		PreparedStatement pstmt = null;
		String query="delete from productinfo where product_id=?";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, p.getProductId());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<Product> display() {
		
		//declare resource
		ResultSet rs=null;
		Statement stmt=null;
		ArrayList<Product> Products=new ArrayList();
		
		//sql query
		String query="select * from productinfo";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				
				//add values to object
				Product p1=new Product();
				p1.setProductId(id);
				p1.setProductName(name);
				p1.setProductPrice(price);

				//add objct to arrayList
				Products.add(p1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Products;
		
		
		}
}
