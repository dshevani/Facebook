package facebookCoding;

public class FindELementinBinaryTree {
	static int count = 0;
	public static int findElement(TreeNode root, int k) {
		if (root == null)
			return Integer.MIN_VALUE;
		int left = findElement(root.left, k);
		if (count == k)
			return left;
		if (++count == k)
			return root.val;
		return (findElement(root.right, k));
		
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(14);
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(7);
		TreeNode n9 = new TreeNode(13);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n5.left = n7;
		n5.right = n8;
		n6.left = n9;
		System.out.println(findElement(n1, 8));
	}

}
