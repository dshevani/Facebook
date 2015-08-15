package facebookCoding;
/*
 * Problem Statement: Write a Simple regex parser, where pattern can contain *, + or .
* -> 0 or none
+ -> one or more
. -> Exactly one character

Examples:
Input - Pattern = a*b+c. data= bc
Output - true

Input - Pattern - abc+ data=abc
Output - true

Input - Pattern - ab* data=c
Output - false
 */
public class RegularExpression {
	/*public static boolean isMatch(String s, String p) {
		if (p == null || s == null)
			return false;
		if (p.length() == 0)
			return s.length() == 0;
		if (p.equals(s))
			return true;
		if (p.length() == 1 || (p.charAt(1) != '*' && p.charAt(1) != '+')) {
			if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.'))
				return false;
			return isMatch(s.substring(1), p.substring(1));
		}
		if (p.charAt(1) == '+') {
			if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
				return false;
			}
			for (int i = 1; i <= s.length(); i++) {
				if (i < s.length() && p.length() > 2 && s.charAt(i) != p.charAt(2))
					continue;
				if (isMatch(s.substring(i), p.substring(2)))
					return true;
			}
			return false;
		}
		int index_s = -1;
		while (index_s < s.length() && (index_s < 0 || s.charAt(index_s) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s.substring(index_s + 1), p.substring(2)))
				return true;
			index_s++;
		}
		return false;
	}*/
	public static boolean isMatch(String s, String p){
		if(s == null)
			return p == null;
		if(p == null)
			return false;
		if(p.length() == 0)
			return s.length() == 0;
		if(s.equals(p))
			return true;
		if(p.length() == 1 || (p.charAt(1) != '*' && p.charAt(1) != '+')){
			if(s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.'))
				return false;
			return isMatch(s.substring(1), p.substring(1));
		}
		if(p.charAt(1) == '+'){
			//must match at least once
			if(s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.'))
				return false;
			char match = s.charAt(0);
			int index = 0;
			while(index < s.length()){
				if(s.charAt(index) != match)
					break;
				index++;
			}
			return isMatch(s.substring(index), p.substring(2));
		}
		int index_s = -1;
		while(index_s < s.length() && (index_s < 0 || s.charAt(index_s) == p.charAt(0) || p.charAt(0) == '.')){
			if(isMatch(s.substring(index_s + 1), p.substring(2)))
				return true;
			index_s++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("abbbbc", "ab+v*c"));
	}

}
