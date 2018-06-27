package javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {

	public static void main(String... strings) {
		// BinaryTree tree = createBinaryTree();
		// printLevelOrder(tree);
		// System.out.println("");
		// inOrderTraverse(tree);
		// System.out.println("");
		// preOrderTraverse(tree);
		// System.out.println("");
		// postOrderTraverse(tree);
		// System.out.println("In Spiral form");
		// printSpiral(tree);

		int pre[] = new int[] { 37, 41, 43, 13, 5, 11, 29, 23, 2, 17, 47, 7, 3, 19, 31 };
		int size = pre.length;
		BinaryTree root = constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		postOrderTraverse(root);
		// inOrderTraverse(root);

	}

	public static BinaryTree createBinaryTree() {
		BinaryTree root = new BinaryTree(13);
		BinaryTree a = new BinaryTree(5);
		BinaryTree b = new BinaryTree(43);
		BinaryTree c = new BinaryTree(11);
		BinaryTree d = new BinaryTree(41);
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
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
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

	static BinaryTree constructTree(int pre[], int size) {

		// The first element of pre[] is always root
		BinaryTree root = new BinaryTree(pre[0]);

		Stack<BinaryTree> s = new Stack<BinaryTree>();

		// Push root
		s.push(root);

		// Iterate through rest of the size-1 items of given preorder array
		for (int i = 1; i < size; ++i) {
			BinaryTree temp = null;

			/*
			 * Keep on popping while the next value is greater than stack's top value.
			 */
			while (!s.isEmpty() && pre[i] > s.peek().root) {
				temp = s.pop();
			}

			// Make this greater value as the right child and push it to the stack
			if (temp != null) {
				temp.right = new BinaryTree(pre[i]);
				s.push(temp.right);
			}

			// If the next value is less than the stack's top value, make this value
			// as the left child of the stack's top BinaryTree. Push the new BinaryTree to
			// stack
			else {
				temp = s.peek();
				temp.left = new BinaryTree(pre[i]);
				s.push(temp.left);
			}
		}

		return root;
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Function to find index of value in arr[start...end] The function assumes that
	 * value is present in in[]
	 */
	int search(char arr[], int strt, int end, char value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	/* This funtcion is here just to test buildTree() */
	
	
	
	public List<Integer> inorderInIterative(BinaryTree node) {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		BinaryTree tree = node;
		List<Integer> list = new ArrayList<Integer>();
		BinaryTree prev = null;
		if(node != null)
			stack.push(node);
		
		while (!stack.isEmpty()) {
			if(prev == null || stack.peek().left == null || stack.peek().right == null) {
				
			}
			
		}
			
		return list;
	}

}
