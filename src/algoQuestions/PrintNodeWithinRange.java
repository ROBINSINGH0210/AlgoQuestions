package algoQuestions;

import java.util.*;

public class PrintNodeWithinRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int getCountOfNode(Node root, int low, int high) {

		if (root == null) {
			return 0;
		}
		int count = 0;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node n = stack.pop();
			if (n.data >= low && n.data <= high) {
				count++;
			}
			if (n.left != null)
				stack.push(n.left);
			if (n.right != null)
				stack.push(n.right);

		}
		return count;
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}
