package facebookCoding;
/*
 * Write a function that finds the minimum 
 * and maximum values   within an unsorted array using divide-and-conquer. 
 */
public class FindMaxMiNByDivideNConquer {
	public static int[] maxNMin(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or empty array!");
		return findLimits(array, 0, array.length - 1);
	}
	private static int[] findLimits(int[] array, int start, int end) {
		int[] limits = new int[2];
		if (end - start <= 0) {
			limits[0] = array[start];
			limits[1] = array[start];
			return limits;
		}
		if (end - start == 1) {
			if (array[start] < array[end]) {
				limits[0] = array[start];
				limits[1] = array[end];
			}
			else {
				limits[0] = array[end];
				limits[1] = array[start];
			}
			return limits;
		}
		int mid = (start + end) / 2;
		int[] leftLimits = findLimits(array, start, mid);
		int[] rightLimits = findLimits(array, mid + 1, end);
		if (leftLimits[0] < rightLimits[0])
			limits[0] = leftLimits[0];
		else
			limits[0] = rightLimits[0];
		if (leftLimits[1] > rightLimits[1])
			limits[1] = leftLimits[1];
		else
			limits[1] = rightLimits[1];
		return limits;	
	}
	public static void main(String[] args) {
		int[] array = {Integer.MAX_VALUE, 9, 7, 8, 4, 5, 1, 10};
		int[] limits = maxNMin(array);
		System.out.println(limits[0] + "  " + limits[1]);
	}
}
