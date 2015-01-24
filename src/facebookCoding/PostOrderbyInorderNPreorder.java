package facebookCoding;
/*
 * Given a Pre-Order and In-Order string of a binary tree, can we and if we can,
 * construct the "Post-Order" String.
 */
public class PostOrderbyInorderNPreorder {
	public static String postOrder(String preOrder, String inOrder) {
		if (preOrder == null || inOrder == null || preOrder.length() == 0 
				|| inOrder.length() == 0 || inOrder.length() != preOrder.length())
			return "";
		char headVal = preOrder.charAt(0);
		//System.out.println("root: " + headVal);
		int index = findIndex(inOrder, headVal);
		String left = postOrder(preOrder.substring(1, index + 1), inOrder.substring(0, index));
		//System.out.println("left: " + left);
		String right = postOrder(preOrder.substring(index + 1), inOrder.substring(index + 1));
		//System.out.println("right: " + right);
		return left + right + String.valueOf(headVal);
	}
	private static int findIndex(String inOrder, char target) {
		int index = 0;
		for (int i = 0; i < inOrder.length(); i++) {
			if (inOrder.charAt(i) == target) {
				index = i;
				break;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		System.out.println(postOrder("12537", "25137"));
	}
}
