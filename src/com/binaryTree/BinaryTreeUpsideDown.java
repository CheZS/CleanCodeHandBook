package com.binaryTree;

public class BinaryTreeUpsideDown {

	/* 
	 * Given a binary tree where all the right nodes are either leaf nodes 
	 * with a sibling (a left node that shares the same parent node) 
	 * or empty, 
	 * flip it upside down and turn it into a tree 
	 * where the original right nodes turned into left leaf nodes.
	 * Return the new root.
	 */
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		return upsideDown(root, null);
	}
	private TreeNode upsideDown(TreeNode p, TreeNode parent) {
		if (p == null) return parent;
		TreeNode root = upsideDown(p.left, p);
		p.left = (parent == null) ? parent : parent.right;
		p.right = parent;
		return root;
	}
	
	public TreeNode upsideDownBinaryTree2(TreeNode root) {
		TreeNode p = root, parent = null, parentRight = null;
		while (p != null) {
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}
}
