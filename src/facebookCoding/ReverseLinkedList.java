package facebookCoding;

public class ReverseLinkedList {
	public static ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
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
		n1.next = n2;
		n2.next = n3;
		printList(n1);
		printList(reverseLinkedList(n1));
		
	}

}
