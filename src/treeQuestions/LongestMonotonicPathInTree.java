package treeQuestions;

public class LongestMonotonicPathInTree {
	int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(-7);
		root.left.left.left = new TreeNode(-9);
		root.left.left.right = new TreeNode(-1);
		root.left.right = new TreeNode(9);
		root.left.right.right = new TreeNode(10);
		root.left.right.right.right = new TreeNode(11);
		root.left.right.right.right.right = new TreeNode(11);

		root.right = new TreeNode(14);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(19);

		LongestMonotonicPathInTree lb = new LongestMonotonicPathInTree();
		lb.findMonotonicPath(root, 0, Integer.MIN_VALUE);
		System.out.println(lb.max);
	}

	public void findMonotonicPath(TreeNode root, int curr, int prev) {

		if (root == null) {
			return;
		}

		if (prev <= root.val) {
			curr++;
		} else {
			curr = 1;
		}

		max = Math.max(curr, max);
		findMonotonicPath(root.left, curr, root.val);
		findMonotonicPath(root.right, curr, root.val);
	}

}
