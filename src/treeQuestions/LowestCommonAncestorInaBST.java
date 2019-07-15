package treeQuestions;

public class LowestCommonAncestorInaBST {

	public static void main(String[] args) {
		Node tree = new Node(20);
		tree.left = new Node(8);
		tree.right = new Node(22);
		tree.left.left = new Node(4);
		tree.left.right = new Node(12);
		tree.left.right.left = new Node(10);
		tree.left.right.right = new Node(14);
		System.out.println(lca(tree, 14, 8).data);

	}

	static Node lca(Node node, int n1, int n2) {
		while (node != null) {
			if (node.data < n1 && node.data < n2)
				node = node.right;
			else if (node.data > n1 && node.data > n2)
				node = node.left;
			else
				return node;
		}
		return null;
	}

}
