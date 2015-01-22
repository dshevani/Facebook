package facebookCoding;
/**
 * Write a function that takes in an integer 
 * and returns the number of ones set in the 
 * binary representation.
 * @author shirleyyoung
 *
 */
public class NumberOfOnes {
	public static int countOnes(int n) {
		if (n == 0)
			return 0;
		if (n == -1)
			return 32;
		int count = 0;
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
			n = (-n) - 1;
		}
		while (n > 0) {
			if ((n & 1) == 1)
				count++;
			n = n >> 1;
		}
		return isNegative? 32 - count : count;
	}
	public static void main(String[] argus) {
		int num = Integer.MAX_VALUE;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(countOnes(num));
	}

}
