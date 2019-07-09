package treeQuestions;

public class CheckSubTree {

	public static void main(String[] args) {
		 BinarySearchTree tree = new BinarySearchTree(); 
         
	        // TREE 1 
	        /* Construct the following tree 
	              26 
	             /   \ 
	            10     3 
	           /    \     \ 
	          4      6      3 
	           \ 
	            30  */
	            
		 Node root = new Node(26); 
		 root.right = new Node(3); 
		 root.right.right = new Node(3); 
		 root.left = new Node(10); 
		 root.left.left = new Node(4); 
		 root.left.left.right = new Node(30); 
		 root.left.right = new Node(6); 
	   
	        // TREE 2 
	        /* Construct the following tree 
	           10 
	         /    \ 
	         4      6 
	          \ 
	          30  */
	            
		 Node root2 = new Node(10); 
		 root2.right = new Node(6); 
		 root2.left = new Node(4); 
		 root2.left.right = new Node(30); 
		 
		 System.out.println(isSubTree(root, root2));
		 
		 
	}

	public static boolean isSubTree(Node tree, Node subTree) {
		if (subTree == null) {
			return true;
		} else if (tree == null) {
			return false;
		}
		if (isValidSubTree(tree, subTree)) {
			return true;
		}
		return isSubTree(tree.left, subTree) || isSubTree(tree.right, subTree);
	}

	private static boolean isValidSubTree(Node tree, Node subTree) {
		if (tree == null && subTree == null) {
			return true;
		} else if (tree == null || subTree == null) {
			return false;
		}
		return (subTree.data == tree.data && isValidSubTree(tree.left, subTree.left)
				&& isValidSubTree(tree.right, subTree.right));
	}
}
