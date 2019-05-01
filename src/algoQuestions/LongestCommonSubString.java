package algoQuestions;

public class LongestCommonSubString {

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		System.out.println(longestCommonLength(s1, s2));

	}

	static int longestCommonLength(String str1, String str2) {
		int dp[][] = new int[str1.length()][str2.length()];
		int max = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if ((i == 0 || j == 0) && str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1;
				} else if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > max)
						max = dp[i][j];
				}
			}

		}

		return max;
	}

}
