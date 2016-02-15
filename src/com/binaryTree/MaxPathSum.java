package com.binaryTree;

public class MaxPathSum {

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMax(root);
		return maxSum;
	}
	private int findMax(TreeNode p) {
		if (p == null) return 0;
		int left = findMax(p.left);
		int right = findMax(p.right);
		maxSum = Math.max(maxSum, p.val + left + right);
		int ret = p.val + Math.max(left, right);
		return (ret > 0) ? ret : 0;
	}
	private int maxSum;
}
