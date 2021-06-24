package treeQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelOrderFromBottom {

	public static void main(String[] args) {
		

	}

	static void print(Node n) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(n);
		Stack<Node> st = new Stack<Node>();
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			st.push(temp);
			if(temp.right!=null) {
				q.offer(temp.right);
			}
			if(temp.left!=null) {
				q.offer(temp.left);
			}			
		}
		while(!st.isEmpty()) {
			System.out.println(st.pop().data);
		}	
		
	}
	
}
