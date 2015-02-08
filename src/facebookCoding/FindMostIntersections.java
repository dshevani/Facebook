package facebookCoding;
/**
 * Giving lots of intervals [ai, bi], 
 * find a point intersect with the most number of intervals
 * http://shirleyisnotageek.blogspot.com/2015/02/find-interval-that-intersects-with-most.html
 * @author shirleyyoung
 *
 */
import java.util.*;
public class FindMostIntersections {
	public static Interval mostIntersections(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			throw new IllegalArgumentException("Invalid input");
		Map<Integer, Integer> start = new HashMap<Integer, Integer> ();
		Map<Integer, Integer> end = new HashMap<Integer, Integer> ();
		int[]track = new int[intervals.size() * 2];
		int index = 0;
		for (Interval in : intervals) {
			if (!start.containsKey(in.low)) 
				start.put(in.low, 1);
			else 
				start.put(in.low, start.get(in.low) + 1);
			if (!end.containsKey(in.high))
				end.put(in.high, 1);
			else
				end.put(in.high, end.get(in.high) + 1);
			track[index++] = in.low;
			track[index++] = in.high;
		}
		
		int count = 0;
		int maxCount = 0;
		index = 0;
		Arrays.sort(track);
		for (int i = 0; i < track.length; i++) {
			if (start.containsKey(track[i])) {
				count++;
				if (maxCount < count) {
					maxCount = count;
					index = i;
				}
				start.put(track[i], start.get(track[i]) - 1);
				if (start.get(track[i]) == 0)
					start.remove(track[i]);
			}
			else {
				count--;
				end.put(track[i], end.get(track[i]) - 1);
				if (end.get(track[i]) == 0)
					end.remove(track[i]);
			}
		}
		return new Interval(track[index], track[index + 1]);
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval> ();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(7, 8));
		System.out.println(mostIntersections(intervals).toString());

	}

}
