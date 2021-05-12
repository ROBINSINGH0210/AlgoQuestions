package arrayAlgoQues;

import java.util.*;

public class ContiguousSubarrays {

	public static void main(String[] args) {
		int[] test_1 = { 3, 4, 1, 6, 2 };
		int[] expected_1 = { 1, 3, 1, 5, 1 };
		int[] output_1 = countSubarrays(test_1);
		System.out.println(Arrays.toString(output_1));
		
	}

	static int[] countSubarrays(int[] arr) {
		int res[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					count++;
				} else {
					break;
				}
			}
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					count++;
				} else {
					break;
				}
			}
			res[i] = count;
		}

		return res;
	}

}
