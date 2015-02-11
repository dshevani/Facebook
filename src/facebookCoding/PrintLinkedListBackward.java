package facebookCoding;
/**
 * Print a singly-linked list backwards, in constant space and linear time.
 * @author shirleyyoung
 *
 */
public class PrintLinkedListBackward {
	public static void printList(ListNode head) {
		if (head == null) {
			System.out.println ("Null list!");
			return;
		}
		if (head.next == null) {
			System.out.println(head.val);
			return;
		}
		head = reverse(head);
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		head = reverse(head);
	}
	private static ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
		
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		printList(n1);

	}

}
