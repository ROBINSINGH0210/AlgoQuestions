package javaTest;

public class TreeTraverse {

	public static void main(String... strings) {
		BinaryTree tree = createBinaryTree();
		printLevelOrder(tree);
		System.out.println("");
		inOrderTraverse(tree);
		System.out.println("");
		preOrderTraverse(tree);
		System.out.println("");
		postOrderTraverse(tree);
		System.out.println("In Spiral form");
		printSpiral(tree);
		
	}

	public static BinaryTree createBinaryTree() {
		BinaryTree root = new BinaryTree(65);
		BinaryTree a = new BinaryTree(10);
		BinaryTree b = new BinaryTree(15);
		BinaryTree c = new BinaryTree(14);
		BinaryTree d = new BinaryTree(25);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		return root;
	}

	public static void inOrderTraverse(BinaryTree tree) {
		if (tree != null) {
			inOrderTraverse(tree.left);
			System.out.println("Data " + tree.root);
			inOrderTraverse(tree.right);
		}
	}

	public static void preOrderTraverse(BinaryTree tree) {
		if (tree != null) {
			System.out.println("Data " + tree.root);
			inOrderTraverse(tree.left);
			inOrderTraverse(tree.right);
		}
	}

	public static void postOrderTraverse(BinaryTree tree) {
		if (tree != null) {
			inOrderTraverse(tree.left);
			inOrderTraverse(tree.right);
			System.out.println("Data " + tree.root);
		}
	}

	/* function to print level order traversal of tree */
	static void printLevelOrder(BinaryTree root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	static int height(BinaryTree root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	static void printGivenLevel(BinaryTree root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.root + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static void printGivenLevelSpiral(BinaryTree node, int level, boolean ltr) {
		if (node == null)
			return;
		if (level == 1)
			System.out.print(node.root + " ");
		else if (level > 1) {
			if (ltr != false) {
				printGivenLevelSpiral(node.left, level - 1, ltr);
				printGivenLevelSpiral(node.right, level - 1, ltr);
			} else {
				printGivenLevelSpiral(node.right, level - 1, ltr);
				printGivenLevelSpiral(node.left, level - 1, ltr);
			}
		}
	}

	static void printSpiral(BinaryTree node) {
		int h = height(node);
		int i;

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * transversed from left to right
		 */
		boolean ltr = false;
		for (i = 1; i <= h; i++) {
			printGivenLevelSpiral(node, i, ltr);

			/* Revert ltr to traverse next level in opposite order */
			ltr = !ltr;
		}

	}

}
