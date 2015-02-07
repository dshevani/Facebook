package facebookCoding;
/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * This solution is accepted on LeetCode.
 */
public class FindMedian {
	public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null)
            throw new IllegalArgumentException("Invalid input!");
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 != 0) {
            return (double)findKth(A, 0, B, 0, (m + n) / 2 + 1);
        }
        else {
            int first = findKth(A, 0, B, 0, (m + n) / 2);
            int second = findKth(A, 0, B, 0, (m + n) / 2 + 1);
            return (double) (first + second) / 2.0;
        }
        
    }
    private int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length)
            return B[B_start + k - 1];
        if (B_start >= B.length)
            return A[A_start + k - 1];
        if (k == 1)
            return Math.min(A[A_start], B[B_start]);
        int index_A = A_start + k / 2 - 1;
        int index_B = B_start + k / 2 - 1;
        int A_i = index_A >= A.length ? Integer.MAX_VALUE : A[index_A];
        int B_j = index_B >= B.length ? Integer.MAX_VALUE : B[index_B];
        if (A_i < B_j)
            return findKth(A, index_A + 1, B, B_start, k - k / 2);
        return findKth(A, A_start, B, index_B + 1, k - k / 2);
    }

}
