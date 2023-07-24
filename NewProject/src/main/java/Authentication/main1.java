package Authentication;

import java.util.Scanner;



public class main1 
{
	private static Scanner sc;

	public static void main(String[] args) 
	{
		ProductDemo p = new ProductDemo();
		sc = new Scanner(System.in);
		System.out.println("Enter Your Choice \n1.Max Price \n2.Min Price");
		int choice = sc.nextInt();
		if (choice==1) 
		{
			p.maxPrice();
		}
		else if(choice==2)
		{
			p.minPrice();
		}
	
		else
		{
			System.out.println("Invalid Entry");
		}
	}

}
