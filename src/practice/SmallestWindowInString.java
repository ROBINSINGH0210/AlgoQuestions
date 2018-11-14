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
		int first = -1;
		int lastSo = -1;
		int diffd = Integer.MAX_VALUE;
		int start = 0;
		while (start < str.length()) {
			int tempFirst = -1;
			int tempLast = -1;
			int tempDiff = -1;
			List<Character> s = new ArrayList<Character>(strSet);
			for (int i = start; i < str.length() && !s.isEmpty(); i++) {
				if (s.remove(Character.valueOf(str.charAt(i)))) {
					if (tempFirst < 0)
						tempFirst = i;
					else
						tempLast = i;
					tempDiff = tempLast - tempFirst;
				}
			}

			if (s.isEmpty()) {
				if (diffd > tempDiff) {
					first = tempFirst;
					lastSo = tempLast;
					diffd = tempDiff;
				}
			}
			start++;
		}
		if (first > 0 && lastSo > 0) {
			return str.substring(first, lastSo + 1);
		}
		return null;
	}

}
