package microsoft;

import treeQuestions.BinaryTree;

public class KthSmallestElement {

	static int num;
	public static void smallestElementOnKthPosition(int k) {
	num = k;
//	smallestElement(tree);
	}
	public static void smallestElement(BinaryTree node) {
	if (node != null) {
	smallestElement(node.left);
	num = num - 1;
	if (num == 0) {
	System.out.println("Data " + node.data);
	}
	smallestElement(node.right);
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
