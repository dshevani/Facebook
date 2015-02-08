package facebookCoding;
/**
 * implement atof()
 * The function first discards as many whitespace characters (as in isspace) 
 * as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes as many characters as possible 
 * that are valid following a syntax resembling that of floating point literals (see below), 
 * and interprets them as a numerical value. 
 * The rest of the string after the last valid character is ignored 
 * and has no effect on the behavior of this function.
 * http://www.cplusplus.com/reference/cstdlib/atof/
 * valid examples: 
 * 3.
 * 3.4e+03
 * invalid examples:
 * e03
 * 1e
 * e.03
 * ..
 * if overflow
 * return infinity
 * @author shirleyyoung
 *
 */
public class Atof {
	public static float atof(String in) throws NumberFormatException{
		if (in == null)
			throw new NumberFormatException("Null String!");
		boolean isNegative = false;
		in = in.trim();
		if (in.length() == 0)
			throw new NumberFormatException("Empty string!");
	
		if (in.charAt(0) == '+' || in.charAt(0) == '-') {
			if (in.charAt(0) == '-')
				isNegative = true;
			in = in.substring(1);
		}
		//case that input is "NaN"
		if (in.charAt(0) == 'N') {
			char[] nan = {'N', 'a', 'N'};
			if (in.length() != nan.length)
				return 0.0f;
			for (int i = 0; i < nan.length; i++) {
				if (in.charAt(i) != nan[i])
					return 0.0f;
			}
			return (float)(Double.NaN);
		}
		//case that input is "infinity"
		if (in.charAt(0) == 'I') {
			char[] infinity = {'I', 'n', 'f', 'i', 'n', 'i', 't', 'y' };
			if (in.length() != infinity.length)
				return 0.0f;
			for (int i = 0; i < infinity.length; i++) {
				if (in.charAt(i) != infinity[i])
					return 0.0f;
			}
			return isNegative ? (float)(Double.NEGATIVE_INFINITY) : (float)(Double.POSITIVE_INFINITY);
		}
	
		//Discard leading zeros
		int indexZ = 0;
		while (indexZ < in.length() && in.charAt(indexZ) == '0') {
			indexZ++;
		}
		//System.out.println(indexZ);
		in = in.substring(indexZ);
		if (in.length() == 0)
			return 0.0f;
		//discard trailing non-digit characters, invalid if 'e' is the last character
		int notDigit = in.length() - 1;
		while (notDigit > 0 && in.charAt(notDigit)  != '.' && !Character.isDigit(in.charAt(notDigit))) {
			notDigit--;
		}
		if (notDigit == 0)
			return 0.0f;
		in = in.substring(0, notDigit + 1);
		//System.out.println("Before parsing: " + in);
		boolean dot = false;
		boolean exp = false;
		int expSignPos = -1;
		boolean isExpNegative = false;
		int dotPos = 0;
		int expPos = 0;
		//check if the string is valid, if any invalid character occurs, parse the valid prefix string
		for (int i = 0; i < in.length(); i++) {
			//System.out.println(in.charAt(i));
			if (Character.isDigit(in.charAt(i)))
				continue;
			//. must be before e
			else if (in.charAt(i) == '.') {
				if (exp || dot) {
					if (in.charAt(i - 1) == 'e' || in.charAt(i - 1) == 'E') {
						exp = false;
						in = in.substring(0, i - 1);
					}
					else
						in = in.substring(0, i);
					break;
				}
				dot = true;
				dotPos = i;
				//System.out.println("dotPos: " + dotPos);
			}
			else if (in.charAt(i) == 'e' || in.charAt(i) == 'E') {
				//e cannot be at the first position
				if (i == 0)
					return 0.0f;
				if (exp) {
					in = in.substring(0, i);
					break;
				}
				expPos = i;
				exp = true;
			}
			else if (in.charAt(i) == '+' || in.charAt(i) == '-') {
				if (i == 0 || (in.charAt(i - 1) != 'e' && in.charAt(i - 1) != 'E')) {
					in = in.substring(0, i);
					break;
				}
				if (in.charAt(i) == '-')
					isExpNegative = true;
				expSignPos = i;
			}
			else {
				in = in.substring(0, i);
				break;
			}
		}
		if (in.length() == 0 || in.equals("."))
			return 0.0f;
		float rst = 0.0f;
		if (dot) {
			if (!exp) {
				rst = parseDot(in, dotPos);
			}
			else {
				rst = parseDot(in.substring(0, expPos), dotPos);
				rst = parseExp(rst, in, expPos, expSignPos, isExpNegative);
			}
		}
		else if (exp) {
			float b4exp = (float)Integer.parseInt(in.substring(0, expPos));
			rst = parseExp(b4exp, in, expPos, expSignPos, isExpNegative);
		}
		else {
			rst = (float)Integer.parseInt(in);
		}
		return isNegative ? -rst : rst;
		
	}
	private static float parseDot(String in, int dotPos) {
		float rst;
		int b4dot = 0;
		if (dotPos != 0)
			b4dot = Integer.parseInt(in.substring(0, dotPos));
		if (dotPos == in.length() - 1)
			return (float)b4dot;
		float aftdot = (float)Integer.parseInt(in.substring(dotPos + 1));
		int pos = in.length() - dotPos - 1;
		while (pos > 0) {
			aftdot /= 10;
			pos--;
		}
		rst = (float)b4dot + aftdot;
		return rst;
		}
	private static float parseExp(float rst, String in, int expPos, int expSignPos, boolean isExpNegative) {
		//System.out.println(expPos);
		int pos = 0;
		if (expSignPos != -1) {
			pos = isExpNegative ? (-Integer.parseInt(in.substring(expSignPos + 1))) :
				(Integer.parseInt(in.substring(expSignPos + 1)));
		}
		else 
			pos = Integer.parseInt(in.substring(expPos + 1));
		if (pos < 0) {
			while (pos < 0) {
				rst /= 10;
				pos++;
			}
		}
		else if (pos > 0) {
			while (pos > 0) {
				rst *= 10;
				pos--;
				if ((long)rst >= (Long.MAX_VALUE / 10))
					return (float)Double.POSITIVE_INFINITY;
			}
		}
		return rst;
	}
	public static void main(String[] args) {
		System.out.println(atof("3.14f"));
		System.out.println(atof("3.14e+03"));
		System.out.println(atof("000314.5e-02dfgf"));
		System.out.println(atof("45346gfbfd.4"));
		System.out.println(atof("5643..23"));
		System.out.println(atof("5643.e03"));
		System.out.println(atof("5241e.03"));
		System.out.println(atof("09590004e.05"));
		System.out.println(atof("--4343"));
		System.out.println(atof("6v4v"));
		System.out.println(atof("-v6"));
		System.out.println(atof("+3.5e-2"));
		System.out.println(atof(".03e1"));
		System.out.println(atof("1e1"));
		System.out.println(atof("0.0"));
		System.out.println(atof("10E5"));
		

	}

}
