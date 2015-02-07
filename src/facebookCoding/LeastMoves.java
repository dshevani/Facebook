package facebookCoding;

public class LeastMoves {
	public static int leastMoves(int m, int n) {
		if (m == n && m == 1)
			return 0;
		if (m == n && m > 1)
			return -1;
		int count = 0;
		while (m > 1 || n > 1) {
			if (m == n)
				return -1;
			else if (m > n) {
				m -= n;
				count++;
			}
			else {
				n -= m;
				count++;
			}
		}
		if (m != 1 || n != 1)
			return -1;
		return count;
	}
	public static void main(String[] args) {
		System.out.println(leastMoves(6, 4));
	}

}
