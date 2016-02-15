package com.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLinkedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, listComparator);
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		return dummy.next;
	}
	
	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		int begin = 0;
		int end = lists.length - 1;
		while (end > 0) {
			begin = 0;
			while (begin < end) {
				lists[begin] = mergeTwoLists(lists[begin], lists[end]);
				begin++;
				end--;
			}
		}
		return lists[0];
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		p.next = (l1 != null) ? l1 : l2;
		return dummy.next;
	}
}
