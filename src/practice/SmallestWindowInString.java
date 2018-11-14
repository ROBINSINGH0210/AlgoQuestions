package practice;

import java.util.ArrayList;
import java.util.List;

public class SmallestWindowInString {

	public static void main(String[] args) {
		System.out.println(smallestWindow("geeksforgeeks", "ork"));
	}

	public static String smallestWindow(String str, String sub) {
		List<Character> strSet = new ArrayList<Character>();
		for (Character character : sub.toCharArray()) {
			strSet.add(character);
		}
		int firstSo = -1;
		int lastSofar = -1;
		int diffd = Integer.MAX_VALUE;
		int start = 0;
		while (start < str.length()) {
			int first = -1;
			int last = -1;
			int diff = -1;
			List<Character> s = new ArrayList<Character>(strSet);
			for (int i = start; i < str.length() && !s.isEmpty(); i++) {
				if (s.remove(Character.valueOf(str.charAt(i)))) {
					if (first < 0)
						first = i;
					else
						last = i;
					diff = last - first;
				}
			}

			if (s.isEmpty()) {
				if (diffd > diff) {
					firstSo = first;
					lastSofar = last;
					diffd = diff;
				}
			}
			start++;
		}
		if (firstSo > 0 && lastSofar > 0) {
			return str.substring(firstSo, lastSofar + 1);
		}
		return null;
	}

}
