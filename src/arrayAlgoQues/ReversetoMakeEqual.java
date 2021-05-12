package arrayAlgoQues;

import java.util.HashMap;
import java.util.Map;

public class ReversetoMakeEqual {

	public static void main(String[] args) {
	    int[] array_a_1 = {1, 2, 3, 4};
	    int[] array_b_1 = {1, 4, 3, 2};
	    boolean expect_1 = true;
	    boolean outut_1 = areTheyEqual(array_a_1, array_b_1); 
	    System.out.println(outut_1);

	}
	static boolean areTheyEqual(int[] array_a, int[] array_b) {
		// Write your code hee
		Map<Integer, Integer> m1 = new HashMap<>();
		Map<Integer, Integer> m2 = new HashMap<>();
		for (int a : array_a) {
			if (m1.containsKey(a)) {
				m1.put(a, m1.get(a) + 1);
			} else {
				m1.put(a, 1);

			}
		}

		for (int a : array_b) {
			if (m2.containsKey(a)) {
				m2.put(a, m2.get(a) + 1);
			} else {
				m2.put(a, 1);

			}
		}
		
		return m1.equals(m2);
		
		
	}
}
