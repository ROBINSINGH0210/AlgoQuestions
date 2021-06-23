package algoQuestions;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		String str = "India is best";

		System.out.println(reverse(str, 0, "", ""));
		System.out.println(reverseString(str, 0, new StringBuilder(), ""));
	}

	static String reverse(String str, int i, String out, String temp) {
		if (i >= str.length()) {
			return (temp + " " + out).trim();
		}

		if (str.charAt(i) != ' ')
			return reverse(str, i + 1, out, temp + str.charAt(i));
		else
			return reverse(str, i + 1, temp + " " + out, "");

	}

	static String reverseString(String str, int i, StringBuilder out, String temp) {
		if (i >= str.length()) {
			return (out.append(" " + temp)).toString();
		}

		if (str.charAt(i) != ' ') {
			return reverseString(str, i + 1, out, str.charAt(i) + temp);
		} else
			return reverseString(str, i + 1, (out.length()==0)? out.append(temp) : out.append(" " + temp), "");

	}

}
