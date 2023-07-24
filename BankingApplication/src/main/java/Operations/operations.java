package Operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mainPage")
public class operations extends HttpServlet{
	Connection con=null;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1esa2","root","Nikhil@21");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNo = req.getParameter("account");
		String amt = req.getParameter("amount");
		String deposite = req.getParameter("deposite");
		String withdraw = req.getParameter("withdraw");
		String balance = req.getParameter("balance");
		PrintWriter pw=resp.getWriter();
		
		double amount = Double.parseDouble(amt);
//----------------------------------------------------------------------------------------------------------------------
		
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		if(deposite!= null) {
			String accNo=null;
			String name= null;
			Double bal=0.0;
			String query="select * from bank_info where acc_no='"+accountNo+"'";
			String query1="update bank_info set balance=? where acc_no=?";
			
			try {
				pstmt=con.prepareStatement(query);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					accNo=rs.getString(1);
					name=rs.getString(2);
					bal=rs.getDouble(3);
				}
				if(accountNo.equals(accNo)) {
					amount=amount+bal;
					int count=0;
					try {
						pstmt=con.prepareStatement(query1);
						pstmt.setDouble(1, amount);
						pstmt.setString(2, accountNo);
						count=pstmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pw.print("<a href=index.html><h1>Money Deposited</h1></a>");
					
				}else {
					pw.print("<h1>Account no not matched</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(withdraw!=null) {
			String accNo=null;
			String name= null;
			Double bal=0.0;
			String query="select * from bank_info where acc_no='"+accountNo+"'";
			String query1="update bank_info set balance=? where acc_no=?";
			
			try {
				pstmt=con.prepareStatement(query);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					accNo=rs.getString(1);
					name=rs.getString(2);
					bal=rs.getDouble(3);
				}
				if(accountNo.equals(accNo)) {
					if(bal>amount) {
						bal=bal-amount;
						int count=0;
						try {
							pstmt=con.prepareStatement(query1);
							pstmt.setDouble(1, bal);
							pstmt.setString(2, accountNo);
							count=pstmt.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.print("<h1>Money Withdraw</h1>");
					}else {
						pw.print("<h1>Insufficient balance</h1>");
						
					}
				}else {
					pw.print("<h1>Account no not matched</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

//public void byCompany(String company) {
//	String query="Select * from bikeinfo where company='"+company+"'";
//	try {
//		pstmt=con.prepareStatement(query);
//		rs=pstmt.executeQuery(query);
//		System.out.println("id\t\tmodel\t\tcompany\t\tprice");
//		while(rs.next()) {
//			int id=rs.getInt(1);
//			String model=rs.getString(2);
//			String company2=rs.getString(3);
//			double price =rs.getDouble(4);
//			System.out.println(id+"\t\t"+model+"\t\t"+company2+"\t\t"+price);
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}		
//}

//public double billCalculate(String item, String dtype) {
//	PreparedStatement pstmt=null;
//	ResultSet rs=null;
//	double price=0;
//	double bill = 0;
//	
//	String query="select * from grocery_shop where item=?";
//	
//	try {
//		pstmt=con.prepareStatement(query);
//		pstmt.setString(1, item);
//		rs=pstmt.executeQuery();
//		while(rs.next()) {
//			price=rs.getDouble(3);
//		}
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	if(dtype.equals("regular")) {
//		bill=30+price;
//	}else if(dtype.equals("quick")) {
//		bill=60+price;
//	}
//	return bill;
//}
