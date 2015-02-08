package facebookCoding;
/**
 * Interweave a linked list. Do it in Linear time and constant space. 
 * Input: A->B->C->D->E Output: A->E->B->D->C
 * (definition: interweave means head and tail two pointers, 
 * write head and tail and then move next for head pointer, 
 * and move back for tail pointer, and then write head
 * and tail until only one or no more elements left
 * @author shirleyyoung
 *
 */

public class InterweaveLinkedList {
	public static ListNode interweaveList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = findMiddle(head);
		ListNode head2 = mid.next;
		mid.next = null;
		head2 = reverseList(head2);
		return merge(head, head2);
		
	}
	private static ListNode findMiddle (ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	private static ListNode reverseList(ListNode head) {
		ListNode tail = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = tail;
			tail = head;
			head = tmp;
		}
		return tail;
	}
	private static ListNode merge(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		int count = 0;
		while (n1 != null && n2 != null) {
			if (count % 2 == 0) {
				node.next = n1;
				n1 = n1.next;
			}
			else {
				node.next = n2;
				n2 = n2.next;
			}
			node = node.next;
			count++;
		}
		if (n1 != null) 
			node.next = n1;
		if (n2 != null)
			node.next = n2;
		return dummy.next;
	}
	public static void printList(ListNode head)
	{
		if (head == null)
			return;
		
		ListNode curr = head;
		while(curr != null)
		{
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		printList(n1);
		printList(interweaveList(n1));

	}

}
