package ControlFlowLoops;
import java.util.Map;
import java.util.Scanner;
import java.time.Month;

public class CFLPractice {
	public static void main(String[] args) {

		// Practice 1, Exercise 2
		//System.out.println(practice1());

		// Practice 2, Exercise 1
		//System.out.println(seasons());

		// Practice 2, Exercise 2
		//System.out.println(month());

		// Practice 3
		//practice3();

		// Practice 4
		// Part 1 - Commission Calculator
		//commission();

		// Practice 4 Part 2 - Movie Discounts
		//movie();

		// Practice 5
		//practice5();
		//check5();
		//average5();
	}

	public static String practice1() {
		// Practice 1 - If-else Statement
		// Exercise 2
		Scanner scanner = new Scanner(System.in);

		String grade = "", score = "", name = ""; //Initialise as empty string
		int score2 = 0;
		boolean integerEntered = false;

		while (!integerEntered) {
			System.out.println("Please enter the student's score: ");
			score = scanner.nextLine(); // Set value of score based on user input

			try {
				score2 = Integer.parseInt(score); //convert string into integer
				if (score2 >= 85) {
					grade = "Congrats, you scored an 'A'!";
				} else if (score2 >= 75) {
					grade = "Good Job, you scored a 'B'!";
				} else if (score2 >= 50) {
					grade = "You scored a 'C'. Try harder next time!";
				} else if (score2 >= 0) {
					grade = "You have failed. Please come and see me.";
				}else {
					grade = "Please enter a valid grade.";
				}
				System.out.println("Please enter the student's name: ");
				name = scanner.nextLine(); // Set name based on user input

				integerEntered = true; //End the loop if no exceptions
			} catch (Exception e) {
				System.out.println("Please enter a valid score. Enter again: ");
			}
		}
		return String.format("%s, %s", name, grade);
	}

	public static String seasons() {
		Scanner scanner = new Scanner(System.in);
		String season = ""; //Initialise as empty string
		//int season2 = 0;

		boolean integerEntered = false;

		while (!integerEntered) {
			System.out.println("Please enter the season number: ");
			season = scanner.nextLine(); // Set value of score based on user input

			try {
				//season2 = Integer.parseInt(season); //convert string into integer
				switch (Integer.parseInt(season)) {
					case 1:
						season = "winter";
						break;
					case 2:
						season = "spring";
						break;
					case 3:
						season = "summer";
						break;
					case 4:
						season = "autumn";
						break;
					default:
						season = "out of bounds";
						break;
				}
				integerEntered = true;
			} catch (Exception e) {
				System.out.println("Please enter a number. Enter again: ");
			}
		}
		return season;
	}

	public static Month month() {
		// Practice 2 Exercise 2
		Scanner scan = new Scanner(System.in);

		String month; //Initialise as 0
		Month month2 = null; //Initialise month2
		boolean integerEntered = false;

		while (!integerEntered) {
			System.out.println("Please enter the month number: ");
			try {
				month = scan.nextLine(); // Set value of score based on user input
				month2 = Month.of(Integer.parseInt(month));
				integerEntered = true;
			} catch (Exception e) {
				System.out.println("Error: Please enter a valid number.");
			}
		}
		return month2; //returns Month based on integer. type is Month data type.

		/*
		// Practice 2 Exercise 2 Alternative

		int month = 0; //Initialise as 0
		Month month2 = null;
		boolean integerEntered = false;

		while (!integerEntered) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Please enter the month number: ");
				month = scan.nextInt(); // Set value of score based on user input
				month2 = Month.of(month);
				integerEntered = true;
			} catch (Exception e) {
				System.out.println("Error: Please enter a valid number.");
			}
		}
		 */
	}

	public static void practice3() {
		// Practice 3 - While/ Do While & For Loop
		// 1
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
		}

		// 2
		int j = 0;
		while (j < 15) {
			String name = "your name";
			System.out.printf("%s %d %n", name, j);
			j++;
		}

		// 3
		int k = 0;
		do {
			String name = "your name";
			System.out.printf("%s %d %n", name, k);
			k++;
		} while (k < 10);

		// 4
		for (i = 1; i < 11; i++) {
			String name = "your name";
			System.out.printf("%s %d %n", name, i);
		}

