package ProductOperations;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		product p1= new product();
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter choise\n1. Add product\n2. delete product\n3. Display all Products");
		int choise=sc1.nextInt();
		if (choise==1) {
			System.out.println("Enter id");
			int id=sc1.nextInt();
			System.out.println("Enter name");
			String name=sc1.next();
			System.out.println("Enter price");
			double price=sc1.nextDouble();
			p1.add(id,name,price);
		}else if (choise==2) {
			System.out.println("Enter id");
			int id=sc1.nextInt();
			p1.delete(id);
		}else if (choise==3) {
			p1.display();
		} else {
			System.out.println("Invalid");
		}

	}

}
