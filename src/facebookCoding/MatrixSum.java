package facebookCoding;

public class MatrixSum {
	public static int matrixSum(int[][] matrix, int rstart, int rend, int cstart, int cend) {
		if (matrix == null || matrix.length == 0)
			throw new IllegalArgumentException("invalid input");
		int rows = rend - rstart + 1;
		int cols = cend - cstart + 1;
		int eles = rows * cols;
		int sum = 0;
		for (int i = 0; i < eles; i++) {
			sum += matrix[i / cols][i % cols];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1;
		matrix[0][1] = 3;
		matrix[0][2] = 7;
		matrix[0][3] = 9;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[1][3] = 7;
		matrix[2][0] = 8;
		matrix[2][1] = 9;
		matrix[2][2] = 2;
		matrix[2][3] = 3;
		System.out.println(matrixSum(matrix, 0, 1, 0, 2));

	}

}
