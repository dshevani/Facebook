package facebookCoding;

public class IsomorphicTrees {
	public static boolean isIsomorphicTrees (TreeNode n1, TreeNode n2) {
		if (n1 == null)
			return n2 == null;
		if (n2 == null)
			return n1 == null;
		if (n1.val != n2.val)
			return false;
		if (isIsomorphicTrees(n1.left, n2.left) && isIsomorphicTrees(n1.right, n2.right))
			return true;
		return (isIsomorphicTrees(n1.left, n2.right) && isIsomorphicTrees(n1.right, n2.left));
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n5.left = n7;
		n5.right = n8;
		TreeNode n11 = new TreeNode(1);
		TreeNode n12 = new TreeNode(2);
		TreeNode n13 = new TreeNode(3);
		TreeNode n14 = new TreeNode(4);
		TreeNode n15 = new TreeNode(5);
		TreeNode n16 = new TreeNode(6);
		TreeNode n17 = new TreeNode(7);
		TreeNode n18 = new TreeNode(8);
		n11.left = n13;
		n11.right = n12;
		n12.left = n14;
		n12.right = n15;
		n13.right = n16;
		n15.left = n18;
		n15.right = n17;
		
		System.out.println(isIsomorphicTrees(n1, n11));
	}
}
