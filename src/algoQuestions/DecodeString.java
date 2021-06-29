package algoQuestions;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String str = "3[b2[ca]]";
		System.out.println(decodeString(str));

	}

	static String decodeString(String str) {
		Stack<StringBuilder> st = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
	
		int num = 0;
        StringBuilder cur = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                st2.push(num);
                st.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = st.pop();
                int k = st2.pop();
                for (int i = 0; i < k; i++) {
                    cur.append(tmp);
                }
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
	}

}
