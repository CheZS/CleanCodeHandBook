package com.binaryTree;

import com.linkedList.ListNode;

public class SortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
		int len = 0;
		p = head;
		while (p != null) {
			p = p.next;
			len++;
		}
		p = head;
		return sortedListToBST(0, len - 1);
	}
	private TreeNode sortedListToBST(int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(p.val);
		p = p.next;
		TreeNode right = sortedListToBST(mid + 1, end);
		parent.left = left;
		parent.right = right;
		return parent;
	}
	
	private ListNode p;
}
