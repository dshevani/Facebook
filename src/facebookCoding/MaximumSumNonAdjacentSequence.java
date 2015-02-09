package facebookCoding;
/**
 * FInd the maximum sum of a sub-sequence from an positive integer array where any two 
 * numbers of sub-sequence are not adjacent to each other in the original sequence. 
 * E.g 1 2 3 4 5 6 --> 2 4 6
 * @author shirleyyoung
 *
 */
public class MaximumSumNonAdjacentSequence {
	public static int maxSum(int[] num) {
		if (num == null || num.length == 0)
			throw new IllegalArgumentException("Invalid input!");
		int[] sum = new int[num.length];
		sum[0] = num[0];
		sum[1] = Math.max(num[0], num[1]);
		for (int i = 2; i < num.length; i++) {
			sum[i] = Math.max(sum[i - 1], sum[i - 2] + num[i]);
		}
		return sum[num.length - 1];
	}

	public static void main(String[] args) {
		int[] num = {1, -1, 3, 5, 2, 0, 7};
		System.out.println(maxSum(num));
	}

}
