package bookstore;

import java.util.Scanner;

public class Test {

	public static void main (String[]args)
	{
		System.out.println("Put the quanity ");
        Scanner sc1= new Scanner( System.in );
        Double qte   = sc1.nextDouble();
		System.out.println("Put  the unit price ");
        Scanner sc2= new Scanner( System.in );
        Double price   = sc2.nextDouble();
        System.out.println("Total :  "+Calcul.calculateTotalPrice(qte, price));
        
		
	}
}
