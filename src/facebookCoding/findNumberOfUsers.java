package facebookCoding;
/**
 * A period of time where users login and logout, given a sets of login and logout 
 * time pairs, write a function that can show the number of users online at any given time
 * @author shirleyyoung
 *
 * @param <V>
 */

public class findNumberOfUsers<V> {
	private static class LogTime implements Comparable<LogTime>{
		int start;
		int end;
		LogTime(int start, int end) {
			if (end < start)
				throw new IllegalArgumentException("Illegal input time interval");
			this.start = start;
			this.end = end;
		}
		public boolean contains(int time) {
			return start <= time && end >= time;
		}
		public int compareTo(LogTime timeInterval) {
			if (start < timeInterval.start)
				return -1;
			else if (start > timeInterval.start)
				return 1;
			else if (end < timeInterval.end)
				return -1;
			else if (end > timeInterval.end)
				return 1;
			else
				return 0;
		}
		public String toString() {
			return "[" + String.valueOf(start) + ", " + String.valueOf(end) + "]";
		}
	}
	
	private class Node {
		LogTime timeInt;
		V label;
		Node left, right;
		//int N;
		int max;
		Node (LogTime time, V label) {
			timeInt = time;
			this.label = label;
			this.max = time.end;
		}	
	}
	private Node root;
	
	/************************
	 * find a LogTime
	 ***********************/
	public boolean contains(LogTime time) {
		return get(time) != null;
	}
	public V get(LogTime time) {
		return get(root, time);
	}
	private V get(Node node, LogTime time) {
		if (node == null)
			return null;
		int cmp = time.compareTo(node.timeInt);
		if (cmp == 0)
			return node.label;
		else if (cmp < 0) {
			return get(node.left, time);
		}
		else {
			return get(node.right, time);
		}
	}
	
	/************************
	 * insertion
	 ***********************/
	public void put(LogTime time, V label) {
		if (contains(time)) {
			System.out.println("Node exists!");
			return;
		}
		root = insert(root, time, label);
	}
	private Node insert(Node node, LogTime time, V label) {
		if (node == null) {
			return new Node(time, label);
		}
		int cmp = time.compareTo(node.timeInt);
		if (cmp < 0) 
			 node.left = insert(node.left, time, label);
		else 
			node.right = insert(node.right, time, label);
		fix(node);
		return node;
	}
	private void fix(Node node) {
		if (node == null)
			return;
		node.max = max3(node.timeInt.end, max(node.left), max(node.right));
	}
	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		return node.max;
	}
	private int max3(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
	
	/**
	 * given a time t, return number of users online
	 * @param t
	 * @return
	 */
	
	public int search(int t) {
		return search(root, t);
	}
	
	private int search(Node node, int t) {
		if (node == null)
			return 0;
		int left = 0;
		int right = 0;
		int ro = 0;
		if (node.timeInt.contains(t))
			ro = 1;
		if (node.left != null && t < node.left.max)
			left = search(node.left, t);
		if (node.right != null && t <node.right.max)
			right = search(node.right, t);
		return left + right + ro;
	}

	public static void main(String[] args) {
		int N = 10;
		findNumberOfUsers<String> fu = new findNumberOfUsers<String> ();
		for (int i = 0; i < N; i++) {
			int start = (int) (Math.random() * 100);
			int end = (int)(Math.random() * 50) + start;
			LogTime time = new LogTime(start, end);
			System.out.println(time.toString());
			fu.put(time, String.valueOf(i));
		}
		
		System.out.println(fu.search(79));
		
	}

}
