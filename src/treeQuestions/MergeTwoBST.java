package treeQuestions;

import java.util.*;

class MergeTwoBST {

	public static void main(String[] args) {
	
	}

	public static void merge(Node root1, Node root2) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		String s = "";
		while (root1 != null) {
			s1.push(root1);
			root1 = root1.left;
		}

		while (root2 != null) {
			s2.push(root2);
			root2 = root2.left;
		}

		while (!s1.isEmpty() || !s2.isEmpty()) {

			if (!s1.isEmpty() && !s2.isEmpty()) {
				Node r1 = s1.peek();
				Node r2 = s2.peek();

				if (r1.data < r2.data) {
					s1.pop();
					if (s.isEmpty())
						s += r1.data;
					else
						s = s + " " + r1.data;
					r1 = r1.right;
					while (r1 != null) {
						s1.push(r1);
						r1 = r1.left;
					}
				} else {
					s2.pop();
					if (s.isEmpty())
						s += r2.data;
					else
						s = s + " " + r2.data;
					r2 = r2.right;
					while (r2 != null) {
						s2.push(r2);
						r2 = r2.left;
					}
				}
			} else if (s1.isEmpty()) {
				while (!s2.isEmpty()) {
					Node r2 = s2.pop();
					if (s.isEmpty())
						s += r2.data;
					else
						s = s + " " + r2.data;
					r2 = r2.right;
					while (r2 != null) {
						s2.push(r2);
						r2 = r2.left;
					}
				}
			}

			else {
				while (!s1.isEmpty()) {
					Node r1 = s1.pop();
					if (s.isEmpty())
						s += r1.data;
					else
						s = s + " " + r1.data;
					r1 = r1.right;
					while (r1 != null) {
						s1.push(r1);
						r1 = r1.left;
					}
				}
			}
		}
		System.out.print(s);
	}

}
