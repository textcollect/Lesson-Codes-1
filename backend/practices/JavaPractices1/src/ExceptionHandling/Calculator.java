package ExceptionHandling;

public class Calculator {
	public Calculator() {}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			System.out.println("Cannot perform division by zero");
		} catch (Exception e) {
			System.out.println("Some other exception occurred");
		}
		return -1; // `-1` is `null` in int
	}
}

class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		int multiply = calculator.multiply(2, 3);
		System.out.println("Multiplication: " + multiply);

		int divide = calculator.divide(10, 0);
		if (divide != -1) {
			System.out.println("Division: " + divide);
		}

		int addition = calculator.add(4, 6);
		System.out.println("Addition: " + addition);


		// Exception for NumberFormat and ArrayIndexOutOfBounds
		int[] arr = new int[10];

		String getInput = "aaa";
		int getInt = 11;
		try {
			arr[0] = 1;
			arr[5] = 6;
			//arr[11] = 12;
			arr[1] = Integer.parseInt(getInput);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds!");
		} catch (NumberFormatException e) {
			System.out.println("Number format exception");
		} catch (Exception e) {
			System.out.println("Exception occurred");
		}
		System.out.println("End of process");

	}
}
