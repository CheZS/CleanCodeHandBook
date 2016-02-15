package com.binaryTree;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean isValidBST(TreeNode p, long low, long high) {
		if (p == null) return true;
		if (p.val < low || p.val > high) return false;
		boolean isLeftValid = isValidBST(p.left, low, p.val);
		boolean isRightValid = isValidBST(p.right, p.val, high);
		return isLeftValid && isRightValid;
	}
	
	private TreeNode prev;
	public boolean isValidBST2(TreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}
	private boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null) return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.val <= prev.val) return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}
}
