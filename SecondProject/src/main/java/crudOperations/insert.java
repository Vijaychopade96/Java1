package crudOperations;

import java.sql.*;

public class insert {

    public void insert(int id, String name, double sal, String des) {
        Connection con=null;
        Statement stmt=null;

        String query="insert into emptable values("+id+",'"+name+"',"+sal+",'"+des+"')";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nikhil@21");

            stmt=con.createStatement();

            int count=stmt.executeUpdate(query);
            System.out.println(count+" records inserted");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

