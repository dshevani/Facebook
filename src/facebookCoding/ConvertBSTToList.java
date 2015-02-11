package facebookCoding;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBSTToList {
	public static TreeNode convertBSTtoList(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = convertBSTtoList(root.left);
		TreeNode right = convertBSTtoList(root.right);
		root.left = root;
		root.right = root;
		left = connectList(left, root);
		right = connectList(left, right);
		return left;
	}
	private static TreeNode connectList(TreeNode n1, TreeNode n2) {
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		TreeNode tail1 = n1.left;
		TreeNode tail2 = n2.left;
		tail1.right = n2;
		n2.left = tail1;
		n1.left = tail2;
		tail2.right = n1;
		return n1;
	}
	
	private static void printList(TreeNode n1) {
		TreeNode head = n1;
		System.out.print(head.val + " ");
		head = head.right;
		while (head != n1) {
			System.out.print(head.val + " ");
			head = head.right;
		}
		System.out.println();
	}
	public static void printTree (TreeNode root)
	{
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode> ();
		queue.offer(root);
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				TreeNode head = queue.poll();
				System.out.print(head.val + " ");
				if(head.left != null)
					queue.offer(head.left);
				if(head.right != null)
					queue.offer(head.right);
			}
			System.out.println("");
			
		}
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		printTree(n1);
		n1 = convertBSTtoList(n1);
		printList(n1);
	}

}
