package javaTest;

public class BinarySearchTree {

	public static BinaryTree search(BinaryTree node, int key) {
		if (node == null || node.root == key) {
			return node;
		} else if (key > node.root) {
			return search(node.right, key);
		} else {
			return search(node.left, key);
		}
	}

	public static BinaryTree insertNode(BinaryTree node, int key) {
		if (node == null)
			return new BinaryTree(key);
		else if (key > node.root)
			node.right = insertNode(node.right, key);
		else
			node.left = insertNode(node.left, key);
		return node;
	}

	public static BinaryTree deletion(BinaryTree node, int key) {
		if (node != null) {
			if (node.root == key) {
				System.out.println(node.root);
				if (node.left == null && node.right == null) {
					node = null;
				} else if (node.left == null && node.right != null) {
					node = node.right;
				} else if (node.left != null && node.right == null) {
					node = node.left;
				} else {
					node.root = minValue(node.right);
					node.right = deletion(node.right, node.root);

				}
			} else if (key > node.root) {
				node.right = deletion(node.right, key);
			} else {
				node.left = deletion(node.left, key);
			}
		} else {
			System.out.println("Node Not present in tree");
		}
		return node;
	}

	public static int minValue(BinaryTree node) {
		int minv = node.root;
		while (node.left != null) {
			minv = node.left.root;
			node = node.left;
		}
		return minv;
	}

	public static void main(String[] args) {
		BinaryTree tree = createBinarySearchTree();
		TreeTraverse.inOrderTraverse(tree);
		deletion(tree, 20);
		// System.out.println((search(tree, 19) != null) ? search(tree, 19).root
		// : "Node not found");

		TreeTraverse.inOrderTraverse(tree);
	}

	public static BinaryTree createBinarySearchTree() {
		BinaryTree tree = new BinaryTree(20);
		tree = insertNode(tree, 8);
		tree = insertNode(tree, 22);
		tree = insertNode(tree, 4);
		tree = insertNode(tree, 12);
		tree = insertNode(tree, 10);
		tree = insertNode(tree, 14);
		
		return tree;
	}

}
