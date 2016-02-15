package com.binaryTree;

public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}
	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode p = new TreeNode(num[mid]);
		p.left = sortedArrayToBST(num, start, mid - 1);
		p.right = sortedArrayToBST(num, mid + 1, end);
		return p;
	}
}
