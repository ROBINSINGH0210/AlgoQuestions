package arrayAlgoQues;

import java.util.Arrays;

public class TargetSum {

	static int table[][];
	static int sum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		sum = Arrays.stream(nums).sum();
		table = new int[(sum * 2) + 1][nums.length + 1];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = Integer.MAX_VALUE;
			}
		}

		System.out.println(findTargetSumWays(nums, target, 0, 0));
	}

	public static int findTargetSumWays(int[] nums, int target, int currSum, int n) {
		if (n >= nums.length && target != currSum) {
			return 0;
		} else if (target == currSum && n >= nums.length) {
			return 1;
		}
		if (table[sum + currSum][n] != Integer.MAX_VALUE) {
			return table[sum + currSum][n];
		}

		int res = 0;
		res = findTargetSumWays(nums, target, currSum + nums[n], n + 1)
				+ findTargetSumWays(nums, target, currSum - nums[n], n + 1);
		table[sum + currSum][n] = res;
		return res;

	}

}
