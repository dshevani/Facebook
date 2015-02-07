package facebookCoding;

public class Knapsack {
	public static int maxValue(int[] value, int[] weight, int maxW) {
		if (value == null || weight == null || value.length != weight.length)
			throw new NullPointerException("Invalid input!");
		int[][] values = new int[value.length + 1][maxW + 1];
		for (int i = 1; i <= value.length; i++) {
			for (int w = 1; w <= maxW; w++) {
				if (weight[i - 1] <= w) {
					values[i][w] = Math.max(values[i - 1][w], values[i - 1][w - weight[i - 1]] + value[i - 1]);
				}
				else
					values[i][w] = values[i - 1][w];
			}
		}
		return values[value.length][maxW];
	}
	public static void main(String[] args) {
		int[] value = {10, 40, 30, 50};
		int[] weight = {5, 4, 6, 3};
		System.out.println(maxValue(value, weight, 10));

	}

}
