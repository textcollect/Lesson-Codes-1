package Collections;
import java.util.*;
import java.text.DateFormatSymbols;

public class Collections {
	public static void main(String[] args) {
		// Practice 1
//		Practice1 practice1= new Practice1();
//		practice1.exercise4();
		Practice1.exercise4(); //alternative to above 2 lines
		Practice1.exercise5();
		Practice2.exercise1();
		Practice2.exercise3();
		Practice2.exercise2();
		Practice2.exercise4();
	}
}

class Practice1 {
	public static void exercise4() {
		//array that stores int value data types and has a size of 5
		int[] nums =  new int[5];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = 5 * (i+1);
			System.out.println(nums[i]);
		}

		//new array that stores all the numbers from the first array
		//new array will have 1 less element than the first as 20 is excluded
		int[] nums2 = new int[nums.length - 1];
		int j = 0; //for inner loop in if-statement

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 20) {
				// copy all elements from nums to nums2
				// nums[4] = 20 is not copied into nums2[4]
				// 2 indexes are needed as nums2 has lesser elements than nums
				nums2[j] = nums[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(nums2));
	}

	public static void exercise5() {
		// new ArrayList that stores int value types
		ArrayList<Integer> values = new ArrayList<Integer>();

		// Insert into the array the first 10 numbers. (From 1 to 10)
		for (int i = 1; i < 11; i++) {
			values.add(i);
		}
		System.out.println(values); //print every number

		int i = 0;
		while (i < values.size()) {
			//Remove the number 5 from the array
			if (values.get(i) == 5) {
				values.remove(i);
				//If there is more than one 5 than don't put break
				break; //stops the loop after the element with number 5 is gone.
			}
			i++;
		}
		System.out.println(values); //verify that the array list is correct
	}
}

class Practice2 {
	public static void exercise1() {
		// 1. HashSet definition of type String
		HashSet<String> names = new HashSet<String>();

		// 2. Adding values to set
		String[] nameList = {"Santiago", "Andres", "Camilo", "Santiago"} ;
		for (int i = 0; i < nameList.length; i++) {
			names.add(nameList[i]);
		}

		// Explain that the name Santiago is not added
		System.out.println(names);

		// 3. Displaying set size
		int size = names.size();
		System.out.println("total names: " + size);

		// 4. Verify if set contains name Santiago
		boolean containsName = names.contains("Santiago");
		System.out.println("contains Name: " + containsName);

		// 5. Remove name Santiago
		names.remove("Santiago");
		System.out.println(names);

		// 6. Use for-loop to iterate over car array
		//for (int i = 0; i < names.size(); i++) {
		//	String name = names.get(i);
		//  System.out.println("name: " + name);	}
		for (String name: names) {
			System.out.println("name: " + name);
		}
	}

	public static void exercise2() {
		// Create a new HashSet to store the months
		HashSet<String> months = new HashSet<>();

		// Get an array of all the month names
		String[] monthSet = new DateFormatSymbols().getMonths();

		// Add each month name to the HashSet
		for (int i = 0; i < monthSet.length; i++) {
			months.add(monthSet[i]);
		}

		// Remove empty string from the Hashset
		months.remove("");
		System.out.println(months); // print all months out (unsorted)

		// Remove birth month
		months.remove("May");
		System.out.println(months.contains("May"));
	}

	public static void exercise4() {
		// Define a new HashMaps that stores String with a key of type Character.
		HashMap<Character, String> dataTypes = new HashMap<>();

		// Insert into the hashmap 5 different data types name in Java
		dataTypes.put('i', "integer");
		dataTypes.put('f', "float");
		dataTypes.put('b', "boolean");
		dataTypes.put('d', "double");
		dataTypes.put('s', "string");

		System.out.println(dataTypes);

		//Use an enhanced for-loop to print every data type.
		for (char key : dataTypes.keySet()) {
			System.out.println("key: " + key + " value: " + dataTypes.get(key));
		}
		System.out.println("");

		// Remove the float data type from the hashmap and verify that the new hashmap is correct (for each loop).
		dataTypes.remove('f');
		for (char key : dataTypes.keySet()) {
			System.out.println("key: " + key + " value: " + dataTypes.get(key));
		}
	}
	public static void exercise3() {
		// HashMap
		// 1. Hashmap definition of type int, String
		HashMap<Integer, String> users = new HashMap<Integer, String>();

		// 2. Adding values to the map
		String[] names = {"Camilo", "Andres", "Laura", "Andrea", "Kate"};

		for (int i = 0; i < names.length; i++) {
			users.put(i+1, names[i]);
		}
		System.out.println(users);

		// 3. Displaying map size
		int size = users.size();
		System.out.println("total users: " + size);

		// 4. Display users with key 2
		String userKey2 = users.get(2);
		System.out.println("User with key 2: " + userKey2);

		// 5. Remove value with key 2
		users.remove(2);
		System.out.println(users);

		// 6. Use for-loop to iterate over user's map
		for (int key : users.keySet()) {
			System.out.println("key: " + key + " value: " + users.get(key));
		}
	}
}