package algoQuestions;

public class EncryptedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s_1 = "abcd";
		String expected_1 = "bacd";
		String output_1 = findEncryptedWord(s_1);
		System.out.println(output_1);

	}

	static String findEncryptedWord(String s) {
		if ("".equals(s))
			return "";
		if (s.length() == 1)
			return s;
		int mid = (s.length() %2 !=0)? s.length() / 2 : (s.length()/2)-1;
		String string = "" + s.charAt(mid) + findEncryptedWord(s.substring(0, mid)) + findEncryptedWord(s.substring(mid + 1));
		return string;

	}

}
