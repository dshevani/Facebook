package facebookCoding;

import java.util.Arrays;

public class RemoveZerosInArray {
	public static void moveZeros(int[] num) {
		if (num == null || num.length <= 1)
			return;
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0)
				num[count++] = num[i];
		}
		while (count < num.length){
			num[count++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] num = {0, 1, 0, 1, 0};
		moveZeros(num);
		System.out.println(Arrays.toString(num));

	}

}
