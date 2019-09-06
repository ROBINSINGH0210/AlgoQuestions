package treeQuestions;

class LeftViewOfTree {
	int max_level = 0;

	void leftView(Node root) {
		leftViewUtil(root, 1);
	}

	void leftViewUtil(Node node, int level) {
		if (node == null)
			return;

		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}
}