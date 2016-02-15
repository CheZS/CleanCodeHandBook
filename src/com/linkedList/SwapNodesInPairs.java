package com.linkedList;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode prev = dummy;
		while (p != null && p.next != null) {
			ListNode q = p.next;
			ListNode r = p.next.next;
			prev.next = q;
			p.next = r;
			q.next = p;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
}
