package facebookCoding;

public class findLimitValues {
	public static int[] limit(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Wrong input!");
		int max = array[0];
		int min = array[0];
		int start = 0;
		if (array.length % 2 != 0)
			start = 1;
		for (int i = start; i < array.length - 1; i += 2) {
			if (array[i] < array[i + 1]) {
				max = Math.max(max, array[i + 1]);
				min = Math.min(min, array[i]);
			}
			else {
				max = Math.max(max, array[i]);
				min = Math.min(min, array[i + 1]);
			}
		}
		int[] limits = new int[2];
		limits[0] = min;
		limits[1] = max;
		return limits;
	}
	public static void main(String[] args) {
		int[] array = {9, 7, 6, 5, 1, 4, 8, 3};
		int[] limits = limit(array);
		System.out.println(limits[0] + "   " + limits[1]);
	}

}
