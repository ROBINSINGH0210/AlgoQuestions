package algoQuestions;

import java.util.HashMap;

public class MinimumLengthSubstrings {

	public static void main(String[] args) {
		String s_1 = "dcbefebce";
		String t_1 = "fd";
		int expected_1 = 5;
		int output_1 = minLengthSubstring(s_1, t_1);
		System.out.println(output_1);
	}

	static int minLengthSubstring(String s, String t) {
		int start = 0;
		int a = -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int min = Integer.MAX_VALUE;
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(map.get(c), 0)+1);
		}
		char arr[] = s.toCharArray();
		while (start < arr.length) {
			HashMap<Character, Integer> temp = (HashMap<Character, Integer>) map.clone();
			int count = 0;
			boolean found = false;
			a = -1;
			for (int i = start; i < arr.length; i++) {
				if (temp.containsKey(arr[i])) {
					found = true;
					if (a < 0)
						a = i;
					if (temp.get(arr[i]) > 1) {
						temp.put(arr[i], map.get(arr[i]) - 1);
					} else {
						temp.remove(arr[i]);
					}
				}
				if(found)
					count++;
				if (temp.isEmpty()) {
					min = Math.min(count, min);
					break;
				}
			}
			if(a>0) {start = a+1;}else
			start++;
		}
		
		if(min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}
	
	 public String minWindow(String s, String t) {
		    int [] map = new int[128];
		    for (char c : t.toCharArray()) {
		      map[c]++;
		    }
		    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		    while (end < s.length()) {
		      final char c1 = s.charAt(end);
		      if (map[c1] > 0) counter--;
		      map[c1]--;
		      end++;
		      while (counter == 0) {
		        if (minLen > end - start) {
		          minLen = end - start;
		          minStart = start;
		        }
		        final char c2 = s.charAt(start);
		        map[c2]++;
		        if (map[c2] > 0) counter++;
		        start++;
		      }
		    }

		    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
		  }
}
