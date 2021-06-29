package algoQuestions;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String str = "3[b2[ca]]";
		System.out.println(decodeString(str));

	}

	static String decodeString(String str) {
		String res = "";
		Stack<Character> st = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
	

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			if (Character.isDigit(str.charAt(i))) {
				while (i < str.length() && Character.isDigit(str.charAt(i))) {
					count = (count * 10) + Character.getNumericValue(str.charAt(i));
					i++;
				}
				st2.push(count);
			}
			if (str.charAt(i) == '[') {
				if (Character.isDigit(str.charAt(i - 1))) {
					st.push(str.charAt(i));
				} else {
					st.push(str.charAt(i));
					st2.push(1);

				}

			} else if (str.charAt(i) == ']') {
				String temp = "";
				while (!st.isEmpty() && st.peek() != '[') {
					temp = st.pop() + temp;
				}

				if (!st.isEmpty() && st.peek() == '[')
					st.pop();

				int p = 0;
				if (!st2.isEmpty())
					p = st2.pop();
				for (int j = 1; j <= p; j++) {
					res += temp;
				}

				for (int k = 0; k < res.length(); k++) {
					st.push(res.charAt(k));
				}
				res = "";

			} else
				st.push(str.charAt(i));
		}

		while (!st.isEmpty()) {
			res = st.pop() + res;
		}

		return res;
	}

}
