package algoQuestions;

import java.util.Stack;

public class PrintPatternOfDsIs {

	public static void main(String[] args) {

		System.out.println(printPatternUsingStack("DID"));
		
	}

	public static void PrintMinNumberForPattern(String seq) {

		String result = "";
		int next = 0;
		int lp = 0; // last printed digit

		for (int i = 0; i <= seq.length(); i++) {
			next = next + 1;

			if (i == seq.length() || seq.charAt(i) == 'I') {

				int j = next;
				while (j > lp) {
					result += j;
					result += " ";
					j--;
				}
				lp = next;
			}
		}

		System.out.println(result);
	}

	public static String printPatternUsingStack(String str) {
		String s = "";

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i <= str.length(); i++) {
			st.push(i + 1);
			if (i == str.length() || str.charAt(i) == 'I') {
				while (!st.isEmpty()) {
					s += " " + st.pop();
				}
			}
		}
		return s;

	}
}
