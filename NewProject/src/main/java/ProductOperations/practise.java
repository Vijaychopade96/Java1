package ProductOperations;
import java.sql.*; 

public class practise {
	
	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","Nikhil@21");
			st=con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int count=0;
		String query="select * from productinfo";
		System.out.println("id\t\tname\t\tprice");
		try {
			rs=st.executeQuery(query);
			while (rs.next()) {
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
