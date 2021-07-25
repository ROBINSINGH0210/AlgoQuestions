package arrayAlgoQues;

import java.util.*;

public class ContiguousSubarrays {

	public static void main(String[] args) {
		int[] test_1 = { 3, 4, 1, 6, 2 };
		int[] expected_1 = { 1, 3, 1, 5, 1 };
		int[] output_1 = countSubarrays(test_1);
		System.out.println(Arrays.toString(output_1));

	}

	static int[] countSubarrays(int[] arr) {// Write your code here
		Stack<Integer> s = new Stack<>();
		int[] L = new int[arr.length];
		L[0] = 1;
		s.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i])
				s.pop();
			if (s.isEmpty())
				L[i] = i + 1;
			else
				L[i] = i - s.peek();
			s.push(i);
		}
		int[] R = new int[arr.length];
		R[arr.length - 1] = L[arr.length - 1];
		s.clear();
		s.push(arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i])
				s.pop();
			if (s.isEmpty())
				R[i] = (arr.length - i) + L[i] - 1;
			else
				R[i] = (s.peek() - i) + L[i] - 1;
			s.push(i);
		}
		return R;
	}

}
