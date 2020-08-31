package algoQuestions;

import java.util.Comparator;
import java.util.TreeSet;

public class LongestPalindromeInAString {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaabbaa"));

	}
	
	public static String longestPalindrome(String str) {
		TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		if (str == null || str.trim().equals(""))
			return null;
		char[] c = str.toCharArray();
		for (char d : c) {
			set.add(String.valueOf(d));
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = i; j < c.length; j++) {
				String s = str.substring(i, j + 1);
				if (!s.isEmpty() && s.toString().equals(new StringBuilder(s).reverse().toString())) {
					set.add(s.toString());
				}
			}
		}
		return set.first();
	}
}
