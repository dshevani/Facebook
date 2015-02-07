package runningMedian;
/**
 * There is a stream of numbers, design an effective data structre to store 
 * the numbers and to return the median at any point of time. 
 * @author shirleyyoung
 *
 */
import java.util.*;
public class RunningMedian {
	//max heap
	PriorityQueue<Integer> leftQueue;
	//min heap
	PriorityQueue<Integer> rightQueue;
	
	public RunningMedian() {
		leftQueue = new PriorityQueue<Integer> (
				new Comparator<Integer> () {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		}
		);
		rightQueue = new PriorityQueue<Integer> ();
	}
	/**
	 * the number will be added to the rightQueue if the total numbers are even
	 * however, in order for all numbers in the leftQueue to be smaller than those
	 * in the rightQueue, we add n to the leftQueue first, then poll out the head 
	 * of the leftQueue, which is the maximum in the queue, then add it to the rightQueue
	 * if the total numbers are odd, the number will be added to the leftQueue
	 * @param n
	 */
	public void add(int n) {
		if (leftQueue.size() == rightQueue.size()) {
			if (rightQueue.size() == 0) {
				rightQueue.add(n);
			}
			else {
				leftQueue.add(n);
				int leftMax = leftQueue.poll();
				rightQueue.add(leftMax);
			}
		}
		else {
			if (rightQueue.peek() < n) {
				rightQueue.add(n);
				int rightMin = rightQueue.poll();
				leftQueue.add(rightMin);
			}
			else {
				leftQueue.add(n);
			}
		}
	}
	
	public double getMedian() {
		if (leftQueue.size() == 0 && rightQueue.size() == 0)
			throw new IllegalArgumentException("No elements!");
		if (leftQueue.size() == rightQueue.size()) {
			return (double)(leftQueue.peek() + rightQueue.peek()) / 2.0;
		}
		return (double)rightQueue.peek();
	}
}
