package treeQuestions;

import java.util.Stack;

public class FindTheClosestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxDiff(Node root, int k) {
		int diff = -1;
		Stack<Node> st = new Stack<Node>();
		st.add(root);
		while (!st.isEmpty()) {
			Node p = st.pop();
			if (diff == -1 || diff > Math.abs(p.data - k))
				diff = Math.abs(p.data - k);
			if (p.left != null)
				st.add(p.left);
			if (p.right != null)
				st.add(p.right);

		}

		return diff;

	}
}
