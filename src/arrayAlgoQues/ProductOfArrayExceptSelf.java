package arrayAlgoQues;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 2, 3, 4 };
//							  [1, 2, 6, 24]
//		System.out.println(Arrays.toString(product(arr)));
		
	}

	static int[] product(int[] arr) {
		int res[] = new int[arr.length];
		int prod = 1;
		for (int i = 0; i < arr.length; i++) {
			res[i] = prod;
			prod *= arr[i];
		}
		prod = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			res[i] *= prod;
			prod *= arr[i];
		}

		return res;
	}

}
