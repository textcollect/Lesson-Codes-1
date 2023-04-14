package Collections;
import java.util.ArrayList;

public class CollectionDemo {
	public static void main(String[] args) {
		// Collection
		/*
		Store a group of objects:
		1) Array - standard array object built-in Java package
		use case example: Retrieve a list of country codes from the db and display it in a dropdown list for user to select
		will know the total no. of country codes from data retrieved from db
		(In Summary: for displaying read-only data)

		2) External libraries for collection objects to store a group of objects (e.g. arraylist, hashset, hashmap)
		to have easy access and to perform operation (add, edit, delete, update) to the object's data
		 */

		// Standard array object limitations:
		// - can only store a fixed size of element(s) when initializing & declaring it
		String[] cars = {"Volvo", "BMW", "Ford", "Tesla", "Honda"};
		int[] age = {18, 20, 26, 60, 45};

		System.out.println(cars[0] + " is at the age of " + age[0]);

		cars[0] = "Mercedes";
		System.out.println(cars[0] + " is at the age of " + age[0]);
		System.out.println(cars.length);

		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}


		int numCountryCode = 30; // 30 is length of array. this number is based on data retrieved from db
		// must specify size of array when creating it
		int[] countryCode;
		countryCode = new int[numCountryCode]; //or int[] countryCode = new int[numCountryCode]
		countryCode[0] = 65;
		countryCode[1] = 60;
		countryCode[2] = 66;

	}

	public static void arrayList() {
		/*
		Requirements:
		1. Website will retrieve all customer info from db and display on screen
		2. Admin needs to do frequent search from a list of customer via ID to retrieve the info
		3. Admin can add new customer to the list, then add to db
		 */

		// Data type of the elements need to be identified in <> when declaring
		// Default size is 10
		// Note: data type of the ArrayList itself is list
		ArrayList<String> cars = new ArrayList<String>(2); //create an ArrayList object
		cars.add("Volvo"); //Recall that a quoted string is translated into a String object
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Honda");
		System.out.println(cars);

		cars.set(0, "Tesla");
		System.out.println(cars.get(0));

		cars.remove(0);
		System.out.println(cars);

		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}

		// Primitive data types (int, boolean, double, char, etc) cannot be declared w ArrayList
		// ArrayList elements are objects. Referring to above: Recall that a quoted string is translated into a String object
		// To declare ArrayList w Primitive data type, need to use Wrapper class
		ArrayList<Integer> age = new ArrayList<Integer>();

		// 18 is primitive data type
		// add method is able to perform "Autoboxing" - primitive to object conversion
		int currAge = 50;
		age.add(18);
		age.add(currAge); //adding in a primitive data type

		// Unboxing
		// Automatically converting an object of a Wrapper class to its corresponding primitive type
		int getAge = age.get(age.size()-1); //get last element in the age list

		System.out.println(age);

		int sum = 0;
		for (int i = 0; i < age.size(); i++) {
			sum += age.get(i);
		}
		System.out.println("The sum is: " + sum);
	}
}
