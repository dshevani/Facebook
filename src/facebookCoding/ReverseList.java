package facebookCoding;



public class ReverseList {
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null;
		ListNode newHead = head;
		while (newHead.next != null) {
			ListNode tmp = newHead.next;
			newHead.next = prev;
			prev = newHead;
			newHead = tmp;
		}
		newHead.next = prev;
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
		printList(reverseList(n1));
		
	}
}
