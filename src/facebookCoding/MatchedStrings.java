package facebookCoding;

import java.util.*;
public class MatchedStrings {
	//hashset method
	public static boolean isMatch(String s1, String s2, int n) {
		if (s1 == null || s2 == null || s1.length() < n || s2.length() < n)
			return false;
		Set<String> substrings = new HashSet<String> ();
		for (int i = 0; i <= s1.length() - n; i++) {
			substrings.add(s1.substring(i, i + n));
		}
		for (int i = 0; i <= s2.length() - n; i++) {
			if(substrings.contains(s2.substring(i, i + n)))
				return true;
		}
		return false;
	}
	//DP method
	public static boolean isMatch2(String s1, String s2, int n) {
		if (s1 == null || s2 == null || s1.length() < n || s2.length() < n)
			return false;
		int lcs = longestCommonSubstring(s1, s2);
		return lcs >= n;
	}
	public static int longestCommonSubstring(String s1, String s2) {
		if (s1 == null || s2 == null)
			throw new NullPointerException("Null string(s)!");
		int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				}
				max = Math.max(lcs[i][j], max);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		String s1 = "fdsgtry try thfgfddffgf  reyrtgfdghgfh";
		String s2 = "ddffgfddf fgfddff gfddffgfddffgf";
		System.out.println("***HashSet***");
		long startTime = System.nanoTime();
		System.out.println(isMatch(s1, s2, 6));
		System.out.println("Running time: " + (System.nanoTime() - startTime)/1000 + "ms");
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory in bytes: " + (memory));
		System.out.println("****DP****");
		long startTime2 = System.nanoTime();
		System.out.println(isMatch2(s1, s2, 6));
		System.out.println("Running time: " + (System.nanoTime() - startTime2)/1000 + "ms");
		Runtime runtime2 = Runtime.getRuntime();
		runtime2.gc();
		long memory2 = runtime2.totalMemory() - runtime2.freeMemory();
		System.out.println("Used memory in bytes: " + (memory2));
	}

}
