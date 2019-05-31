package treeQuestions;

public class BinarySearchTree {

	public static Node search(Node node, int key) {
		if (node == null || node.data == key) {
			return node;
		} else if (key > node.data) {
			return search(node.right, key);
		} else {
			return search(node.left, key);
		}
	}

	public static Node insertNode(Node node, int key) {
		if (node == null)
			return new Node(key);
		else if (key > node.data)
			node.right = insertNode(node.right, key);
		else
			node.left = insertNode(node.left, key);
		return node;
	}

	public static Node deletion(Node node, int key) {
		if (node != null) {
			if (node.data == key) {
				System.out.println(node.data);
				if (node.left == null && node.right == null) {
					node = null;
				} else if (node.left == null && node.right != null) {
					node = node.right;
				} else if (node.left != null && node.right == null) {
					node = node.left;
				} else {
					node.data = minValue(node.right);
					node.right = deletion(node.right, node.data);

				}
			} else if (key > node.data) {
				node.right = deletion(node.right, key);
			} else {
				node.left = deletion(node.left, key);
			}
		} else {
			System.out.println("Node Not present in tree");
		}
		return node;
	}

	public static int minValue(Node node) {
		int minv = node.data;
		while (node.left != null) {
			minv = node.left.data;
			node = node.left;
		}
		return minv;
	}

	public static void main(String[] args) {
		Node tree = createBinarySearchTree();
		TreeTraverse.inOrderTraverse(tree);
		deletion(tree, 20);
		// System.out.println((search(tree, 19) != null) ? search(tree, 19).root
		// : "Node not found");

		TreeTraverse.inOrderTraverse(tree);
	}

	public static Node createBinarySearchTree() {
		Node tree = new Node(20);
		tree = insertNode(tree, 8);
		tree = insertNode(tree, 22);
		tree = insertNode(tree, 4);
		tree = insertNode(tree, 12);
		tree = insertNode(tree, 10);
		tree = insertNode(tree, 14);
		
		return tree;
	}

}
