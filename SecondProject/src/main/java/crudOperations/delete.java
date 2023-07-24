package crudOperations;

import java.sql.*;

public class delete {

    public void delete(int id) {
        Connection con=null;
        Statement stmt=null;

        String query="delete from emptable where eid="+id+"";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nikhil@21");

            stmt=con.createStatement();

            int count=stmt.executeUpdate(query);
            System.out.println(count+" records deleted");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

