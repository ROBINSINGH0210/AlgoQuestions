package stackQues;

import java.util.*;

//Next Largest Element
public class NearestGreaterToRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = Arrays.asList(13, 7, 6, 12);
//		Collections.reverse(null);
		System.out.println(nearestGreaterToRight(arr));
	}

	public static List<Integer> nearestGreaterToRight(List<Integer> list) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		for(int i = list.size()-1; i>=0; i--) {
			if(st.isEmpty()) {
				res.add(-1);
				st.add(list.get(i));
			} else {
				while(!st.isEmpty() && st.peek() < list.get(i)) {
					st.pop();
				} 
				if(!st.isEmpty()) {
					res.add(st.peek());
				} else
					res.add(-1);
				
				st.add(list.get(i));
			}
		}
		Collections.reverse(res);
		return res;
	}

}
