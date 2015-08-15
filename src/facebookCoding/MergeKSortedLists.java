package facebookCoding;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode> ();
        for (ListNode n : lists){
        	if (n != null)
        		pq.add(n);
        }
        ListNode head = new ListNode(-1);
        ListNode h = head;
        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            head.next = n;
            head = head.next;
            if (n.next != null)
                pq.add(n.next);
        }
        return h.next;
    }
	
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[1];
		lists[0] = null;

	}

}
