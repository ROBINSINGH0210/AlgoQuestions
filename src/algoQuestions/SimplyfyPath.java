package algoQuestions;

import java.util.*;

public class SimplyfyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SimplyfyPath().simplifyPath("/home//foo/"));
	}

	public String simplifyPath(String path) {
		Set<String> dict = new HashSet<>(Arrays.asList(".", "..", ""));
		Stack<String> st = new Stack<>();

		for (String str : path.split("/")) {
			if ("..".equals(str) && !st.isEmpty()) {
				st.pop();
			} else if (!dict.contains(str)) {
				st.push(str);
			}

		}

		String res = "";
		while (!st.isEmpty()) {
			res = "/" + st.pop() + res;
		}

		if (res.isEmpty()) {
			return "/";
		} else
			return res;

	}

}
