package treeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelOrderUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void printLevelOrder(Node node) {
		if (node == null) {
			System.out.print("");
		}

		Queue<Node> q1 = new LinkedList<Node>();

		q1.add(node);
		while (!q1.isEmpty()) {
			Queue<Node> q2 = new LinkedList<Node>();
			while (!q1.isEmpty()) {
				Node n = q1.poll();
				if (n != null) {
					System.out.print(n.data);
					if (n.left != null) {
						q2.offer(n.left);
					}
					if (n.right != null) {
						q2.offer(n.right);
					}
				}
			}
			System.out.println();
			if (!q2.isEmpty()) {
				q1.addAll(q2);
				
			}	

		}

	}
	
	static void printLevelReverseOrder(Node node) {

        Stack<ArrayList<Integer>> list = new Stack<>();
        if (node == null) {
			System.out.println("");
		}

		Queue<Node> q1 = new LinkedList<Node>();

		q1.add(node);
		while (!q1.isEmpty()) {
			Queue<Node> q2 = new LinkedList<Node>();
			ArrayList<Integer> li = new ArrayList<>();
			while (!q1.isEmpty()) {
				Node n = q1.poll();
				if (n != null) {
					li.add(n.data);
					if (n.left != null) {
						q2.offer(n.left);
					}
					if (n.right != null) {
						q2.offer(n.right);
					}
				}
			}
			
			if (!q2.isEmpty()) {
				q1.addAll(q2);
				
			}
			
			if(!li.isEmpty()){
			    list.add(li);
			}

		}

	}
}
