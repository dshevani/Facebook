package facebookCoding;
/**
 * Given n+1 buckets with n of them with ball inside and move(a,b) function, that 
 * moves ball from bucket a to bucket b. Each ball has a different number from [1,n] on 
 * it. Move balls, so each bucket has a ball with matching number in it.
 * 
 * The empty bucket is represented by -1
 * @author shirleyyoung
 *
 */
public class MoveBalls {
	public static void moveBalls(int[] buckets) {
		if (buckets == null || buckets.length == 0)
			return;
		int empty = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == -1) {
				empty = i;
				break;
			}
		}
		for (int i = 0; i < buckets.length; i++) {
			while (buckets[i] != i) {
				swap(buckets, i, buckets[i], empty);
				//call move when the ball has a number that corresponds to the empty bucket
				if (buckets[buckets[i]] == -1)
					move(buckets, i, empty);
				if (buckets[i] == -1) {
					empty = i;
					break;
				}
			}
		}
	}
	private static void swap(int[] buckets, int i, int j, int empty) {
		int tmp = empty;
		move(buckets, i, empty);
		empty = i;
		move(buckets, j, empty);
		empty = j;
		move(buckets, tmp, empty);
		empty = tmp;
		
	}
	/**
	 * move method is a swap method for simplicity
	 * moves the ball to the empty bucket
	 * @param buckets
	 * @param i
	 * @param index
	 */
	private static void move(int[] buckets, int i, int empty) {
		int tmp = buckets[i];
		buckets[i] = buckets[empty];
		buckets[empty] = tmp;
	}

	public static void main(String[] args) {
		int[] buckets = {3, 1, 0, 5, 6, 8, 7, -1, 4};
		moveBalls(buckets);
		for (int i : buckets) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
