package arrayAlgoQues;

import java.util.Arrays;

public class LargestTripleProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { -1, -1, 56, 56, 140, 140 };
		int[] output_2 = findMaxProduct(arr_2);
		System.out.println(Arrays.toString(output_2));
	}

	static int[] findMaxProduct(int[] arr) {
		int res[] = new int[arr.length];
		if (arr.length <= 2) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		res[0] = -1;
		res[1] = -1;
		int max1 = arr[0];
		int max2 = 0;
		int max3 = 0;
		if (arr[1] >= max1) {
			max2 = arr[1];
		} else {
			max2 = max1;
			max1 = arr[1];
		}
		if (arr[2] >= max2) {
			max3 = arr[2];
		} else {
			max3 = max2;
			max2 = arr[2];
		}
		res[2] = max1*max2*max3;
		for (int i = 3; i < arr.length; i++) {
			if (arr[i] > max3) {
				int temp = max3;
				max3 = arr[i];
				max1 = max2;
				max2 = temp;
			} else if (arr[i] > max2) {
				int temp = max2;
				max2 = arr[i];
				max1 = temp;
			} else if (arr[i] > max1) {
				max1 = arr[i];
			}
			res[i] = max1 * max2 * max3;
		}

		return res;

	}
}
