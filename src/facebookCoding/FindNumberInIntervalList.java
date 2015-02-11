package facebookCoding;


/**
 * Given a set of non-overlapping integer ranges (1,3) (5,8), etc., 
 * and an input integer, what is the best way to organize the data 
 * and allow for quick search based on the input, etc.
 * 
 * use interval tree
 * O(log(n))
 * @author shirleyyoung
 *
 */

public class FindNumberInIntervalList<V> {
	private class Node {
		Interval interval;
		V label;
		Node left, right;
		//max high of the subtree rooted by current node
		int max;
		Node (Interval interval, V label) {
			this.interval = interval;
			this.label = label;
			this.max = interval.high;
		}
	}
	private Node root;
	/**
	 * search if an interval is in the tree
	 * @param interval
	 * @return
	 */
	public boolean contains(Interval interval) {
		return get(root, interval) != null;
	}
	private V get(Node curr, Interval interval) {
		if (curr == null)
			return null;
		int comp = curr.interval.compareTo(interval);
		if (comp == 0) 
			return curr.label;
		else if (comp < 0) 
			return get(curr.right, interval);
		else
			return get(curr.left, interval);
		
	}
	/**
	 * insert interval into the tree
	 * @param interval
	 */
	public void add(Interval interval, V label) {
		if (contains(interval)) {
			System.out.println("interval exists!");
			return;
		}
		//System.out.println(label);
		root = addNode(root, interval, label);
	}
	
	private Node addNode(Node curr, Interval interval, V label) {
		if (curr == null)
			return new Node(interval, label);
		int comp = curr.interval.compareTo(interval);
		if (comp < 0)
			curr.right = addNode(curr.right, interval, label);
		else
			curr.left = addNode(curr.left, interval, label);
		fix(curr);
		return curr;
	}
	/**
	 * search given number
	 * @param num
	 * @return an interval
	 */
	public Interval search(int num) {
		return searchInterval(root, num);
	}
	private Interval searchInterval(Node curr, int num) {
		if (curr == null || curr.max < num)
			return new Interval(-1, -1);
		if (curr.interval.low <= num && curr.interval.high >= num)
			return curr.interval;
		else if (curr.left != null && curr.left.max >= num)
			return searchInterval(curr.left, num);
		else 
			return searchInterval(curr.right, num);
	}
	
	/**
	 * fix the max
	 * @param curr
	 */
	private void fix(Node curr) {
		curr.max = Math.max(curr.interval.high, Math.max(max(curr.left), max(curr.right)));
	}
	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		return node.max;
	}
	

	public static void main(String[] args) {
		FindNumberInIntervalList<Integer> ffil = new FindNumberInIntervalList<Integer> ();
		
		ffil.add(new Interval(1, 3), 0);
		ffil.add(new Interval(5, 8), 1);
		ffil.add(new Interval(9, 10), 2);
		ffil.add(new Interval(11, 15), 3);
		ffil.add(new Interval(17, 19), 4);
		ffil.add(new Interval(20, 23), 5);
		ffil.add(new Interval(24, 27), 6);
		ffil.add(new Interval(30, 31), 7);
		ffil.add(new Interval(34, 37), 8);
		ffil.add(new Interval(41, 45), 9);
		
		System.out.println(ffil.search(46).toString());
		
		

	}

}
