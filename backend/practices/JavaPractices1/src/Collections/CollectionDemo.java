package Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

		arrayList();
		hashmap();
		hashset();
	}

	public static void arrayList() {
		/*
		Requirements:
		1. Website will retrieve all customer info from db and display on screen
		2. Admin needs to do frequent search from a list of customer via ID to retrieve the info
		3. Admin can add new customer to the list, then add to db

		bulk upload to db: store into a collection first then upload to db

		When to use ArrayList
		- for adding elements or values at the end of the list (no removal or insertion in middle of ArrayList)
		 */

		// Data type of the elements need to be identified in <> when declaring
		// Default size is 10
		// ArrayList has methods to perform operations on the elements (add, remove, edit)
		// able to take in duplicate values
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
		ArrayList<Integer> age = new ArrayList<>();

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
		for (Integer integer : age) {
			sum += integer;
		}
		/*
		for (int i = 0; i < age.size(); i++) {
			sum += age.get(i);
		}
		 */
		System.out.println("The sum is: " + sum);
	}


	public static void hashset() {
		/*
		Hashset
		Store the data w/o dupes (store unique elements)
		Creates a collection that uses a hash table for storage.
		- A hash table stores information by using a mechanism called hashing.
		- In hashing, the informational content of a key is used to determine a unique value,
		called its hash code.
		- The hash code is then used as the index at which the data associated with the key is stored

		Note:
		It is important to note that HashSet does not guarantee the order of its elements,
		because the process of hashing doesn't usually lend itself to the creation of sorted sets.
		If you need sorted storage, then another collection, such as TreeSet, is a better choice.

		Requirement:
		- Jean: Jogging, Cycling, Marathon
		- Mary: Cycling, Swimming
		- John: Marathon
		Get all activities Jean, Mary and John undertake
		 */

		HashSet<String> activities = new HashSet<>();
		activities.add("Jogging");
		activities.add("Cycling");
		activities.add("Marathon");
		activities.add("Swimming");
		activities.add("Jogging");

		System.out.println(activities);

		System.out.println(activities.contains("Swimming"));

		activities.remove("Marathon");
		System.out.println(activities);

		//Hashset<Integer> uniqueAge = new Hashset<>();

	}


	public static void hashmap() {
		/*
		Hashmap
		- Used to store key-value pairs: make use of the key to retrieve the value with more efficiency
		- Key has to be unique
		- e.g. Store the state abbreviation key and state name in Hashmap
		States:
			"TN": "Tennessee"
			"CA": "California"
			"NY": "New York"
			"FL": "Florida"

			customer1 = {name: "Jean Looi", age: 18, address: "Yishun"}
			customer2 = {name: "Jean Looi", age: 18, address: "Punggol"}

			"1001": customer1
			"1002": customer2
		 */
		HashMap<String, String> states = new HashMap<>();

		states.put("TN", "Tennessee");
		states.put("CA", "California");
		states.put("NY", "New York");
		states.put("FL", "Florida");
		states.put("FL", "FFF");

		System.out.println(states);

		// get value of key
		System.out.println(states.get("NY"));

		// remove key
		states.remove("FL");
		System.out.println(states);

	}
}
