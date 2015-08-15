package facebookCoding;
import java.util.*;
import java.util.Queue;
public class AvgValueOfEachLevelOfATree {
	public static List<Double> avgValue(TreeNode root){
	    List<Double> rst = new ArrayList<Double> ();
	    if (root == null)
	        return rst;
	    Queue<TreeNode> nodes = new LinkedList<TreeNode> ();
	    nodes.add(root);
	    while (!nodes.isEmpty()){
	        int size = nodes.size();
	        int sum = 0;
	        for (int i = 0; i < size; i++){
	            TreeNode curr = nodes.poll();
	            if (curr.left != null)
	                nodes.add(curr.left);
	            if (curr.right != null)
	                nodes.add(curr.right);
	            sum += curr.val;
	        }
	        rst.add((double)sum / size);
	    }
	    return rst;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		for (double i : avgValue(n1)) {
			System.out.print(i + " ");
		}

	}

}
