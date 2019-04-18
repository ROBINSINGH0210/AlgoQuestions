package algoQuestions;

public class RemoveAdjcentDuplicates {

	public static void main(String[] args) {

		char c = ' ';
//		System.out.println(removeDuplicates("aaaaabbbcddcf", c, 0, 1));
		System.out.println(remove("aaaaababbcddcf", c, 0));
	}

	static String removeDuplicates(String str, char lastChar, int from, int to) {
		if (str == null || str.substring(from).equals("")) {
			return str;
		}

		if (str.charAt(from) == str.charAt(to)) {
			to++;
			lastChar = str.charAt(from);
			str = removeDuplicates(str, lastChar, from, to);
		} else {
			lastChar = str.charAt(to);
			from = to;
			str = removeDuplicates(str.substring(to++), lastChar, from, to);
		}

		return str;
	}

	static String remove(String str, char lastChar, int currentIndex) {
		if (str == null || str.substring(currentIndex).equals("")) {
			return str;
		}

		if (lastChar == str.charAt(currentIndex)) {
			str = remove(str.substring(0, currentIndex) + str.substring(currentIndex + 1), lastChar, currentIndex);
		} else {
			lastChar = str.charAt(currentIndex);
			str = remove(str, lastChar, currentIndex + 1);
		}

		return str;
	}

}
