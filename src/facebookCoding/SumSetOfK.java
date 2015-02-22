package facebookCoding;
/**
 * Given a list of n objects, write a function that 
 * outputs the minimum set of numbers that sum to at least K. 
 * FOLLOW UP: can you beat O(n ln n)?
 * use heap or sort the array will take O(n log n)
 * use quick select method takes O(n)
 * @author shirleyyoung
 *
 */
import java.util.*;
public class SumSetOfK {
	public static List<Integer> minSet(int[] A, int k) {
		if (A == null || A.length == 0)
			throw new IllegalArgumentException("Null or empty array!");
		return getMinSet(A, 0, A.length - 1, k); 
	}
	private static List<Integer> getMinSet(int[] A, int start, int end, int k) {
		List<Integer> rst = new ArrayList<Integer> ();
		/*if (sum(A, start, end) < k)
			return rst;*/
		if (start > end ) {
			//System.out.println("start == end: " + start);
			return rst;
		}
		if (start == end) {
			if ( A[start] < k)
				return rst;
			else {
				rst.add(A[start]);
				return rst;
			}
		}
		int mid = (start + end) / 2;
		int pivot = A[mid];
		int i = start;
		int j = end;
		while (i <= j) {
			if (A[i] >= pivot) {
				swap(A, i, j);
				j--;
			}
			else 
				i++;	
		}
		/*System.out.println("***************");
		for (int in = start; in <= end; in++)
			System.out.print(A[in] + " ");
		System.out.println("");*/
		int rightSum = sum(A, mid + 1, end);
		//System.out.println("rightSum: " + rightSum);
		//System.out.println("k: " + k);
		if (rightSum == k) {
			for (int index = mid + 1; index <= end; index++)
				rst.add(A[index]);
			return rst;
		}
		if (rightSum > k) {
			rst = getMinSet(A, mid + 1, end, k);
			if (rst.size() > 0)
				return rst;
		}
		else if (rightSum < k) {
			rst = getMinSet(A, start, mid, k - rightSum);
			/*System.out.println("less than k:");
			for (int in : rst) {
				System.out.print(in + " ");
			}
			System.out.println("");*/
		}
		if (rst.size() == 0)
			return rst;
		for (int index = mid + 1; index <= end; index++)
			rst.add(A[index]);
		return rst;
	}
	private static int sum(int[] A, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += A[i];
			//System.out.println(sum);
		}
		return sum;
	}
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	public static void main(String[] args) {
		int[] A = {7, 1, 2, 4, 3, 6, 7, 5};
		int k = 34;
		List<Integer> minimumSet = minSet(A, k);
		for (int i : minimumSet) {
			System.out.print(i + " ");
		}
		System.out.println("");

	}

}
