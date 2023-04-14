package ControlFlowLoops;
import java.util.Scanner;

public class ControlFlowDemo {
	public static void main (String[] args) {
		// Practice for Control Flow and Loops
		/*
		age < 18 - Please buy juice
		age <=21 - Please buy rootbeer
		age <= 60 - ok you can buy beer
		age > 60 - Please take care and drink water

		age > 21 and licence to be true to buy beer. If not, print out unable to buy beer
		 */
		int age = 26;
		boolean licence = true;
		boolean payTax = false;


		if (age < 18) {
			System.out.println("Please buy juice.");
		} else if (age <= 21) {
			System.out.println("Please buy rootbeer.");
		} else if (age <= 60 && licence || payTax) {
			System.out.println("ok you can buy beer.");
		} else if (age > 60) {
			System.out.println("Please take care and drink water");
		} else {
			System.out.println("Unable to buy beer.");
		}

		/*
		Switch case
		To get input from user - u,d,l,r
		- user enter u, print "Move Up"
		- user enter other letter, print "Other Letter Entered"
		 */
		Scanner scan = new Scanner(System.in); //assign Scanner method to variable "scan"
		System.out.println("Enter letter (u, d, l or r): ");
		String userInput = scan.nextLine().toLowerCase();

		switch (userInput) {
			case "u":
				System.out.println("Move Up");
				break;
			case "d":
				System.out.println("Move Down");
				break;
			case "l":
				System.out.println("Move Left");
				break;
			case "r":
				System.out.println("Move Right");
				break;
			default:
				System.out.println("Other Letter Entered");
				break;
		}


		//For-loop 1-10, printing out 5 and 7 only
		for (int i = 1; i < 11; i++)
		{
			if (i == 5 || i == 7)
			{
				System.out.println(i);
			}
		}

		//For-loop from 10 to 1, and skip 5
		for (int i = 10; i > 0; i--)
		{
			if (i != 5)
			{
				System.out.println(i);
				break; //stops the loop after condition is found
			}
		}

		for (int i = 10; i >= 0; i--)
		{
			if (i == 5)
			{
				continue; //skips iteration of the loop if condition is found
			}
			System.out.println(i);
		}

		// While-loop that checks if the integer is less than or equal to 10,
		// print the numbers 1 3 5 7 9
		int i = 1;

		while (i < 10) {
			System.out.println(i);
			i+= 2;
		}

		do {
			System.out.println(i);
			i+= 2;
		} while (i < 10);
	}
}
