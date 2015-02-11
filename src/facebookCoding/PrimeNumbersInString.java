package facebookCoding;
/**
 * Print out all prime numbers in a given string. 
 * e.g., abc2134kd31 -> 2, 13, 3, 3
 * @author shirleyyoung
 *
 */
import java.util.*;
public class PrimeNumbersInString {
	public static List<Integer> primeNumbers(String s) {
		if (s == null || s.length() == 0)
			throw new IllegalArgumentException("Invalid input!");
		
		int index = 0;
		List<Integer> prime = new ArrayList<Integer> ();
		while (index < s.length()) {
			if(!Character.isDigit(s.charAt(index))) {
				index++;
				continue;
			}
			int pos = index;
			while (index < s.length() && Character.isDigit(s.charAt(index))) {
				for (int i = index; i >= pos; i--) {
					int potentialPrime = Integer.parseInt(s.substring(i, index + 1));
					if (isPrime(potentialPrime))
						prime.add(potentialPrime);
				}
				index++;
			}
		}
		return prime;
		
	}
	/**
	 * the square root of a number, if is an integer, always lies in the middle 
	 * among all factors 
	 * @param n
	 * @return
	 */
	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		//List<Integer> primes = (primeNumbers("abc2134kd31"));
		//List<Integer> primes = (primeNumbers("abcdefg"));
		List<Integer> primes = (primeNumbers("1237135"));
		for (Integer i : primes) {
			System.out.print(i + " ");
		}
		System.out.println("");

	}

}
