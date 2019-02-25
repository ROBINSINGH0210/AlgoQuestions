package algoQuestions;

import java.util.Scanner;

public class FormAPalindrome {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		int T = scanner.nextInt();
//
//		for (int t = 0; t < T; t++) {
//			// Do not mix next and nextLine, it gets confusing for the scanners!
//			String str1 = scanner.next();
//
//			System.out.println(count(str1));
//		}

		String string = "geeks";
		System.out.println(findMinInsertions(string.toCharArray(),0,string.length()-1));
	}

	public static int count(String str) {
		int max = Integer.MAX_VALUE;
		if (isPalindrome(str))
			return 0;
		else {
			StringBuilder st2 = new StringBuilder(str).reverse();
			for (int i = str.length(); i > 0; i--) {
				String substring = st2.substring(0, i);
				String temp = substring + str;
				if (isPalindrome(temp)) {
					if (max > substring.length()) {
						max = substring.length();
					}
				}

			}

		}
		return max;
	}

	static int findMinInsertions(char str[], int l, int h) {
		// Base Cases
		if (l > h)
			return Integer.MAX_VALUE;
		if (l == h)
			return 0;
		if (l == h - 1)
			return (str[l] == str[h]) ? 0 : 1;

		// Check if the first and last characters
		// are same. On the basis of the comparison
		// result, decide which subrpoblem(s) to call
		return (str[l] == str[h]) ? findMinInsertions(str, l + 1, h - 1)
				: (Integer.min(findMinInsertions(str, l, h - 1), findMinInsertions(str, l + 1, h)) + 1);
	}

	public static boolean isPalindrome(String str) {
		StringBuilder st = new StringBuilder(str);
		StringBuilder st2 = new StringBuilder(str).reverse();
		return st.toString().equals(st2.toString());
	}
}
