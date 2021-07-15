package treeQuestions;

import java.util.*;

public class SubtreeAverage {
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
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(-7);
		root.left.right = new TreeNode(9);
		root.left.right.right = new TreeNode(10);
//		root.left.right.right = new TreeNode(4);

		root.right = new TreeNode(9);
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(8);
		SubtreeAverage sb = new SubtreeAverage();
		List<Integer> list = new ArrayList<Integer>();
		sb.findSubTree(root, list);
		System.out.println(list);
	}

	int count = 0;

	public int findSubTree(TreeNode root, List<Integer> list) {
		if (root == null) {
			return 0;
		}

		int left = findSubTree(root.left, list);
		int right = findSubTree(root.right, list);
		if (count > 0 && root.val == ((root.val + left + right) / (count + 1))) {
			list.add(root.val);
		}
		count++;
		return left + right + root.val;
	}

}
