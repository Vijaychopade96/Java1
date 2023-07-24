package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDemo 
{
	
	    Connection con = null;
		

		{
			try 
			{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "Nikhil@21");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	public void maxPrice()
	{
		String query = "select * from productinfo where product_price=(select max(price) from productinfo)";
		ResultSet rs = null;
		Statement stmt  = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("ID\t\tNAME");
			System.out.println("===============================================");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				System.out.println(id+"\t\t"+name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void minPrice()
	{
		String query = "select * from productinfo where product_price=(select min(price) from productinfo)";
		ResultSet rs = null;
		Statement stmt  = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("ID\t\tNAME");
			System.out.println("===================================================================");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				System.out.println(id+"\t\t"+name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
