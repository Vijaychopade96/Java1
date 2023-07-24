package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp2 
{
	private static Scanner sc;

	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Lower Price");
		int minPrice = sc.nextInt();
		System.out.println("Enter Higher Price");
		int maxPrice = sc.nextInt();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from productinfo where product_price between "+minPrice+" and "+maxPrice+"";
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "Nikhil@21");
			stmt = con.createStatement();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("ID\t\tNAME\t\tPRICE");
			System.out.println("===================================================================");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
		
		
	}

