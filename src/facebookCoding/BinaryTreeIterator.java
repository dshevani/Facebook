package facebookCoding;


/**
 * write an iterator function that returns next node in inorder traversal sequence in
binary trees.
See LeetCode BST iterator
 * @author shirleyyoung
 *
 */
import java.util.*;
public class BinaryTreeIterator {
	private static Stack<TreeNode> stack;
	public BinaryTreeIterator(TreeNode root) {
		stack = new Stack<TreeNode> ();
		pushNode(root);
	}
	private void pushNode(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	public int next() {
		if (stack.isEmpty()) {
			throw new Error("All nodes have been visited!");
		}
		TreeNode curr = stack.pop();
		pushNode(curr.right);
		return curr.val;
	}
	

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		TreeNode n3 = new TreeNode(25);
		n2.left = n3;
		TreeNode n4 = new TreeNode(4);
		n3.left = n4;
		TreeNode n5 = new TreeNode(5);
		n3.right = n5;
		TreeNode n6 = new TreeNode(6);
		n2.right = n6;
		TreeNode n7 = new TreeNode(7);
		n6.right = n7;
		TreeNode n8 = new TreeNode(8);
		n1.right = n8;
		TreeNode n9 = new TreeNode(9);
		n8.left = n9;
		TreeNode n10 = new TreeNode(14);
		n9.left = n10;
		TreeNode n11 = new TreeNode(11);
		n8.right = n11;
		TreeNode n12 = new TreeNode(12);
		n11.left = n12;
		TreeNode n13 = new TreeNode(13);
		n11.right = n13;
		BinaryTreeIterator bti = new BinaryTreeIterator(n1);
		while (bti.hasNext()) {
			System.out.println(bti.next());
		}
	}

}
