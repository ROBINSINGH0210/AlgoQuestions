package treeQuestions;

import java.util.Map;

public class CreateTreeFromPreAndInOrder {
	public static void main(String[] args) {

	}

	Node createNode(int[] in, int[] pre, int inStart, int inEnd, int preIndex, Map<Integer, Integer> inMap) {
		if (inStart > inEnd) {
			return null;
		}
		Node root = null;
		if (root == null) {
			root = new Node(pre[preIndex]);
		}
		if (inStart == inEnd) {
			return root;
		}

		int index = inMap.get(pre[preIndex]);

		root.left = createNode(in, pre, inStart, index - 1, preIndex + 1, inMap);
		root.right = createNode(in, pre, index + 1, inEnd, preIndex + 1, inMap);
		return root;

	}
}
