package algoQuestions;

import java.util.*;

public class LongestSubArrayHavingSumK {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 4, 3 };
		int k = 10;
		System.out.println("Length = " + longestSubArray(arr, k));

	}

	static int longestSubArray(int arr[], int k) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == k) {
				res = 1;
			}
			if (map.containsKey(sum - k))
				res = Math.max(res, i - map.get(sum - k));
			map.put(sum, map.getOrDefault(map.get(sum), i));

		}
		return res;
	}

}
