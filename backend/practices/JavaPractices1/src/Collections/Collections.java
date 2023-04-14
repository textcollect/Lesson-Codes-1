package Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class Collections {
	public static void main(String[] args) {
		// Practice 1
//		Practice1 practice1= new Practice1();
//		practice1.exercise4();
		Practice1.exercise4(); //alternative to above 2 lines
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
}