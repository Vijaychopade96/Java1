import java.sql.*;

public class insert {

    public void insert(int id, String name, double sal, String des) {
        Connection con=null;
        Statement stmt=null;

        //query
        String query="insert into emptable values("+id+",'"+name+"',"+sal+",'"+des+"')";

        try {
            //load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("loaded");

            //to connect to the database(database path with database name, id, password)
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nikhil@21");
            System.out.println("connected");

            //create statement platform
            stmt=con.createStatement();

            //execute sql query
            int count=stmt.executeUpdate(query);
            System.out.println(count+" records updated");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
