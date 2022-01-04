package algoQuestions;

import java.util.*;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicates r = new RemoveDuplicates();
		System.out.println(r.removeDuplicates("deeedbbcccbdaa", 3));
	}

	public String removeDuplicates(String s, int k) {
		Stack<Adjacent> st = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!st.isEmpty() && st.peek().ch == c) {
				st.peek().freq++;
			} else {
				st.push(new Adjacent(c, 1));
			}
			if (st.peek().freq == k) {
				st.pop();
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
				sb.append(String.valueOf(st.peek().ch).repeat(st.peek().freq));	
				st.pop();
			
		}
		return sb.reverse().toString();
	}

}

class Adjacent {
    char ch;
    int freq;
    public Adjacent(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
