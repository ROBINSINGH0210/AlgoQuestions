package algoQuestions;
public class ReverseWordsInSentence {

	public static void main(String[] args) {
		String str = "India is best";

		System.out.println(reverse(str, 0, "", ""));
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

}
