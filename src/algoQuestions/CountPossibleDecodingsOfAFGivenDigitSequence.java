package algoQuestions;

public class CountPossibleDecodingsOfAFGivenDigitSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int countPossible(char[] s) {
		int n = s.length;

		// Array to store the dp states
		int[] dp = new int[n + 1];

		// Case of empty String
		dp[0] = 1;

		// Condition to check if the
		// first character of String is 0
		if (s[0] == '0')
			return 0;

		// Base case for single length
		// String
		dp[1] = ((s[0] == '*') ? 9 : 1);

		// Bottom-up dp for the String
		for (int i = 2; i <= n; i++) {

			// Previous character
			char first = s[i - 2];

			// Current character
			char second = s[i - 1];

			// Case to include the Current
			// digit as a single digit for
			// decoding the String
			if (second == '*') {
				dp[i] += 9 * dp[i - 1];
			} else if (second > '0')
				dp[i] += dp[i - 1];

			// Case to include the current
			// character as two-digit for
			// decoding the String
			if (first == '1' || first == '2') {

				// Condition to check if the
				// current character is "*"
				if (second == '*') {
					if (first == '1')
						dp[i] += 9 * dp[i - 2];
					else if (first == '2')
						dp[i] += 6 * dp[i - 2];
				}

				// Condition to check if the
				// current character is less than
				// or equal to 26
				else if (((first - '0') * 10 + (second - '0')) <= 26) {
					dp[i] += dp[i - 2];
				}
			}

			// Condition to check if the
			// previous digit is equal to "*"
			else if (first == '*') {
				if (second == '*') {
					dp[i] += 15 * dp[i - 2];
				} else if (second <= '6') {
					dp[i] += 2 * dp[i - 2];
				} else {
					dp[i] += dp[i - 2];
				}
			}
		}
		return dp[n];
	}
}
