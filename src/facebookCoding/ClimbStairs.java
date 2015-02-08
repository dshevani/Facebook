package facebookCoding;
/**
 * Function to compute the number of ways to climb a flight of n steps. 
 * Taking 1, 2, or 3 steps at a time.
 * Do it in Linear time and constant space. 
 * n = 3. 1 1 1 1 2 2 1 3
 * Ans = 4
 * @author shirleyyoung
 *
 */
public class ClimbStairs {
	public static int ways(int N) {
		if (N <= 1)
			return 1;
		if (N == 2)
			return 2;
		if (N == 3)
			return 4;
		int last1 = 4;
		int last2 = 2;
		int last3 = 1;
		int ways = 0;
		for (int i = 4; i <= N; i++) {
			ways = last1 + last2 + last3;
			last3 = last2;
			last2 = last1;
			last1 = ways;
		}
		return ways;
	}

	public static void main(String[] args) {
		System.out.println(ways(5));

	}

}
