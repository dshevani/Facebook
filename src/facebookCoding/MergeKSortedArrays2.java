package facebookCoding;

import java.util.*;
public class MergeKSortedArrays2 {
	public static List<Integer> merged (List<int[]> arrays){
		List<Integer> mergedArrays = new ArrayList<Integer> ();
		if (arrays == null || arrays.size() == 0){
			return mergedArrays;
		}
		for (int[] array : arrays){
			for (int i : array)
				mergedArrays.add(i);
		}
		Collections.sort(mergedArrays);
		return mergedArrays;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> arrays = new ArrayList<int[]> ();
		int[] a = {1, 3, 5, 7, 10};
		int[] b = {2, 4, 6, 8};
		int[] c = {9, 12, 15};
		int[] d = {11, 13, 14, 16, 17};
		int[] e = {11, 12, 13, 14, 15};
		arrays.add(a);
		arrays.add(b);
		arrays.add(c);
		arrays.add(d);
		arrays.add(e);
		
		//System.out.println(arrays.size());
		List<Integer> rst = merged(arrays);
		for (Integer i : rst) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
