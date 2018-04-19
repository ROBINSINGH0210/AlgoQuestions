package microsoft;

import java.util.Arrays;

public class OddEvenSort {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 34, 55, 6, 4, 3, 67 };
		
		System.out.println(sortNum(arr));

	}

	static int[] sortNum(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 || arr[i] == 1) {
				arr[i] = -arr[i];
			}
		}
 
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 || arr[i] == 1) {
				arr[i] = -arr[i];
			}
		}
		
		return arr;
	}
}
