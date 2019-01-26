package algoQuestions;

import java.util.Scanner;

public class SaveIronMan {

	public static void main(String[] args) {
		String s = "bb211234";
//		Scanner sc = new Scanner(System.in);
//		int testCase = sc.nextInt();
//		for (int k = 0; k < testCase; k++) {
//			while (sc.hasNext()) {
//				System.out.println(isPalidrome(sc.nextLine()));
//			}
//		}
		 System.out.println(isPalidrome(s));

	}

	private static String isPalidrome(String s) {

		int i = 0;
		int len = s.length() - 1;

		while (i < len) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			} else if (!Character.isLetterOrDigit(s.charAt(len))) {
				len--;
				continue;
			} else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(len))) {
				return "NO";
			}
			i++;
			len--;
		}

		return "YES";
	}
}
