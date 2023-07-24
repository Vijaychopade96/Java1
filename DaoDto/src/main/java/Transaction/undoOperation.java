package Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class undoOperation {

	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter Product id");
		int id= sc1.nextInt();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from productinfo where product_id=?";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			
			con.setAutoCommit(false);//imported
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			int count=pstmt.executeUpdate();
			
			System.out.println("Are you really want to delete?");
			System.out.println("1. Yes\n2. No");
			int choise=sc1.nextInt(); 
			 
			if (choise==1) {
				con.commit();
				System.out.println("record deleted.");
			}else if(choise==2) {
				con.rollback();
				System.out.println("Transaction rolled back.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
