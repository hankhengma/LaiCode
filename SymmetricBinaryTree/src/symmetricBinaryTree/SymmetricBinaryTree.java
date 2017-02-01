package symmetricBinaryTree;

import java.util.*;

// Check if a given binary tree is symmetric.

public class SymmetricBinaryTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		// base case
		if (left == null || right == null) {
			return left == right;
		}
		if (left.key != right.key) {
			return false;
		}
		// left != null && right != null
		return helper(left.left, right.right) && helper(left.right, right.left);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.

	// tail recursion, can be converted to a recursive solution
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		// root != null
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root.right);
		stack.offerFirst(root.left);
		while (!stack.isEmpty()) {
			TreeNode left = stack.pollFirst();
			TreeNode right = stack.pollFirst();
			if (left == null || right == null) {
				if (left != right) {
					return false;
				}
			} else { // left != null && right != null
				if (left.key != right.key) {
					return false;
				} else {
					stack.offerFirst(right.right);
					stack.offerFirst(left.left);
					stack.offerFirst(right.left);
					stack.offerFirst(left.right);
				}
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
