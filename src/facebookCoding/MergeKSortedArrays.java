package facebookCoding;
/**
 * Merge 'k' sorted arrays, each array may have max 'n' elements
 * @author shirleyyoung
 *
 */
import java.util.*;
public class MergeKSortedArrays {
	private static class Position {
		//the position of the array in the list
		int listPos;
		//the index of current element
		int index;
		//the element
		int element;
		public Position(int listPos, int index, int element) {
			this.listPos = listPos;
			this.index = index;
			this.element = element;
		}
	}
	public static List<Integer> mergeArrays(List<int[]> arrays) {
		if (arrays == null || arrays.size() == 0) {
			throw new IllegalArgumentException("Invalid input!");
		}
		PriorityQueue<Position> pq = new PriorityQueue<Position> (new Comparator<Position>() {
			public int compare(Position a, Position b) {
				if (a.element - b.element < 0) 
					return -1;
				else if (a.element - b.element > 0)
					return 1;
				else if (a.listPos - b.listPos < 0)
					return -1;
				else if (a.listPos - b.listPos > 0)
					return 1;
				else if (a.index - b.index < 0)
					return -1;
				else if (a.index - b.index > 0)
					return 1;
				else
					return 0;
			}
		});
		
		for (int i = 0; i < arrays.size(); i++) {
			pq.add(new Position(i, 0, arrays.get(i)[0]));
		}
		List<Integer> rst = new ArrayList<Integer> ();
		while (!pq.isEmpty()) {
			Position curr = pq.poll();
			rst.add(curr.element);	
			if (curr.index < arrays.get(curr.listPos).length - 1) {
				int nextIndex = curr.index + 1;
				int next = arrays.get(curr.listPos)[nextIndex];
				pq.add(new Position(curr.listPos, nextIndex, next));	
			}
		}
		return rst;
	}

	public static void main(String[] args) {
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
		List<Integer> rst = mergeArrays(arrays);
		for (Integer i : rst) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
