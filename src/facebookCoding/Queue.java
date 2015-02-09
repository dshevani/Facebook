package facebookCoding;
/**
 * Implement a queue with only a stack implementation
 * use two stack
 * @author shirleyyoung
 *
 */
import java.util.*;
public class Queue<E> {
	private Stack<E> in;
	private Stack<E> out;
	public Queue () {
		in = new Stack<E>();
		out = new Stack<E> ();
	}
	public void add(E ele) {
		in.push(ele);
	}
	public E poll() {
		if (out.isEmpty()) {
			while (!in.isEmpty())
				out.push(in.pop());
		}
		if (out.isEmpty())
			throw new NullPointerException("No element left!");
		return out.pop();
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.poll());
		q.add(4);
		System.out.println(q.poll());
		System.out.println(q.poll());
		q.add(5);
		System.out.println(q.poll());
		q.add(6);
		System.out.println(q.poll());
		System.out.println(q.poll());
		//System.out.println(q.poll());
	}

}
