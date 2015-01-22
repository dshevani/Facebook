package facebookCoding;

import java.util.*;
public class MatchedStrings {
	public static boolean istMatch(String s1, String s2, int n) {
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
	public static void main(String[] args) {
		String s1 = "acbdeacbdeacbdeacbde";
		String s2 = "cbdea";
		System.out.println(istMatch(s1, s2, 3));
	}

}
