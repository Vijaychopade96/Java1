package Domain;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.ProductDAO;
import DTO.Product;

public class ProductMainApp {
	static Scanner sc1=new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean status=true;
		while(status) {
			System.out.println("Enter your choise: ");
			System.out.println("1. Insert Product\n2. Delete Product\n3. Display Product");
			int choise = sc1.nextInt();
			
			if (choise==1) {
				insertProduct();

			}else if (choise==2) {
				deleteProduct();
				
			}else if(choise==3) {
				displayProducts();
				
			}else {
				System.out.println("Invalid Choise.");
				status=false;
			}
		}
	}
	
	
	static void displayProducts() {
		ProductDAO p1= new ProductDAO();
		ArrayList<Product> data=p1.display();//important
		for(Product p:data) {
			System.out.println(p);
		}
	}
	
	
	static void insertProduct() {
		System.out.println("Enter Product name");
		String name=sc1.next();
		System.out.println("Enter Product Price");
		double price=sc1.nextDouble();
		
		//add data to DTO method
		Product p1=new Product();//send to getter setter class 
		p1.setProductName(name);
		p1.setProductPrice(price);
		
		//pass DTO object as argument to addProduct() method
		ProductDAO d1=new ProductDAO();
		int count=d1.addProduct(p1);
		System.out.println(count+" data inserted.");
	}
	
	
	static void deleteProduct() {
		System.out.println("Enter Product id");
		int id=sc1.nextInt();
		
		Product p1=new Product();
		p1.setProductId(id);
		
		ProductDAO d1=new ProductDAO();
		int count=d1.deleteProduct(p1);
		System.out.println(count+" data deleted.");
	}

}
