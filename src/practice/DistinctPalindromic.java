package practice;

import java.util.HashSet;
import java.util.Set;

public class DistinctPalindromic {

	public static void main(String[] args) {
		String s = "geeeek";
		System.out.println(count(s));
	}

	public static int count(String str) {
		int count = 0;
		if (str == null || str.trim().equals(""))
			return count;
		Set<String> set = new HashSet<String>();
		char[] c = str.toCharArray();
		for (char d : c) {
			set.add(String.valueOf(d));
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = i; j < c.length; j++) {
				String s = null;
				s = str.substring(i, j + 1);
				if (!s.isEmpty() && s.toString().equals(new StringBuilder(s).reverse().toString())) {
					set.add(s.toString());
				}
			}
		}
		System.out.println(set);
		return set.size();
	}

}
