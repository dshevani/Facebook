package facebookCoding;
import java.util.*;
public class Permutations {
	public static List<List<Integer>> permutations(int[] arrays) {
		if (arrays == null || arrays.length == 0)
			throw new IllegalArgumentException("invalid input!");
		Arrays.sort(arrays);
		List<List<Integer>> perms = new ArrayList<List<Integer>> ();
		getPermutations(arrays, perms, new ArrayList<Integer> ());
		return perms;
	}
	public static void getPermutations(int[] arrays, List<List<Integer>> perms, List<Integer> nums) {
		if (nums.size() == arrays.length) {
			perms.add(new ArrayList<Integer> (nums));
			return;
		}
		for (int i = 0; i < arrays.length; i++) {
			if (nums.contains(arrays[i]))
				continue;
			nums.add(arrays[i]);
			getPermutations(arrays, perms, nums);
			nums.remove(nums.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] arrays = {1, 2, 3};
		for (List<Integer> nums : permutations(arrays)) {
			System.out.println(Arrays.toString(nums.toArray()));
		}

	}

}
