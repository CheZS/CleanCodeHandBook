package com.binaryTree;

public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		return depth(root, 0);
	}
	
	private int depth(TreeNode p, int dep) {
		if (p == null) return dep;
		return Math.max(depth(p.left, dep + 1), depth(p.right, dep + 1));
	}
	
	public int maxDepth2(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
	}
}
