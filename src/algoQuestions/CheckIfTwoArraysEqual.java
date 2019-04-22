package algoQuestions;

import java.util.Arrays;

public class CheckIfTwoArraysEqual {

	public static void main(String[] args) {
		int A[] = {1, 2, 5}, B[] = {2, 4, 15};

		System.out.println(isEqual(A, B));
	}

	public static int isEqual(int arr1[], int arr2[]) {

		int temp1[] = new int[Arrays.stream(arr1).max().getAsInt() + 1];
		int temp2[] = new int[Arrays.stream(arr2).max().getAsInt() + 1];
		if (temp1.length != temp2.length) {
			return 0;
		}

		for (int i : arr1) {
			temp1[i]++;
		}
		for (int i : arr2) {
			temp2[i]++;
		}

		for (int i = 0; i < temp1.length; i++) {
			if (temp1[i] != temp2[i]) {
				return 0;
			}
		}

		return 1;
	}

}
