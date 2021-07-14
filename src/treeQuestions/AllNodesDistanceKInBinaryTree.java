package treeQuestions;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		AllNodesDistanceKInBinaryTree ab = new AllNodesDistanceKInBinaryTree();
		System.out.println(ab.distanceK(root, new TreeNode(5), 2));
	}

	Map<TreeNode, Integer> map = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> res = new LinkedList<>();
		find(root, target);
		dfs(root, target, k, map.get(root), res);
		return res;
	}

	private int find(TreeNode root, TreeNode target) {
		if (root == null)
			return -1;
		if (root.val == target.val) {
			map.put(root, 0);
			return 0;
		}
		int left = find(root.left, target);
		if (left >= 0) {
			map.put(root, left + 1);
			return left + 1;
		}
		int right = find(root.right, target);
		if (right >= 0) {
			map.put(root, right + 1);
			return right + 1;
		}
		return -1;
	}

	private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
		if (root == null)
			return;
		if (map.containsKey(root))
			length = map.get(root);
		if (length == K)
			res.add(root.val);
		dfs(root.left, target, K, length + 1, res);
		dfs(root.right, target, K, length + 1, res);
	}
}
