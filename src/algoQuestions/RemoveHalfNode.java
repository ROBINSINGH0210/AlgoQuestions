package algoQuestions;

import treeQuestions.TreeTraverse;

public class RemoveHalfNode {

	public static void main(String[] args) {
		treeQuestions.Node root = new treeQuestions.Node(2);
		root.left = new treeQuestions.Node(7);
		root.right = new treeQuestions.Node(5);
		root.left.right = new treeQuestions.Node(6);
		root.left.right.left = new treeQuestions.Node(1);
		root.left.right.right = new treeQuestions.Node(11);
		root.right.right = new treeQuestions.Node(9);
		root.right.right.left = new treeQuestions.Node(4);
		
//		System.out.println(removeHalf(root));

		TreeTraverse.inOrderTraverse(root);
		
		System.out.println( " After " );
		TreeTraverse.inOrderTraverse(removeHalf(root));
	}

	static treeQuestions.Node removeHalf(treeQuestions.Node node) {
		if (node == null) {
			return null;
		}

		node.left = removeHalf(node.left);
		node.right = removeHalf(node.right);

		if (node.left == null && node.right == null)
			return node;

		if (node.left == null) {
			treeQuestions.Node newRoot = node.right;
			return newRoot;
		}
		if (node.right == null) {
			treeQuestions.Node newRoot = node.left;
			return newRoot;
		}

		return node;
	}

}
