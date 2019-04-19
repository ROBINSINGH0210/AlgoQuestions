package algoQuestions;

import java.io.*;
import java.util.HashMap;
import java.util.*;

public class SumOfDifferentCorrespondingBitsForAllPairs {
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int testCase = Integer.parseInt(br.readLine());
		// for (int k = 0; k < testCase; k++) {
		// int t = Integer.parseInt(br.readLine());
		// int arr[] = new int[t];
		// String line = br.readLine();
		// String[] strs = line.trim().split("\\s+");
		// for (int i = 0; i < t; i++) {
		// arr[i] = Integer.parseInt(strs[i]);
		// }
		// System.out.println(getSum(arr));
		// }

		getValue(3, new int[] { 1, 3, 5 });
	}

	private static int getSum(int arr[]) {
		int sum = 0;
		double mod = Math.pow(10, 9) + 7;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sum += (xorOfNums(arr[i], arr[j])) % mod;
			}
		}
		return sum;
	}

	private static void getValue(int num, int arr[]) {
		int result = 0, count = 0;
		for (int i = 0; i < 32; i++) {
			count = 0;
			for (int j = 0; j < num; j++) {
				if ((arr[j] & (1 << i)) != 0) {
					count++;
				}
			}
			result += count * (num - count) * 2;
		}
		System.out.println(result % 1000000007);
	}

	private static int xorOfNums(int a, int b) {
		String key = a + ":" + b;
		if (!map.containsKey(key)) {
			String s = Integer.toBinaryString(a ^ b);
			s = s.replaceAll("0", "");
			int length = s.length();
			map.put(key, length);
			return length;
		} else
			return map.get(key);
	}
}
