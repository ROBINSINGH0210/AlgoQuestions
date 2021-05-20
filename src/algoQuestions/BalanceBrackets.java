package algoQuestions;

import java.util.*;

public class BalanceBrackets {

	public static void main(String[] args) {
		  String s_2 = "{{[[(())]]}}";
		    boolean expected_2 = true;
		    boolean output_2 = isBalanced(s_2);
		    System.out.println(output_2);
		    

	}

	static boolean isBalanced(String s) {
		Map<Character,Character> open = new HashMap<>();
		open.put('(',')');
		open.put('{','}');
		open.put('[',']');
		Map<Character,Character> close = new HashMap<>();
		close.put(')','(');
		close.put('}','{');
		close.put(']','[');
		
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(open.containsKey(s.charAt(i))) {
				st.add(s.charAt(i));
			}else {
				if(st.isEmpty()) {
					return false;
				} else {
					Character v = st.pop();
					if(v != close.get(s.charAt(i))) {
						return false;
					}
				}
			}
		}
		return true;

	}

}
