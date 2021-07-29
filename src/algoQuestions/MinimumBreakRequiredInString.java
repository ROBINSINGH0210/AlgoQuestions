package algoQuestions;

import java.util.*;

public class MinimumBreakRequiredInString {
	static int[] table;

	public static void main(String[] args) {

		Set<String> dic = new HashSet<>(Arrays.asList("Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"));

		String str = "CatMatat";
		table = new int[str.length() + 1];
		Arrays.fill(table, Integer.MAX_VALUE);
		System.out.println(minimumBreakReq(str, 0, dic));
		System.out.println(Arrays.toString(table));
	}

	static int minimumBreakReq(String s, int start, Set<String> dic) {
		if (start >= s.length()) {
			return 0;
		}
		if (dic.contains(s.substring(start))) {
			return 0;
		}
		if (table[start] != Integer.MAX_VALUE)
			return table[start];
		StringBuilder sb = new StringBuilder();
		int m = Integer.MAX_VALUE;
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (dic.contains(sb.toString())) {
				int res = minimumBreakReq(s, i + 1, dic);
				if (res != Integer.MAX_VALUE && res + 1 < m) {
					m = res + 1;
				}
			}

		}
		table[start] = m;
		return m;

	}

}
