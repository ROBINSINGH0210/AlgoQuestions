package algoQuestions;

public class RegularExpressionMatching {

	private static Boolean[][] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

		if (p.length() >= 2 && p.charAt(1) == '*') {
			return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
		} else {
			return first_match && isMatch(s.substring(1), p.substring(1));
		}
	}

	public boolean dp(int i, int j, String text, String pattern) {
		if (memo[i][j] != null) {
			return memo[i][j] == true;
		}
		boolean ans;
		if (j == pattern.length()) {
			ans = i == text.length();
		} else {
			boolean first_match = (i < text.length()
					&& (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

			if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
				ans = (dp(i, j + 2, text, pattern) || first_match && dp(i + 1, j, text, pattern));
			} else {
				ans = first_match && dp(i + 1, j + 1, text, pattern);
			}
		}
		memo[i][j] = ans ? true : false;
		return ans;
	}

}
