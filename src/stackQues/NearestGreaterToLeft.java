package stackQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = Arrays.asList(1, 3, 2, 4);
//		Collections.reverse(null);
		System.out.println(nearestGreaterToLeft(arr));
	}

	public static List<Integer> nearestGreaterToLeft(List<Integer> list) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			if (st.isEmpty()) {
				res.add(-1);
				st.add(list.get(i));
			} else {
				while (!st.isEmpty() && st.peek() < list.get(i)) {
					st.pop();
				}
				if (!st.isEmpty()) {
					res.add(st.peek());
				} else
					res.add(-1);

				st.add(list.get(i));
			}
		}
//		Collections.reverse(res);
		return res;
	}

}
