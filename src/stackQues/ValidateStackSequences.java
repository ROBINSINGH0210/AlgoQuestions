package stackQues;

import java.util.*;

public class ValidateStackSequences {

	public static void main(String[] args) {
		int pushed[] = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 3, 5, 1, 2 };
		System.out.println(validateStackSequences(pushed, popped));
//		push(1), push(2), push(3), push(4),
//		pop() -> 4,
//		push(5),
//		pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1		
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> st = new Stack<>();
		int i = 0;
		int j = 0;
		while (i < pushed.length || j < popped.length) {
			if ((st.isEmpty() || (j < popped.length && st.peek() != popped[j]) && i < pushed.length)) {
				st.add(pushed[i++]);
			} else if (!st.isEmpty()) {
				while (!st.isEmpty() && st.peek() == popped[j]) {
					j++;
					st.pop();
				}
				if (i >= pushed.length && !st.isEmpty()) {
					return false;
				}
			}
		}

		return true;

	}

}
