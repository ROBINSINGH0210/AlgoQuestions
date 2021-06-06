package algoQuestions;

import java.util.*;

public class FindAnagrams {
 static	public List<Integer> findAnagrams(String s, String p) {
		int pArr[] = new int[26];
		// System.out.println('z'-'a');
		List<Integer> list = new ArrayList<Integer>();
		if (p.length() > s.length()) {
			return list;
		}
		int len = p.length();
		char[] arr = p.toCharArray();
		for (char p1 : arr) {
			pArr[p1 - 'a']++;
		}
		// Arrays.sort(arr);
		int i = 0;
		String substring = s.substring(i, i + len);
		int sArr[] = new int[26];
		for (char p1 : substring.toCharArray()) {
			sArr[p1 - 'a']++;
		}
		if (isAnagram(pArr, sArr)) {
			list.add(i);
		}
		for (int j = i + len; j < s.length(); j++) {
				sArr[s.charAt(i) - 'a']--;
				sArr[s.charAt(j) - 'a']++;
				if (isAnagram(pArr, sArr))
					list.add(i+1);

			i++;
		}

		return list;

	}

 static	boolean isAnagram(int pArr[], int[] sArr) {
		for (int i = 0; i < 26; i++) {
			if (pArr[i] != sArr[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s =  "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));

	}
}
