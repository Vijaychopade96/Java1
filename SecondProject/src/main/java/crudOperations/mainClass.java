package crudOperations;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		 boolean ongoing = true;
	        while (ongoing) {
	            Scanner sc1 = new Scanner(System.in);
	            System.out.println("Welcome to Employee Database Table\n\nChoose operation to perform");
	            System.out.println("1. Insert Employee Details\n2. Update Employee Details\n3. Delete Employee Details\n4. View All Employee's Details\n5. Exit");
	            int choise = sc1.nextInt();

	            if (choise == 1) {
	                insert n1 = new insert();
	                System.out.println("Enter employee id");
	                int id = sc1.nextInt();
	                System.out.println("Enter employee name");
	                String name = sc1.next();
	                System.out.println("Enter employee salary");
	                double sal = sc1.nextDouble();
	                System.out.println("Enter employee designation");
	                String des = sc1.next();
	                n1.insert(id, name, sal, des);
	            }
	            else if(choise == 2) {
	            	update u1=new update();
	                System.out.println("Enter employee id");
	                int id = sc1.nextInt();
	                u1.update(id);
	            }
	            else if(choise == 3) {
	            	delete d1=new delete();
	            	System.out.println("Enter employee id");
	                int id = sc1.nextInt();
	                d1.delete(id);
	            }
	            else if(choise == 4) {
	            	select s1=new select();
	            	s1.select();
	            }
	            else {
	                ongoing = false;
	                System.out.println("Exit");
	            }
	        }
	}

}
