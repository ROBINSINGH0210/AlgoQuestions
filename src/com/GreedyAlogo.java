package com;

public class GreedyAlogo { // m is size of coins array (number of different
							// coins)
	static int minCoins(int coins[], int m, int V) {
		// base case
		if (V == 0)
			return 0;

		// Initialize result
		int res = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for (int i = 0; i < m; i++) {
//			System.out.println("V = "+V+", m="+m+", Coins" + coins[i]);
			
			if (coins[i] <= V) {
				int sub_res = minCoins(coins, m, V - coins[i]);

				// Check for INT_MAX to avoid overflow and see if
				// result can minimized
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res){
					res = sub_res + 1;
					System.out.println("res value = "+res +"sub res = "+sub_res );
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;
		System.out.println("Minimum coins required is " + minCoins(coins, m, V));
	}
}
