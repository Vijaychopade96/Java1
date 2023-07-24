package crudOperations;

import java.sql.*;
import java.util.Scanner;

public class update {
Scanner sc1= new Scanner(System.in);
String query;

    public void update(int id) {
    	Connection con=null;
        Statement stmt=null;
        
        System.out.println("Choose field you want to change");
        System.out.println("1. Name of Employee\n2. Salary of Employee\n3. Designation of Employee");
        int choise=sc1.nextInt();
        
        if(choise == 1) {
        	System.out.println("Enter correct name: ");
        	String name = sc1.next();
    		query="update emptable set ename='"+name+"' where eid="+id+"";
        }else if(choise == 2) {
        	System.out.println("Enter correct Salary: ");
        	double sal=sc1.nextDouble();
    		query="update emptable set sal="+sal+" where eid="+id+"";
        }else if(choise == 3) {
        	System.out.println("Enter correct Designation: ");
        	String des = sc1.next();
    		query="update emptable set des='"+des+"' where eid="+id+"";
        }else {
        	System.out.println("Invalid choise");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nikhil@21");

            stmt=con.createStatement();

            int count=stmt.executeUpdate(query);
            System.out.println(count+" records updated");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

