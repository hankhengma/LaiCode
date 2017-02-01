package reverseBinaryTreeUpsideDown;

// Given a binary tree where all the right nodes are leaf nodes, 
// flip it upside down and turn it into a tree with left leaf nodes
// as the root.

public class ReverseBinaryTreeUpsideDown {

	public TreeNode reverse(TreeNode root) {
		// base case
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = reverse(root.left);
		// it is wrong to do
		// newRoot.left = root
		// newRoot.right = root.right
		root.left.left = root;
		root.left.right = root.right;
		// don't forget the following two lines
		root.left = null;
		root.right = null;
		return newRoot;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
