package treeQuestions;

class FixingTwoNodesOfaBST {

	static Node firstNode;
	static Node secondNode;
	static Node prev;

	public static void main(String[] args) {
			
	/*   10 
        / \ 
       3   17
       \  /  
       11 4 
      
    10 and 2 are swapped 
    */		
		Node root = new Node(10);
		root.left = new Node(3);
		root.right = new Node(17);
//		root.left.left = new Node(1);
		root.left.right = new Node(11);
//		root.right.right = new Node(3);
		root.right.left = new Node(4);

		System.out.println(correctBST(root));
	}

	public static Node correctBST(Node root) {
		inorder(root);
		if (firstNode == null && secondNode == null) {
			return root;
		} else {
			int data  = firstNode.data;
			firstNode.data = secondNode.data;
			secondNode.data  = data;

		}
		return root;
	}

	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (prev != null && root != null && root.data < prev.data) {
			if (firstNode == null) {
				firstNode = prev;

			} else if (secondNode == null && firstNode.data != prev.data) {
				secondNode = root;
			}
		}
		prev = root;
		inorder(root.right);
	}

}