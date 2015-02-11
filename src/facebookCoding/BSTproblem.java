
package facebookCoding;



import java.util.LinkedList;
import java.util.Queue;

public class BSTproblem {
	
	public static void reverseBST (TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		reverseBST(root.right);
		reverseBST(root.left);
	}
	static int count = 0;
	/**
	 * O(n) complexity
	 * @param root
	 * @param k
	 * @return
	 */
	public static int kthLargest(Tree root, int k) {
		if (root == null)
			return -1;
		return findKth(root.node, k).val;
		
	}
	private static TreeNode findKth (TreeNode root, int k) {
		if (root == null)
			return root;
		TreeNode right = findKth(root.right, k);
		if (count == k)
			return right;
		++count;
		if (count == k)
			return root;
		return findKth(root.left, k);
	}
	/**
	 * O(log n) complexity
	 * @param root
	 * @param k
	 * @return
	 */
    public static TreeNode findKth(Tree root, int k) {
    	if (root.right.size() == k - 1)
    		return root.node;
    	else if (root.right.size() < k - 1)
    		return findKth(root.left, k - root.right.size() - 1);
    	else
    		return findKth(root.right, k);
		
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
		/*TreeNode n1 = new TreeNode(8);
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
		//printTree(n1);
		System.out.println(kthLargest(n1, 3));
		//reverseBST(n1);
		//printTree(n1);*/
		Tree n1 = new Tree(8);
		Tree n2 = new Tree(3);
		Tree n3 = new Tree(10);
		Tree n4 = new Tree(1);
		Tree n5 = new Tree(6);
		Tree n6 = new Tree(14);
		Tree n7 = new Tree(4);
		Tree n8 = new Tree(7);
		Tree n9 = new Tree(13);
		n5.buildLeft(n7);
		n5.buildRight(n8);
		n6.buildLeft(n9);
		n2.buildLeft(n4);
		n2.buildRight(n5);
		n3.buildRight(n6);
		n1.buildLeft(n2);
		n1.buildRight(n3);
		System.out.println(kthLargest(n1, 5));
		System.out.println(findKth(n1, 5).val);
		//System.out.println(n6.left.size());
		//System.out.println(first.size());
		//printTree(n1.root);
	}

}
