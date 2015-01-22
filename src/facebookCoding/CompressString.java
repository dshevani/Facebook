package facebookCoding;
/*
 * Compress a given string "aabbbccc" to "a2b3c3" 
constraint: inplace compression, no extra space to be used 
assumption : output size will not exceed input size.. 
ex input:"abb" -> "a1b2" buffer overflow.. such inputs will not be given.
 */

public class CompressString {
	public static String compressString(String s) {
		if (s == null || s.length() == 0)
			return s;
		int index = 0;
		int pos = 0;
		while (index < s.length()) {
			char curr = s.charAt(index);
			int count = 0;
			while (index < s.length() && curr == s.charAt(index)) {
				count++;
				index++;
			}
			if (index == s.length()) {
				s = s.substring(0, pos + 1) + String.valueOf(count);
				break;
			}
				
			s = s.substring(0, pos + 1) + String.valueOf(count) + String.valueOf(s.charAt(index)) + s.substring(pos + 1);
			index += 2;
			pos += 2;
			
		}
		return s;
	}
	public static void main(String[] args) {
		String s = "abbb";
		System.out.println(compressString(s));
	}
}
