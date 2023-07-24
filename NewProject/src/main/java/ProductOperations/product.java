package ProductOperations;

import java.sql.*;

public class product {
	static Connection con=null;
	static Statement  stmt=null;
	static ResultSet rs=null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			stmt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void add(int id, String name, double price) {
		String query="insert into productinfo values("+id+",'"+name+"',"+price+")";
		int count = 0;
		try {
			count = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(count+" records inserted");
	}

	public void delete(int id) {
		String query="delete from productinfo where product_id="+id+"";
		int count = 0;
		try {
			count = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(count+" records deleted");
	}

	public void display() {
		String query="select * from productinfo";
		try {
			rs=stmt.executeQuery(query);
			System.out.println("id\t\tname\t\tprice");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
