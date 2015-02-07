package facebookCoding;
import java.util.*;
public class CombinationSum {
	/*
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>> ();
        if (candidates == null || candidates.length == 0)
            return rst;
        Arrays.sort(candidates);
        if (target < candidates[0])
            return rst;
        findCombinations(candidates, target, rst, new ArrayList<Integer> (), 0);
        return rst;
    }
    private static void findCombinations(int[] candidates, int target, List<List<Integer>> rst, List<Integer> set, int start) {
        if (target == 0) {
            rst.add(new ArrayList<Integer> (set));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
        	if (candidates[i] > target)
        		break;
        	if (i != start && candidates[i] == candidates[i - 1])
        		continue;
            set.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], rst, set, i);
            set.remove(set.size() - 1);
        }
    }
    public static void main(String[] args) {
    	int[] candidates = {1, 2};
    	int target = 3;
    	List<List<Integer>> rst = combinationSum(candidates, target);
    	for (List<Integer> set : rst) {
    		System.out.println(set);
    	}
    }
}
