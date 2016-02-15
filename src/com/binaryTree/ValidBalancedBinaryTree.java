package com.binaryTree;

public class ValidBalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		return depth(root) != -1;
	}
	private int depth(TreeNode p) {
		if (p == null) return 0;
		int leftDepth = depth(p.left);
		if (leftDepth == -1) return -1;
		int rightDepth = depth(p.right);
		if (rightDepth == -1) return -1;
		return (Math.abs(leftDepth - rightDepth) <= 1) ? (Math.max(leftDepth, rightDepth) + 1) : -1;
	}
}
