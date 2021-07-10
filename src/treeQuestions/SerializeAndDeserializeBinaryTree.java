package treeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
//		root.left.left = new BinaryTree(4);
		root.right.left = new BinaryTree(4);
		root.right.right = new BinaryTree(5);
//		root.left.right.right = new BinaryTree(14);

		String str = serialize(root);

		BinaryTree deSerialize = deSerialize(str);
		System.out.println(deSerialize);
	}

	static String serialize(BinaryTree node) {
		Stack<BinaryTree> st = new Stack<>();
		List<String> strList = new ArrayList<String>();
		st.add(node);
		while (!st.isEmpty()) {
			BinaryTree temp = st.pop();
			if (temp != null) {
				strList.add("" + temp.data);
				st.add(temp.right);
				st.add(temp.left);
			} else
				strList.add("#");

		}

		return String.join(",", strList);
	}

	static int i = 0;

	static BinaryTree deSerialize(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		String[] split = str.split(",");

		return helper(split);
	}

	static BinaryTree helper(String[] split) {
		if ("#".equals(split[i])) {
			return null;
		}
		BinaryTree n = new BinaryTree(Integer.parseInt(split[i]));
		i++;
		n.left = helper(split);
		i++;

		n.right = helper(split);
		return n;
	}

}
