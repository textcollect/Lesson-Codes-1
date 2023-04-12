package Variables;
import java.util.Scanner;

public class VariablesPractice {

	public static void main(String[] args) {

		// Practice 1 - Variables & Data Types
		// Exercise 1
		String myName = "Jay Anderson";
		byte age = 19;
		String email = "alien@havethebestgoats.com";

		//note: %n - A new line character appropriate to the platform running the application.
		// You should always use %n, rather than \n.
		System.out.printf("My name is %s, I am %d years old and my email is %s.%n", myName, age, email);


		// Exercise 2
		char myGender = 'F';
		boolean isJavaFun = true;
		float myFloat = 1.5f;
		float myDouble = 99.99f;
		float mySalary = 1200.50f;

		String str = String.format("My gender is %c, and my salary is %.2f. Java is fun! %b.", myGender, mySalary, isJavaFun);
		System.out.println(str);



		// Practice 2 - Operators
		// Exercise 1
		int OriginalPrice = 10;
		float gst = 0.07f;
		float FinalPrice = OriginalPrice * gst + OriginalPrice;

		System.out.printf("The cost is $%d, the final cost is $%.2f.%n", OriginalPrice, FinalPrice);


		// Exercise 2
		Scanner input = new Scanner(System.in); //create new Scanner object named "input"

		System.out.println("Enter a word: ");

		String wordInput = input.nextLine();
		String wordDefault = "hellow";

		if (wordDefault.equalsIgnoreCase(wordInput)) {
			System.out.println("Matched!");
		}
		else {
			System.out.println("Not matched!");
		}

	}
}
