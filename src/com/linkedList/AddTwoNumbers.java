package com.linkedList;

public class AddTwoNumbers {

	/*
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: (7 -> 0 -> 8)
	 * */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + carry;
			carry = val / 10;
			val = val % 10;
			p.next = new ListNode(val);
			p = p.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode l = (l1 != null) ? l1 : l2;
		while (carry != 0 && l != null) {
			int val = l.val + carry;
			carry = val / 10;
			val = val % 10;
			p.next = new ListNode(val);
			p = p.next;
			l = l.next;
		}
		p.next = (carry != 0) ? new ListNode(carry) : l;
		return head.next;
	}
}
