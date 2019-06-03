package algoQuestions;

import java.util.Map;

public class GreedyAlogo { // m is size of coins array (number of different

	// coins)

	public static void main(String args[]) {
		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;

		// System.out.println("Minimum coins required is " + coinChanges(coins, 11, 0,
		// new HashMap<String, Long>()));
		System.out.println(minCoins(coins, m, V));
	}

	static int minCoins(int coins[], int m, int V) {
		if (V == 0)
			return 0;

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			// System.out.println("V = "+V+", m="+m+", Coins" + coins[i]);

			if (coins[i] <= V) {
				int sub_res = minCoins(coins, m, V - coins[i]);

				// Check for INT_MAX to avoid overflow and see if
				// result can minimized
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
					res = sub_res + 1;
					System.out.println("res value = " + res + "sub res = " + sub_res);
				}
			}
		}
		return res;
	}

	static int count = 0;

	public static long coinChanges(int[] coins, int money, int index, Map<String, Long> way) {

		if (money == 0)
			return 1;
		if (index >= coins.length)
			return 0;
		String key = money + "-" + index;
		if (way.containsKey(key)) {
			way.get(key);
		}

		int amountWithCoin = 0;
		long ways = 0;
		while (amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += coinChanges(coins, remaining, index + 1, way);
			amountWithCoin += coins[index];
		}
		way.put(key, ways);
		return ways;
	}

	static long getNumberOfWays(long N, long[] Coins) {
		// Create the ways array to 1 plus the amount
		// to stop overflow
		long[] ways = new long[(int) N + 1];

		// Set the first way to 1 because its 0 and
		// there is 1 way to make 0 with 0 coins
		ways[0] = 1;

		// Go through all of the coins
		for (int i = 0; i < Coins.length; i++) {

			// Make a comparison to each index value
			// of ways with the coin value.
			for (int j = 0; j < ways.length; j++) {
				if (Coins[i] <= j) {

					// Update the ways array
					ways[j] += ways[(int) (j - Coins[i])];
				}
			}
		}

		// return the value at the Nth position
		// of the ways array.
		return ways[(int) N];
	}

	static void printArray(long[] coins) {
		for (long i : coins)
			System.out.println(i);
	}

	public static int count(int S[], int m, int n) {
		int table[] = new int[n + 1];

		table[0] = 1;

		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];

		return table[n];
	}

}
