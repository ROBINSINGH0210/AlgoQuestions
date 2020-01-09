package algoQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RootToLeafPathSum {

	public static void main(String[] args) {
		Node n = new Node(6);
		 n.left= new Node(3);
		 n.left.left = new Node(2);
		 n.left.right = new Node(5);
		 n.left.right.left = new Node(7);
		 n.left.right.right = new Node(4);
		 n.right= new Node(5);
		 n.right.right = new Node(4);
		 
		 print(n);
		 System.out.println(treePathsSum(n, 0));

	}
	private static int treePathsSum(Node node,int val)
	{
	    if(node == null)
	           return 0;
	    val = val * 10 + node.data;
	    if(node.left==null && node.right==null) return val;
	    return treePathsSum(node.left,val)+ treePathsSum(node.right,val);
	}
	
	public static void print(Node root) {
		
		List<List<Integer>> list = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		stack.push(root);
		
		List<Integer> copyList = new LinkedList<>();
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.data);
			copyList.add(node.data);
			if(node.left!=null) {
				stack.push(node.left);
			}else {
				list.add(new LinkedList<>(copyList));
			}
			if(node.right!=null) {
				stack.push(node.right);
			}else {
				list.add(new LinkedList<>(copyList));
			}
		}
		
		System.out.println(list);
		
	}

}
