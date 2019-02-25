package algoQuestions;

import java.util.HashSet;
import java.util.Set;

import treeQuestions.Node;
import treeQuestions.TreeTraverse;

public class SubBinaryTree {

	private static char marker = '$';

	public static void main(String[] args) {
		Node root = new Node('A');  
        root.left = new Node('B');  
        root.right = new Node('C');  
        root.left.left = new Node('D');  
        root.left.right = new Node('E');  
        root.right.right = new Node('B');  
        root.right.right.right = new Node('E');  
        root.right.right.left= new Node('D');  
//        TreeTraverse.inOrderTraverse(root);
        
        HashSet<String> set = new HashSet<String>();
		System.out.println((getDuplicateBinaryTree(root, set).trim().equals("")?true:false));
	}
	
	private static String getDuplicateBinaryTree(Node node, Set<String> set) {
		
		String s = "";
		if(node == null )
			return s+marker;
		String left = getDuplicateBinaryTree(node.left, set);
		if (left.equals(s))  
            return s;  
		String right = getDuplicateBinaryTree(node.right, set);
		if (right.equals(s))  
            return s;  
		
		s += node.data+left+right;
		if(s.length()>4 && set.contains(s)) {
			return "";
		}else
			set.add(s);
		
		return s;
	}

}
