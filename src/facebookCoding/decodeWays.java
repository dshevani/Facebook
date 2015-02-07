package facebookCoding;
/**
 * Suppose we can translate numbers into characters: 1->a, 2->b, ...26->z given an
integer, for example, 11223, output every translation of the number
 * @author shirleyyoung
 *
 */
import java.util.*;
public class decodeWays {
	public static List<String> ways (String s) {
		if (s == null)
			throw new NullPointerException("Null input string!");
		List<String> rst = new ArrayList<String> ();
		//Map<String, List<String>> pre = new HashMap<String, List<String>> ();
		//pre.put("", new ArrayList<String> ());
		getWays(s, new StringBuilder(), rst);
		return rst;
	}
	private static void getWays(String s, StringBuilder toAdd, List<String> rst) {
		if (s.length() == 0) {
			rst.add(toAdd.toString());
			return;
		}
		if (isValid(s.substring(0, 1)) && (s.length() == 1 || isValid(s.substring(1, 2)))) {
			String curr = getString(Integer.parseInt(s.substring(0, 1)));
			getWays(s.substring(1), toAdd.append(curr),rst);
			toAdd.deleteCharAt(toAdd.length() - 1);	
		}
		if (s.length() >= 2 && isValid(s.substring(0, 2))) {
			String curr = getString(Integer.parseInt(s.substring(0, 2)));
			getWays(s.substring(2), toAdd.append(curr), rst);
			toAdd.deleteCharAt(toAdd.length() - 1);	
		}
	}
	private static String getString(int num) {
		return String.valueOf((char)('A' + num - 1));
	}
	
    private static boolean isValid(String s) {
    	if (s.length() > 2)
    		return false;
    	if (s.equals("0"))
        	return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        if (s.length() == 2 && (Integer.parseInt(s) < 10 || Integer.parseInt(s) > 26))
            return false;
        return true;
    }
    public static void main(String[] args) {
    	List<String> rst = ways("11223");
    	for (String s : rst) {
    		System.out.println(s);
    	}
    	System.out.println(rst.size());
    }

}
