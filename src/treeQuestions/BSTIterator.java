package treeQuestions;

import java.util.*;

public class BSTIterator {

	Stack<BinaryTree> st = new Stack<>();

	public BSTIterator(BinaryTree root) {
		BinaryTree curr = root;
		while (curr != null) {
			st.add(curr);
			curr = curr.left;
		}
	}

	public int next() {
		BinaryTree curr = st.pop();
		int val = curr.data;
		curr = curr.right;
		while (curr != null) {
			st.add(curr);
			curr = curr.left;
		}
		return val;
	}

	public boolean hasNext() {
		return !st.isEmpty();
	}
}
