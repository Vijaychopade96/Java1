package Domain;

import java.util.Scanner;

import DAO.BikeDAO;
import DTO.Bike;

public class BikeMainApp {
	static Scanner sc1=new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your choise : ");
		System.out.println("1. Insert Bike\n2. Delete Bike\n3. Display Bike");
		int choise = sc1.nextInt();
		
		if (choise==1) {
			insertBike();

		}else if (choise==2) {
			deleteBike();
			
		}else if(choise==3) {
			displayBike();
			
		}else {
			System.out.println("Invalid Choise.");
		}
	}
	
	static void insertBike() {
		System.out.println("Enter Model");
		String model=sc1.next();
		System.out.println("Enter company");
		String company=sc1.next();
		System.out.println("Enter price");
		double price=sc1.nextDouble();
		
		Bike b1=new Bike();
		b1.setModel(model);
		b1.setCompany(company);
		b1.setPrice(price);
		
		BikeDAO d1=new BikeDAO();
		int count=d1.addBike(b1);
		System.out.println(count+" recordes inserted.");
	}
	
	static void deleteBike() {
		System.out.println("Enter record id to delete Bike Info");
		int id=sc1.nextInt();
		
		Bike b1=new Bike();
		b1.setId(id);
		
		BikeDAO d1= new BikeDAO();
		int count = d1.deleteBike(b1);
		System.out.println(count+" recordes deleted.");
	}


	static void displayBike() {
		// TODO Auto-generated method stub
		
	}
	

}
