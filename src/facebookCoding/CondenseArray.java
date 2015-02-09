package facebookCoding;
/**
 * Given an array of integers, now we want to erase all 0's (can be other value), 
 * and we want the result array condensed, meaning no empty cell in the array
 * @author shirleyyoung
 *
 */
public class CondenseArray {
	public static void condenseArray(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Invalid input");
		int index = 0;
		//the position of the first zero
		int pos = 0;
		while (index < array.length && pos < array.length && array[index] != 0) {
			index++;
			pos++;
		}
		while (index < array.length) {
			while (index < array.length && array[index] == 0) {
				index++;
			}
			if (index == array.length)
				break;
			while (index < array.length && array[index] != 0) {
				array[pos] = array[index];
				pos++;
				index++;
			}
		}
		//the elements after pos is not included in the array
		while (pos < array.length) {
			array[pos] = -1;
			pos++;
		}
	}
	public static void printArray(int[] array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		//int[] array = {1, 3, 4, 0, 0, 2, 3, 0, 9, 1, 2, 0, 0};
		//int[] array = {0, 0, 1, 2, 5, 4, 3, 9, 0, 0, 0, 1, 2};
		int[] array = {1, 0, 2, 0, 3, 0, 4};
		printArray(array);
		condenseArray(array);
		printArray(array);

	}

}
