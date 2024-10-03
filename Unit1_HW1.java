import java.util.Scanner;

//Thai Nguyen
//5485222
//Unit 1 HW

public class Unit1_HW1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Scan student ID
		System.out.print("Enter the Student's ID: ");
		String id = input.nextLine();
		
		//Scan student name
		System.out.print("Enter the Student's full name: ");
		String name = input.nextLine();
		
		//Scan 1st course numbers & hours
		System.out.print("Enter crn/credit hours for the first class(like 5665/3): ");
		String class1 = input.nextLine();
		String [] array1;
		array1 = class1.split("/"); //Split method
		String n1 = array1[0];
		String h1 = array1[1];
		int num1 = Integer.parseInt(h1); //Parse string to int
		
		//Scan 2nd course numbers & hours
		System.out.print("Enter crn/credit hours for the second class(like 5665/3): ");
		String class2 = input.nextLine();
		String [] array2;
		array2 = class2.split("/"); //Split method
		String n2 = array2[0];
		String h2 = array2[1];
		int num2 = Integer.parseInt(h2); //Parse string to int
		
		//Print the output
		System.out.println();
		System.out.println("Thank you!");
		System.out.println("Fee invoice prepared for: " + name);
		System.out.println();
		
		System.out.println("\t\tSIMPLE COLLEGE");
		System.out.println("\t\tORLANDO FL 10101");
		System.out.println("\t\t*************************");
		System.out.println();
		
		System.out.println("\t\tFee Invoice Prepared for:");
		System.out.println("\t\t[" + name + "]" + "[" + id + "]");
		System.out.println();
		
		double fee = 120.25;
		System.out.println("\t\t1 Credit Hour = $" + fee);
		System.out.println();
		
		System.out.println("\t\tCRN \tCREDIT HOURS");
		System.out.printf("\t\t%s\t%s\t\t\t$%.2f%n",n1, h1, fee*num1);
		System.out.printf("\t\t%s\t%s\t\t\t$%.2f%n",n2, h2, fee*num2);
		System.out.println();
		
		double health = 35.00;
		System.out.printf("\t\t   \tHealth & id fees\t$%.2f%n", health);
		System.out.println();
		System.out.println("\t\t---------------------------------------");
		double total = fee*num1 + fee*num2 + health;
		System.out.printf("\t\t   \tTotal Payments\t\t$%.2f%n", total);


	}

}
