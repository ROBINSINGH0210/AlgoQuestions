package treeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeTraverse {

	public static void main(String... strings) {
		// Node tree = createBinaryTree();
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
		Node root = constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		postOrderTraverse(root);
		// inOrderTraverse(data);

	}

	public static Node createBinaryTree() {
		Node root = new Node(13);
		Node a = new Node(5);
		Node b = new Node(43);
		Node c = new Node(11);
		Node d = new Node(41);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		return root;
	}

	public static void inOrderTraverse(Node tree) {
		if (tree != null) {
			inOrderTraverse(tree.left);
			System.out.println("Data " + tree.data);
			inOrderTraverse(tree.right);
		}
	}

	public static void preOrderTraverse(Node tree) {
		if (tree != null) {
			System.out.println("Data " + tree.data);
			preOrderTraverse(tree.left);
			preOrderTraverse(tree.right);
		}
	}

	public static void postOrderTraverse(Node tree) {
		if (tree != null) {
			postOrderTraverse(tree.left);
			postOrderTraverse(tree.right);
			System.out.println("Data " + tree.data);
		}
	}

	/* function to print level order traversal of tree */
	static void printLevelOrder(Node root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the data node down to the farthest leaf node.
	 */
	static int height(Node root) {
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
	static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static void printGivenLevelSpiral(Node node, int level, boolean ltr) {
		if (node == null)
			return;
		if (level == 1)
			System.out.print(node.data + " ");
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

	static void printSpiral(Node node) {
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

	static Node constructTree(int pre[], int size) {

		// The first element of pre[] is always data
		Node root = new Node(pre[0]);

		Stack<Node> s = new Stack<Node>();

		// Push data
		s.push(root);

		// Iterate through rest of the size-1 items of given preorder array
		for (int i = 1; i < size; ++i) {
			Node temp = null;

			/*
			 * Keep on popping while the next value is greater than stack's top value.
			 */
			while (!s.isEmpty() && pre[i] > s.peek().data) {
				temp = s.pop();
			}

			// Make this greater value as the right child and push it to the stack
			if (temp != null) {
				temp.right = new Node(pre[i]);
				s.push(temp.right);
			}

			// If the next value is less than the stack's top value, make this value
			// as the left child of the stack's top Node. Push the new Node to
			// stack
			else {
				temp = s.peek();
				temp.left = new Node(pre[i]);
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

	public List<Integer> inorderInIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node tree = node;
		List<Integer> list = new ArrayList<Integer>();
		Node prev = null;
		if (node != null)
			stack.push(node);

		while (!stack.isEmpty()) {
			if (prev == null || stack.peek().left == null || stack.peek().right == null) {

			}

		}

		return list;
	}

	public static Map<Integer, List<Integer>> printVerticalOrder(Node node) {
		Integer hd = 0;
		Map<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>();
		getVerticalOrder(node, hd, treeMap);
		return treeMap;
	}

	public static void getVerticalOrder(Node root, Integer hd, Map<Integer, List<Integer>> treeMap) {

		if (root == null) {
			return;
		}

		List<Integer> list = treeMap.get(hd);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
			treeMap.put(hd, list);
		} else {
			list.add(root.data);
		}
		getVerticalOrder(root.left, hd - 1, treeMap);
		getVerticalOrder(root.right, hd + 1, treeMap);
	}

	public static Map<Integer, List<Integer>> printTreeViewFromTop(Node node) {
		Integer hd = 0;
		Map<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>();
		getTreeViewFromTop(node, hd, treeMap);
		return treeMap;
	}
	
	public static void getTreeViewFromTop(Node root, Integer hd, Map<Integer, List<Integer>> treeMap) {

		if (root == null) {
			return;
		}

		List<Integer> list = treeMap.get(hd);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
			treeMap.put(hd, list);
		}
		getTreeViewFromTop(root.left, hd - 1, treeMap);
		getTreeViewFromTop(root.right, hd + 1, treeMap);
	}

}
