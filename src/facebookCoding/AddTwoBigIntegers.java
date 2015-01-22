package facebookCoding;

public class AddTwoBigIntegers {
	public static String add(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s1.equals("0"))
			return s2;
		if (s2 == null || s2.length() == 0 || s2.equals("0"))
			return s1;
		if (s1.charAt(0) == '-' && s2.charAt(0) != '-')
			return subtract(s2, s1.substring(1));
		if (s2.charAt(0) == '-' && s1.charAt(0) != '-')
			return subtract(s1, s2.substring(1));
		boolean isNegative = false;
		if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
			s1 = s1.substring(1);
			s2 = s2.substring(1);
			isNegative = true;
		}
		if (s1.charAt(0) == '+')
			s1 = s1.substring(1);
		if (s2.charAt(0) == '-')
			s2 = s2.substring(1);
		if (s1.length() < s2.length()) {
			String tmp = s1;
			s1 = s2;
			s2 = tmp;
		}
		String rst = "";
		int carry = 0;
		int index1 = s1.length() - 1;
		int index2 = s2.length() - 1;
		while (index1 >= 0 && index2 >= 0) {
			int sum = Character.getNumericValue(s1.charAt(index1)) + Character.getNumericValue(s2.charAt(index2)) + carry;
			rst = String.valueOf(sum % 10) + rst;
			carry = sum / 10;
			index1--;
			index2--;
		}
		while (index1 >= 0) {
			int sum = Character.getNumericValue(s1.charAt(index1)) + carry;
			rst = String.valueOf(sum % 10) + rst;
			carry = sum / 10;
			index1--;
		}
		if (carry > 0)
			rst = String.valueOf(carry) + rst;
		return isNegative ? "-" + rst : rst;
	}
	private static String subtract(String s1, String s2) {
		boolean isNegative = false;
		if (s1.length() < s2.length()) {
			String tmp = s1;
			s1 = s2;
			s2 = tmp;
			isNegative = true;
		}
		else if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (Character.getNumericValue(s1.charAt(i)) < Character.getNumericValue(s2.charAt(i))) {
					String tmp = s1;
					s1 = s2;
					s2 = tmp;
					isNegative = true;
					break;
				}
			}
		}
		int index1 = s1.length() - 1;
		int index2 = s2.length() - 1;
		int carry = 0;
		String rst = "";
		while (index1 >= 0 && index2 >= 0) {
			int c1 = Character.getNumericValue(s1.charAt(index1));
			int c2 = Character.getNumericValue(s2.charAt(index2));
			int sum = 0;
			if (c1 - carry < c2) {
				sum = c1 - carry + 10 - c2;
				carry = 1;
			}
			else {
				sum = c1 - carry - c2;
				carry = 0;
			}
			rst = String.valueOf(sum) + rst;
			index1--;
			index2--;
		}
		if (index1 >= 0) {
			int sum = Character.getNumericValue(s1.charAt(index1)) - carry;
			rst = String.valueOf(sum) + rst;
			index1--;
		}
		if (index1 >= 0)
			rst = s1.substring(0, ++index1) + rst;
		return isNegative ? "-" + rst : rst;
	}
	public static void main(String[] args) {
		String s1 = "-3253465437567";
		String s2 = "-657987980987";
		System.out.println(add(s1, s2));
	}
}
