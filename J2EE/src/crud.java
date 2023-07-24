import java.sql.*;
import java.util.Scanner;

public class crud {
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
            } else {
                ongoing = false;
            }
        }
    }
}
