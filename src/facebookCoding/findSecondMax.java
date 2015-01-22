package facebookCoding;
/*
 * Given an unsorted array, extract 
 * the second max/min using the least number of
comparison (n+logn-2 using tournament, pairwise comparison )
 */

public class findSecondMax {
	public static int secondMax(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or empty array");
		int[][]tree = reverseTree(array);
		int secondMax = Integer.MIN_VALUE;
		int max = tree[tree.length - 1][0];
		int rootPos = 0;
		for (int i = tree.length - 2; i >= 0; i--) {
			rootPos = tree[i][rootPos * 2] == max ? rootPos * 2 : (rootPos * 2 + 1);
			if (i < tree.length - 2 && rootPos == tree[i].length - 1)
				continue;
			if (rootPos % 2 == 0) {
				secondMax = Math.max(secondMax, tree[i][rootPos + 1]);
			}
			else 
				secondMax = Math.max(secondMax, tree[i][rootPos - 1]);
		}
		return secondMax;
	}
	private static int[][] reverseTree(int[] array) {
		int depth = (int)Math.ceil((double)Math.log((double)array.length)/Math.log(2.0)) + 1;
		int[][] tree = new int[depth][];
		tree[0] = array;
		for (int i = 1; i < depth; i++) {
			tree[i] = getRow(tree[i - 1]);
		}
		return tree;
	}
	private static int[] getRow(int[] lastRow) {
		int length = (lastRow.length % 2 == 0) ? (lastRow.length/ 2) : (lastRow.length / 2 + 1); 
		int[] currRow = new int[length];
		int index = 0;
		for (int i = 0; i < lastRow.length - 1; i += 2) {
			if (lastRow[i] < lastRow[i + 1])
				currRow[index] = lastRow[i + 1];
			else
				currRow[index] = lastRow[i];
			index++;
		}
		if (index < currRow.length) {
			currRow[index] = lastRow[lastRow.length - 1];
		}
		return currRow;
	}
	public static void main(String[] args) {
		int[] array = {13, 29, 7, 8, 4, 5, 1, 10, 7, 39};
		System.out.println(secondMax(array));
	}

}
