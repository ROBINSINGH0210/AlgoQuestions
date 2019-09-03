package treeQuestions;

public class AddAllGreaterValuesToEveryNodeInBST {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		modify(root);
		TreeTraverse.inOrderTraverse(root);

	}

	static int prev = 0;

	static void modify(Node root) {
		if (root == null)
			return;
		modify(root.right);
		if (prev != 0)
			root.data += prev;
		prev = root.data;
		modify(root.left);
	}

}