		// 5
		for (i = 1; i < 11; i++) {
			if (i == 7) {
				continue;
			}
			System.out.println(i);
		}
	}
	public static void commission() {
		// Practice 4
		// Part 1 - Commission Calculator
		Scanner scanner = new Scanner(System.in);

		float input2 = 0;
		boolean isNumber = false;

		while (!isNumber) {
			System.out.println("Enter your sales figure for the month: ");
			String input1 = scanner.nextLine();

			try {
				//try keyword will help to check if an exception/error occurs
				input2 = Float.parseFloat(input1);
				isNumber = true;
			}
			catch (Exception e) {
				// Code to run if Exception occurs
				System.out.println("Error. Please enter a number: ");
			}
		}

		float comm; //commission to be calculated

		if (input2 > 10000) {
			comm = (float) (0.3 * input2); //no need for (float) as the values are already float
		}
		else if (input2 >= 5000) {
			comm = (float) (0.2 * input2);
		}
		else if (input2 >= 1000) {
			comm = (float) (0.1 * input2);
		}
		else {
			comm = 0;
		}

		String str = String.format("Your sales figure is $%.2f. Your commission is $%.2f.", input2, comm);
		System.out.println(str);
	} //End of commission method

	public static void movie() {

		// Practice 4 Part 2 - Movie Discounts
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the age of customer: ");

		String age = ""; //Initialise age as empty string
		int age2 = 0;
		boolean integerEntered = false;

		while (!integerEntered) {
			age = scanner.nextLine(); // Set value of age based on user input

			try {
				age2 = Integer.parseInt(age); //convert string into integer
				if (age2 >= 0) {
					integerEntered = true; // End loop if age is valid. If not, enter again
				} else {
					// if age is < 0
					System.out.println("Please enter a human age. Enter again: ");
				}
			} catch (Exception e) {
				System.out.println("Please enter a valid age. Enter again: ");
			}
		}

		float price = 7;

		if (age2 > 60) {
			price *= 0.45;
		} else if (age2 < 5) {
			price *= 0.4;
		}

		if (price == 7) {
			System.out.println("How many ticket(s) to purchase: ");

			String ticketNum1 = ""; //Initialise ticketNum1 as empty string
			int ticketNum2 = 0; //Initialise ticketNum2 as 0. string of ticketnum1 will be converted into integer in the loop
			boolean ticketInputIsValid = false;

			while (!ticketInputIsValid) {
				ticketNum1 = scanner.nextLine(); // Set value of age based on user input

				try {
					ticketNum2 = Integer.parseInt(ticketNum1); //convert string into integer

					if (ticketNum2 > 1) {
						price *= ticketNum2 * 0.7;
						ticketInputIsValid = true;
					} else if (ticketNum2 > 0) {
						ticketInputIsValid = true;
					} else {
						System.out.println("Please enter a valid number. Enter again: ");
					}
				} catch (Exception e) {
					System.out.println("Please enter an integer. Enter again: ");
				}
			}

		}

		System.out.printf("The ticket price is $%.2f", price);
	} //End of movie method


	public static void practice5() {
		// Part 1
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number: ");

		String number1 = ""; //Initialise number1 as empty string
		boolean numIsValid = false;

		while (!numIsValid) {
			number1 = scan.nextLine(); // Set value of age based on user input

			try {

				if (Integer.parseInt(number1) % 2 == 0) {
					System.out.println("Number is even.");
				} else {
					System.out.println("Number is odd.");
				}
				numIsValid = true;
			} catch (Exception e) {
				System.out.println("Please enter an integer. Enter again: ");
			}
		}
	}

	public static void check5() {
		// Part 2
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number: ");

		String number1 = ""; //Initialise number1 as empty string
		boolean numIsValid = false;

		while (!numIsValid) {
			number1 = scan.nextLine(); // Set value of age based on user input

			try {

				if (Integer.parseInt(number1) % 5 == 0) {
					System.out.println("Number is multiple of 5.");
				} else if (Integer.parseInt(number1) == 0) {
					System.out.println("0 is not multiple of 5.");
				} else {
					System.out.println("Number is not multiple of 5.");
				}
				numIsValid = true;
			} catch (Exception e) {
				System.out.println("Please enter an integer. Enter again: ");
			}
		}
	}

	public static void average5() {
		// Part 3
		double[] nums; // Declare array named nums of double datatype
		nums = new double[5]; //5 array elements
		double sum = 0;

		for (int i = 0; i < 5; i++) {
			// inner loop runs once for each iteration of outer loop
			for (int j = i; j < i + 1; j++) {
				nums[i] = Math.random() * 100; // Randomly generate 5 numbers from 0.0 to 100.0
			}
			sum += nums[i]; // End result: sum = sum+num[1]+num[2]+...
			System.out.printf("Number %d is %f.\n", i, nums[i]);
		}
		System.out.printf("Sum is %f. Average is %.2f", sum, sum/5);
	}
}
