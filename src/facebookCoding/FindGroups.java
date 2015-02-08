package facebookCoding;
/**
 * Given a matrix with 1's and 0's, find the number of groups of 1's. 
 * A group is defined by horizontally/vertically adjacent 1's.
 * O(mn) ?
 * @author shirleyyoung
 *
 */
public class FindGroups {
	public static int numberOfGroups(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			throw new IllegalArgumentException("invalid input!");
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][]visited = new boolean[m][n];
		int countGroup = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 1 || visited[i][j]) {
					visited[i][j] = true;
					continue;
				}
				countGroup += (findGroup(matrix, visited, i, j) > 1) ? 1 : 0;
			}
		}
		return countGroup;
	}
	private static int findGroup(int[][] matrix, boolean[][] visited, int i, int j) {
		int count = 1;
		matrix[i][j] = -1;
		if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
			count += findGroup(matrix, visited, i, j + 1);
			visited[i][j + 1] = true;
		}
		if (j > 0 && matrix[i][j - 1] == 1) {
			count += findGroup(matrix, visited, i, j - 1);
			visited[i][j - 1] = true;
		}
		if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
			count += findGroup(matrix, visited, i + 1, j);
			visited[i + 1][j] = true;
		}
		if (i > 0 && matrix[i - 1][j] == 1) {
			count += findGroup(matrix, visited, i - 1, j);
			visited[i - 1][j] = true;
		}
		matrix[i][j] = 1;
		return count;
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[5][4];
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[0][3] = 1;
		matrix[1][0] = 1;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[1][3] = 1;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 0;
		matrix[2][3] = 0;
		matrix[3][0] = 1;
		matrix[3][1] = 0;
		matrix[3][2] = 1;
		matrix[3][3] = 1;
		matrix[4][0] = 1;
		matrix[4][1] = 0;
		matrix[4][2] = 0;
		matrix[4][3] = 1;
		printMatrix(matrix);
		System.out.println(numberOfGroups(matrix));
	}

}
