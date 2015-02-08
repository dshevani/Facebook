package facebookCoding;
/**
 * Implement a function to compute cubic root. what is the time complexity?
 * O(logn)
 * If f(x) can be evaluated with variable precision, the algorithm can be improved. 
 * Because of the "self-correcting" nature of Newton's method, meaning that it is unaffected 
 * by small perturbations once it has reached the stage of quadratic convergence, 
 * it is only necessary to use m-digit precision at a step where the approximation has m-digit accuracy. 
 * Hence, the first iteration can be performed with a precision twice as high as the accuracy of x_0, 
 * the second iteration with a precision four times as high, and so on. 
 * If the precision levels are chosen suitably, only the final iteration requires f(x)/f'(x)\, 
 * to be evaluated at full n-digit precision. Provided that F(n) grows superlinearly, 
 * which is the case in practice, the cost of finding a root is therefore only O(F(n)), 
 * with a constant factor close to unity.
 * @author shirleyyoung
 *
 */
public class CubicRoot {
	public static int cbrt(int x) {
		if (x == 0 || x == 1 || x == -1)
			return x;
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x = -x;
		}
		long low = 0;
		long high = x;
		while (low <= high) {
			long tri = (low + high) / 2;
			//System.out.println(tri);
			if (tri * tri * tri == x)
				return (int)tri;
			else if (tri * tri * tri < x)
				low = tri + 1;
			else 
				high = tri - 1;
		}
		return isNegative ? -(int) high : (int)high;
	}
	/**
	 * newton's method
	 * @param x
	 * @return
	 */
	public static int cbrtn(int x) {
		if (x == 0 || x == 1 || x == -1)
			return x;
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x = -x;
		}
		double guess = (double)x / 2.0;
		double prev = 0.0;
		while (Math.abs(guess - prev) > 0.01) {
			prev = guess;
			guess = prev - ((prev * prev * prev) - (double)x)/(3 * (prev * prev));
		}
		return isNegative ? -(int)guess : (int) guess;
	}
	public static void main(String[] args) {
		int N = 8;
		final long StartTime = System.nanoTime();
		System.out.println(cbrt(N));
		System.out.println("Binary search running time: " + ((System.nanoTime() - StartTime)/1000) + "ms");
		final long StartTime2 = System.nanoTime();
		System.out.println(cbrtn(N));
		System.out.println("Newton's method running time: " + ((System.nanoTime() - StartTime2)/1000) + "ms");

	}

}
