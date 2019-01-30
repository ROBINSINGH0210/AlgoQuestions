package algoQuestions;

import java.util.Scanner;

public class LargestWordInDict {

	public static void main(String[] args) {
//		String[] dict = { "pintu", "geeksfor", "geeksgeeks", " forgeek" };
//		String str = "geeksforgeeks";
//		System.out.println(getDict(str, dict));

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int k = 0; k < testCase; k++) {
			int t = sc.nextInt();
			sc.nextLine();
			String ar[] = sc.nextLine().split(" ");
			String st = sc.nextLine();
			System.out.println(getDict(st, ar));
		}
	}

	private static String getDict(String str, String arr[]) {

		int lowestSoFar = Integer.MAX_VALUE;
		String dcts = "";

		for (String dct : arr) {
			String s = new String(str);
			for (int i = 0; i < dct.length(); i++) {
				s = s.replaceFirst(Character.toString(dct.charAt(i)), "");
			}
			if (s.length() < lowestSoFar) {
				lowestSoFar = s.length();
				dcts = dct;
			}
		}

		return dcts;
	}
}
