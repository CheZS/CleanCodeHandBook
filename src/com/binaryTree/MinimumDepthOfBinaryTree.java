package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

	public int minDepth(TreeNode root) {
		/* depth-first traversal */
		if (root == null) return 0;
		if (root.left == null) return minDepth(root.right) + 1;
		if (root.right == null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
	
	public int minDepth2(TreeNode root) {
		/* breadth-first traversal */
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode rightMost = root;
		int depth = 1;
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			if (p.left == null && p.right == null) break;
			if (p.left != null) queue.add(p.left);
			if (p.right != null) queue.add(p.right);
			if (p == rightMost) {
				depth++;
				rightMost = (p.right != null) ? p.right : p.left;
			}
		}
		return depth;
	}
}
