package treeQuestions;

import java.util.Stack;

public class CheckPreOrderArrayIsBST {

	public static void main(String[] args) {
		int[] pre1 = new int[] { 40, 30, 35, 80, 100 };
		System.out.println("abc? ".trim().endsWith("?"));
		
//		System.out.println(isArrayRepresentBST(pre1));
	}

	public static boolean isArrayRepresentBST(int arr[]) {
		int root = Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<>();
		for (int i : arr) {
			if (root > i)
				return false;

			while (!st.isEmpty() && st.peek() < i) {
				root = st.pop();
			}
			st.push(i);
		}

		return true;
	}

}
