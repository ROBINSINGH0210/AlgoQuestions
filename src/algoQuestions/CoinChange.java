package algoQuestions;

import java.util.Arrays;

public class CoinChange {

	static int table[];
	static int t[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3 };
		int amt = 4;
		table = new int[amt + 1];
		t = new int[arr.length + 1][amt + 1];
		Arrays.fill(table, -1);
//		System.out.println(distinctWays(arr, amt));
//		System.out.println(distinctWays(arr, amt, arr.length - 1));

		System.out.println(minCoins(arr, amt, 0));
		System.out.println(Arrays.toString(table));
	}

	static int coinChangeWays(int[] coins, int amt) {
		int [][]table = new int[coins.length+1][amt+1];
		
		for(int i =1; i<= coins.length; i++) {
			for(int j =1; j<= amt; j++) {
				if(j >= coins[i-1]) {
					table[i][j] = table[i-1][j] + table[i][j- coins[i-1]];
				}
			}
		}
		
		return table[coins.length][amt];
	}

	static int coinChange(int[] coins, int amt) {
		if (amt == 0) {
			return 1;
		}
		if (amt < 0) {
			return 0;
		}
		if (table[amt] != -1)
			return table[amt];
		int res = 0;
		for (int i = 0; i < coins.length; i++) {
			int s = coinChange(coins, amt - coins[i]);
			if (s > 0) {
				res += s;
			}
			table[amt] = res;
		}
		return res;
	}

	static int distinctWays(int[] coins, int amt, int n) {
		if (amt == 0)
			return 1;
		if (amt < 0 || n < 0)
			return 0;
		if (t[amt][n] > 0) {
			return t[amt][n];
		}

		int left = distinctWays(coins, amt, n - 1);
		int right = distinctWays(coins, amt - coins[n], n);
		t[amt][n] = left + right;
		return left + right;
	}

	static int distinctWays(int[] coins, int amt) {
		if (amt <= 0) {
			return 0;
		}
		for (int i = 0; i < t.length; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amt; j++) {
				if (coins[i - 1] > j) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
				}
			}
		}

		return t[coins.length][amt];
	}

	static int minCoins(int[] coins, int amt, int n) {
		if (amt == 0) {
			return 0;
		}
		if (amt < 0) {
			return -1;
		}
		if (table[amt] != -1)
			return table[amt];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amt) {
				int res = minCoins(coins, amt - coins[i], n);
				if (res + 1 < min && res != Integer.MAX_VALUE) {
					min = res + 1;
				}
			}
		}
		table[amt] = min;
		return min;
	}

}
