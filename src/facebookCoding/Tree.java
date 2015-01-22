package facebookCoding;
import java.util.*;
public class Tree {
	private int size;
	TreeNode node;
	Tree left;
	Tree right;
	List<TreeNode> children;
	public Tree() {
		children = new ArrayList<TreeNode>();
		size = 0;
	}
	public Tree(int rootVal) {
		node = new TreeNode(rootVal);
		children = new ArrayList<TreeNode> ();
		left = new Tree();
		right = new Tree();
		size++;
	}
	private void addChildren(Tree tree) {
		children.addAll(tree.children);
		size += tree.children.size();
	}
	public void buildLeft(Tree leftTree) {
		node.left = leftTree.node;
		left = leftTree;
		children.add(leftTree.node);
		size++;
		addChildren(leftTree);
	}
	
	public void buildRight(Tree rightTree) {
		node.right = rightTree.node;
		right = rightTree;
		children.add(rightTree.node);
		size++;
		children.addAll(rightTree.children);
		size += rightTree.children.size();
	}
	public int size() {
		return size;
	}

}
