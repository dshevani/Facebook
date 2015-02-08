package facebookCoding;
/**
 * Intersection of n sets without using a hash table
 * Complexity: O(n + m * n)
 * n: size of the list
 * m: the size of the set with the least elements in the list
 * @author shirleyyoung
 *
 */
import java.util.*;
public class IntersectionOfNSets {
	public static List<Integer> intesections(List<Set<Integer>> sets) {
		if (sets == null || sets.size() == 0)
			throw new IllegalArgumentException("Invalid input!");
		List<Integer> rst = new ArrayList<Integer> ();
		int minSize = Integer.MAX_VALUE;
		Set<Integer> minSet = null;
		for (Set<Integer> s : sets) {
			if (minSize > s.size()) {
				minSize = s.size();
				minSet = s;
			}
		}
		//O(minSize * n)
		//n: size of sets
		for (Integer i : minSet) {
			int count = 0;
			for (Set<Integer> set : sets) {
				if (set.contains(i))
					count++;
			}
			if (count == sets.size())
				rst.add(i);
		}
		return rst;
	}
	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet<Integer> ();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		Set<Integer> s2 = new HashSet<Integer> ();
		s2.add(6);
		s2.add(2);
		s2.add(3);
		s2.add(4);
		s2.add(5);
		Set<Integer> s3 = new HashSet<Integer> ();
		s3.add(6);
		s3.add(7);
		s3.add(3);
		s3.add(4);
		s3.add(5);
		List<Set<Integer>> sets = new ArrayList<Set<Integer>> ();
		sets.add(s1);
		sets.add(s2);
		sets.add(s3);
		for (Integer i : intesections(sets)) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
}
