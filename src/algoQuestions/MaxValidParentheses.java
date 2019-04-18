package algoQuestions;

import java.util.Stack;

public class MaxValidParentheses {

	public static void main(String[] args) {
		System.out.println(di("((())((()))"));
	}

	static int di(String s) {
		Stack<Integer> st = new Stack<>();
		char[] cs = s.toCharArray();
		int count = 0;
		st.push(-1);
		for (int ii = 0; ii < cs.length; ii++) {
			char cx = cs[ii];
			if (cx == '(') {
				st.push(ii);
			} else {
				st.pop();
				if (!st.isEmpty()) {
					count = Math.max(count, ii - st.peek());
				} else {
					st.push(ii);
				}
			}
		}
		return count;
	}

}
