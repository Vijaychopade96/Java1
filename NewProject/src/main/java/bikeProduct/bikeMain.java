package bikeProduct;

import java.util.Scanner;

public class bikeMain {

	public static void main(String[] args) {
		bikeProducts b1= new bikeProducts();
		Scanner sc1 = new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println();
			System.out.println("Choose your Option");
			System.out.println("1. Add Bike\n2. Get Bike By Company\n3. Get Bike by Model\n4. Get All Bikes\n5. Exit");
			int choise=sc1.nextInt();
			
			if(choise==1) {
				System.out.println("Enter Bike Model: ");
				String model=sc1.next();
				System.out.println("Enter Bike Company: ");
				String company=sc1.next();
				System.out.println("Enter Bike Price: ");
				double price=sc1.nextDouble();
				b1.addBikes(model,company,price);
				
			}else if(choise==3) {
				System.out.println("Enter Bike Model: ");
				String model=sc1.next();
				b1.byModel(model);
				
			}else if(choise==2) {
				System.out.println("Enter Bike Company: ");
				String company=sc1.next();
				b1.byCompany(company);
				
			}else if(choise==4) {
				b1.display();
				
			}else if(choise==5){
				System.out.println("Exit.");
				loop=false;
				
			}else {
				System.out.println("Invalid choise.");
				System.out.println();
			}
		}
	}
}
