package facebookCoding;
/**
 * Given a telephone number, find all the permutations of the letters
 * is there a more efficient way? 
 * @author shirleyyoung
 *
 */
import java.util.*;
public class PhoneNumberPermutation {
	private static final Map<Character, char[]> phoneN = new HashMap<Character, char[]>();
    static {
        phoneN.put('0', new char[] {});
        phoneN.put('1', new char[] {});
        phoneN.put('2', new char[] {'a', 'b', 'c'});
        phoneN.put('3', new char[] {'d', 'e', 'f'});
        phoneN.put('4', new char[] {'g', 'h', 'i'});
        phoneN.put('5', new char[] {'j', 'k', 'l'});
        phoneN.put('6', new char[] {'m', 'n', 'o'});
        phoneN.put('7', new char[] {'p', 'q','r', 's'});
        phoneN.put('8', new char[] {'t', 'u', 'v'});
        phoneN.put('9', new char[] {'w', 'x', 'y', 'z'});
    }
    public static List<String> letterCombinations(String digits) {
    	List<String> rst = new ArrayList<String> ();
    	if (digits == null)
    		return rst;
    	StringBuilder comb = new StringBuilder();
    	getCombinations(digits, rst, comb);
    	return rst;
    }
    public static void getCombinations(String digits, List<String> rst, StringBuilder comb) {
    	if (digits.length() == 0) {
    		rst.addAll(permutations(comb.toString()));
    		return;
    	}
    	for (char c : phoneN.get(digits.charAt(0))) {
    		comb.append(c);
    		getCombinations(digits.substring(1), rst, comb);
    		comb.deleteCharAt(comb.length() - 1);
    	}
    }
    
    private static List<String> permutations(String s) {
  
    	List<String> rst = new ArrayList<String> ();
    	getPermutations(s, new ArrayList<Character> (), rst);
    	return rst;
    }
    private static void getPermutations(String s, List<Character> perms, List<String> rst) {
    	if (perms.size() == s.length()) {
    		rst.add(perms.toString());
    		return;
    	}
    	for (int i = 0; i < s.length(); i++) {
    		if (perms.contains(s.charAt(i)))
    			continue;
    		perms.add(s.charAt(i));
    		getPermutations(s, perms, rst);
    		perms.remove(perms.size() - 1);
    	}
    }

	public static void main(String[] args) {
		int index = 1;
		for (String s : letterCombinations("23")) {
			System.out.println((index++) + " " + s);
		}

	}

}
