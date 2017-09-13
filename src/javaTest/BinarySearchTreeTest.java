package javaTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearchTreeTest {
	static BinaryTree tree = null;
	static BinaryTree prev;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		tree = TreeTraverse.createBinaryTree();
		tree.right.left = BinarySearchTree.createBinarySearchTree();
		TreeTraverse.inOrderTraverse(tree);
		setDataInSet(tree);
//		Object[] a = set1.toArray();
		findLength(set1.toArray(new Integer [10]), set1.size());
//		System.out.println(isBST());
//		smallestElementOnKthPosition(5);
	}

	static boolean isBST() {
		prev = null;
		return isBST(tree);
	}

	static boolean isBST(BinaryTree node) {
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		if (node != null) {
			if (!isBST(node.left))
				return false;

			// allows only distinct values node
			if (prev != null && node.root <= prev.root) {
				System.out.println(node.root);
				return false;
			}
			prev = node;
			return isBST(node.right);
		}
		return true;
	}

	static int num;
	public static void smallestElementOnKthPosition(int k) {
		num = k;
		smallestElement(tree);

	}
	public static void smallestElement(BinaryTree node) {
		if (node != null) {
			smallestElement(node.left);
			num = num - 1;
			if (num == 0) {
				System.out.println("Data " + node.root);
			}
			smallestElement(node.right);
		}
	}
	
	static List<Integer> set1 = new ArrayList<Integer>();
	static Set<Integer> set2 = new HashSet<Integer>();
	public static void setDataInSet(BinaryTree node) {
		if (node != null) {
			smallestElement(node.left);
			set1.add(node.root);
			System.out.println("Data " + node.root);
			smallestElement(node.right);
		}
	}
	static int min(int x, int y) 
    {
        return (x < y) ? x : y;
    }
 
   static int max(int x, int y) 
    {
        return (x > y) ? x : y;
    }
 
    // Returns length of the longest contiguous subarray
    static int findLength(Integer arr[], int n) 
    {
        int max_len = 1;  // Initialize result
        for (int i = 0; i < n - 1; i++) 
        {
            // Initialize min and max for all subarrays starting with i
            int mn = arr[i], mx = arr[i];
 
            // Consider all subarrays starting with i and ending with j
            for (int j = i + 1; j < n; j++) 
            {
                // Update min and max in this subarray if needed
                mn = min(mn, arr[j]);
                mx = max(mx, arr[j]);
 
                // If current subarray has all contiguous elements
                if ((mx - mn) == j - i)
                    max_len = max(max_len, mx - mn + 1);
            }
        }
        return max_len;  // Return result
    }
	
}
