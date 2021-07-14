package treeQuestions;

public class MaximumDifferenceBetweenNodeandAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int diff = Integer.MAX_VALUE;

	public int maxAncestorDiff(BinaryTree root) {
		maxAncestorDiff(root, root.data, root.data);
		return diff;
	}

	private int maxAncestorDiff(BinaryTree root, int max, int min) {
		if (root == null)
			return max - min;

		max = Math.max(max, root.data);
		min = Math.min(min, root.data);
		int left = maxAncestorDiff(root.left, max, min);
		int right = maxAncestorDiff(root.right, max, min);
		return Math.max(left, right);

	}

}
