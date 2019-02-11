package treeQuestions;

import java.util.Iterator;
import java.util.Stack;

public class Node {
	public Node left;
	public Node right;
	public int data;
	public Node(int root){
		this.data = root;
		left = right = null;
	}
	
	public Itr iterator() {
		return new Itr();
	}
	
	 class Itr implements Iterator<Integer>{
		Stack<Node> abc = new Stack<Node>();
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}


