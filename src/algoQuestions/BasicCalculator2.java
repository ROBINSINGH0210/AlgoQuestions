package algoQuestions;

import java.util.Stack;

public class BasicCalculator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 System.out.println(calculate("3+2*2"));
	}

	public static int calculate(String s) {
		
		int res =0;
		Stack<Integer> st = new Stack<>();
		int curr=0;
		char op = '+';
		for(int i =0 ; i< s.length(); i++) {
			char c =  s.charAt(i);
			if(Character.isDigit(c)) {
				curr =  curr*10+ Character.getNumericValue(c);
			} 
			if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1) {
				if(op ==  '+') {
					st.push(curr);
				} else if(op == '-') {
					st.push(-curr);
				} else if (op== '/') {
					st.push(st.pop()/curr);
				} else if(op == '*') {
					st.push(st.pop()* curr);
				}
				
				op = c;
				curr = 0;
				
				
			}
			
		}
		while(!st.isEmpty()) {
			res+=st.pop();
		}
		
		
		return res;
		
	}
}
