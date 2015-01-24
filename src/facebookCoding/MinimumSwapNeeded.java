package facebookCoding;
/*
 * An operation "swap" means removing an element from the array 
 * and appending it at the back of the same array. Find 
 * the minimum number of "swaps" needed to sort that array. 

Eg :- 3124 
Output: 2 (3124->1243->1234) 

How to do it less than O(n^2) ?
 * 
 */
import java.util.*;
public class MinimumSwapNeeded {
	public static int minSwap(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Invalid input!");
		int[] sorted = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sorted[i] = array[i];
		}
		Arrays.sort(sorted);
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == sorted[j])
				j++;
		}
		return array.length - j;
	}
	public static void main(String[] args) {
		//int[] array = {3, 1, 4, 2};
		int[] array = {7, 9, 8, 2, 5, 4, 1, 3};
		System.out.println(minSwap(array));
	}

}
