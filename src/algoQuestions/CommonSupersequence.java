package algoQuestions;

public class CommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "AGGTAB", str2 = "GXTXAYB";
//		System.out.println(shortestCommonSuperSeq(str1, str2, str1.length(), str2.length()));
		System.out.println(longestCommonSubSequence(str1, str2, str1.length(), str2.length()));
	}

	public static int shortestCommonSuperSeq(String s, String p, int i, int j) {
		if (i == 0) {
			return j;
		}
		if (j == 0) {
			return i;
		}
		if (s.charAt(i - 1) == p.charAt(j - 1)) {
			return 1 + shortestCommonSuperSeq(s, p, i - 1, j - 1);
		} else
			return 1 + Math.min(shortestCommonSuperSeq(s, p, i - 1, j), shortestCommonSuperSeq(s, p, i, j - 1));

	}

	public static int shortestCommonSupSqDP(String str1, String str2) {
		int[][] table = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0)
					table[i][j] = j;
				else if (j == 0)
					table[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					table[i][j] = 1 + table[i - 1][j - 1];
				} else {
					table[i][j] = 1 + Math.min(table[i - 1][j], table[i][j - 1]);
				}
			}
		}

		return table[str1.length()][str2.length()];

	}

	static int longestCommonSubSequence(String X, String Y, int m, int n) {
		int[][] L = new int[m + 1][n + 1];
		int i, j;

		// Following steps build L[m + 1][n + 1]
		// in bottom up fashion. Note that
		// L[i][j] contains length of LCS
		// of X[0..i - 1]and Y[0..j - 1]
		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;

				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;

				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}

		// L[m][n] contains length of LCS
		// for X[0..n - 1] and Y[0..m - 1]
		return L[m][n];
	}
}