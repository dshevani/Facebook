package facebookCoding;
/*
 * Max sum of non-adjacent (means element index, not value) element combination in an
all positive integer array
 */
public class MaxSumNonAdjacentElementcombination {
	public static int maxSum(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		int[][] maxSum = new int[num.length][num.length];
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			maxSum[i][i] = num[i];
			max = Math.max(maxSum[i][i], max);
		}
		for (int i = 0; i + 2 < num.length; i++) {
			maxSum[i][i + 2] = num[i] + num[i + 2];
			max = Math.max(maxSum[i][i + 2], max);
		}
		for (int len = 3; len <= num.length; len++) {
			for (int i = 0; i + len <= num.length; i++) {
				maxSum[i][i + len - 1] = Math.max(maxSum[i][i + len - 2], maxSum[i][i + len - 3] + num[i + len - 1]);
				max = Math.max(maxSum[i][i + len - 1], max);
			}
		}
		/*for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				System.out.print(maxSum[i][j] + " ");
			}
			System.out.println("");
		}*/
		return max;
	}
	public static int maxSum2(int[] num, int k) {
		if (num == null || num.length == 0)
			return 0;
		int[][] maxSum = new int[num.length][num.length];
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			maxSum[i][i] = num[i];
			max = (maxSum[i][i] >  max) && (maxSum[i][i] <= k) ? maxSum[i][i] : max;
		}
		for (int i = 0; i + 2 < num.length; i++) {
			maxSum[i][i + 2] = num[i] + num[i + 2];
			max = (maxSum[i][i + 2] >  max) && (maxSum[i][i + 2] <= k) ? maxSum[i][i + 2] : max;
		}
		for (int len = 3; len <= num.length; len++) {
			for (int i = 0; i + len <= num.length; i++) {
				maxSum[i][i + len - 1] = Math.max(maxSum[i][i + len - 2], maxSum[i][i + len - 3] + num[i + len - 1]);
				max = (maxSum[i][i + len - 1] >  max) && (maxSum[i][i + len - 1] <= k) ? maxSum[i][i + len - 1] : max;
			}
		}
		/*for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				System.out.print(maxSum[i][j] + " ");
			}
			System.out.println("");
		}*/
		return max;
	}
	public static void main(String[] args) {
		int[] num = {5, 5, 10, 40, 50, 35};
		//int[] num = {3, 2, 5, 10, 7};
		System.out.println(maxSum2(num, 60));
	}
}
