package facebookCoding;
/*
 * Given an integer, return all sequences of 
 * numbers that sum to it. (Example: 3 ->
(1, 2), (2, 1), (1, 1, 1))
 */
import java.util.*;
public class SumofSequences {
	public static List<List<Integer>> sequenceSum(int n) {
		List<List<Integer>> rst = new ArrayList<List<Integer>> ();
		if (n <= 1)
			return rst;
		getSequence(rst, new ArrayList<Integer> (), n, n);
		return rst;
		
	}
	private static void getSequence(List<List<Integer>> rst, List<Integer> num, int n, int residue) {
		if (residue < 0)
			return;
		if (residue == 0) {
			rst.add(new ArrayList<Integer> (num));
			return;
		}
		for (int i = 1; i < n; i++) {
			num.add(i);
			getSequence(rst, num, n, residue - i);
			num.remove(num.size() - 1);
		}
	}
	public static void main(String[] args) {
		List<List<Integer>> rst = sequenceSum(10);
		for (List<Integer> nums : rst) {
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}
}
