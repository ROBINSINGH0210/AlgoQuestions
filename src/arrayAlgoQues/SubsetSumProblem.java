package arrayAlgoQues;

import java.util.*;

public class SubsetSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 5 };
		SubsetSumProblem s = new SubsetSumProblem();
		System.out.println(s.canPartitionInEqualSubSet(arr));
	}

	int isSubsetPresent(int[] arr, int i, int sum) {
		if (sum == 0) {
			return 1;
		}
		if (i == 0) {
			return 0;
		}

		int sub = isSubsetPresent(arr, i - 1, sum);
		int sub1 = isSubsetPresent(arr, i - 1, sum - arr[i - 1]);
		return sub + sub1;
	}

	boolean isSUbSet(int[] arr, int n, int sum) {
		boolean[][] sub = new boolean[sum + 1][n + 1];

		for (int i = 0; i < sub[0].length; i++) {
			sub[0][i] = true;
		}
		for (int i = 1; i < sub.length; i++) {
			sub[i][0] = false;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				sub[i][j] = sub[i][j - 1];
				if (i >= arr[j - 1])
					sub[i][j] = sub[i][j] || sub[i - arr[j - 1]][j - 1];
			}
		}

		return sub[sum][n];

	}

	public boolean canPartitionInEqualSubSet(int[] arr) {

		int sum2 = Arrays.stream(arr).sum();
		if (sum2 % 2 != 0) {
			return false;
		}
		int sum = sum2 / 2;
		int n = arr.length;
		boolean[][] sub = new boolean[sum + 1][n + 1];

		for (int i = 0; i < sub[0].length; i++) {
			sub[0][i] = true;
		}
		for (int i = 1; i < sub.length; i++) {
			sub[i][0] = false;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				sub[i][j] = sub[i][j - 1];
				if (i >= arr[j - 1])
					sub[i][j] = sub[i][j] || sub[i - arr[j - 1]][j - 1];
			}
		}

		return sub[sum][n];

	}

}
