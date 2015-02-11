package facebookCoding;
/**
 * Implement a function string balanceParanthesis(string s); 
 * which given a string s consisting of some parenthesis returns a string s1 
 * in which parenthesis are balanced
 * and differences between s and s1 are minimum.
 * Eg - "(ab(xy)u)2)" -> "(ab(xy)u)2", ")))(((" -> ""
 * @author shirleyyoung
 *
 */
import java.util.*;
public class BalanceParatheses {
	/**
	 * this method will add ')' if it is unbalanced
	 * @param s
	 * @return
	 */
	public static String balanceParatheses(String s) {
		if (s == null || s.length() == 0)
			return s;
		//store the position of left paratheses
		Stack<Integer> lPara = new Stack<Integer> ();
		//check if there exists left paratheses
		StringBuilder rst = new StringBuilder();
		boolean hasLPara = false;
		int i = 0;
		int curPos = 0;
		while (i < s.length()) {
			/*if (s.charAt(i) != '(' && s.charAt(i) != ')') {
				i++;
				continue;
			}*/
			if (s.charAt(i) == '(')
				lPara.push(i);
			else if (s.charAt(i) == ')') {
				if (lPara.isEmpty()) {
					if (hasLPara) {
						rst.append(s.substring(curPos, i));
						curPos = i + 1;
					}
					else {
						s = s.substring(i + 1);
						i = 0;
						continue;
					}
				}
				else {
					lPara.pop();
					if (lPara.isEmpty())
						rst.append(s.substring(0, i + 1));
				}
			}
			i++;
		}
		if (!lPara.isEmpty()) {
			rst.append(s.substring(curPos, i));
			while (!lPara.isEmpty()) {
				lPara.pop();
				rst.append(')');
			}
		}
		return rst.toString();
	}
	 /**
	  * Eg - "(ab(xy)u2" -> "ab(xy)u2", ")))(((" -> ""
	  * @param s
	  * @return
	  */
	public static String balanceParatheses2(String s) {
		if (s == null || s.length() == 0)
			return s;
		//store the position of left paratheses
		Stack<Integer> lPara = new Stack<Integer> ();
		//check if there exists left paratheses
		StringBuilder rst = new StringBuilder();
		boolean hasLPara = false;
		int i = 0;
		int curPos = 0;
		while (i < s.length()) {
			/*if (s.charAt(i) != '(' && s.charAt(i) != ')') {
				i++;
				continue;
			}*/
			if (s.charAt(i) == '(')
				lPara.push(i);
			else if (s.charAt(i) == ')') {
				if (lPara.isEmpty()) {
					if (hasLPara) {
						rst.append(s.substring(curPos, i));
						curPos = i + 1;
					}
					else {
						s = s.substring(i + 1);
						i = 0;
						continue;
					}
				}
				else {
					lPara.pop();
					if (lPara.isEmpty())
						rst.append(s.substring(0, i + 1));
				}
			}
			i++;
		}
		//(c(b(xy)
		if (!lPara.isEmpty()) {
			while (!lPara.isEmpty()) {
				int pos = lPara.pop();
				s = s.substring(0, pos) + s.substring(pos + 1);
			}
			rst.append(s);
		}
		return rst.toString();
	}
	public static void main(String[] args) {
		System.out.println(balanceParatheses2("((("));
		System.out.println(balanceParatheses2(")))((("));
		System.out.println(balanceParatheses2("ab(xu2))"));
		System.out.println(balanceParatheses2("((ab(xx"));
		System.out.println(balanceParatheses2("((())"));

	}

}
