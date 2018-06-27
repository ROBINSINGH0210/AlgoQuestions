package javaTest;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree {
	public BinaryTree left;
	public BinaryTree right;
	public int root;
	public BinaryTree(int root){
		this.root = root;
		left = right = null;
	}
	
	public Itr iterator() {
		return new Itr();
	}
	
	 class Itr implements Iterator<Integer>{
		Stack<BinaryTree> abc = new Stack<BinaryTree>();
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


