package algoQuestions;

import java.util.*;

public class PhoneNumberCode {

	public static void main(String[] args) {
		System.out.println(letterCombinations("12"));

	}

	public static List<String> letterCombinations(String digits) {
		if (digits == null)
			return null;
		List<String> res = new ArrayList<String>();
		res.add("");
		String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		for (int i = 0; i < digits.length(); i++) {
			String letter = letters[digits.charAt(i) - '1'];
			List<String> newRes = new ArrayList<String>();
			for (int j = 0; j < letter.length(); j++) {
				for (String s : res) {
					s += letter.charAt(j);
					newRes.add(s);
				}
			}
			res = newRes;
		}
		return res;
	}
}
