package goldman;

public class AnagramCheck {
	static int numberLetters =  (int)'z' - (int) ' ';

	static int[] getCharCount(String s) {
		int charArr[] = new int[numberLetters];
		int offset = (int) ' ';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int code = (int)c - offset;
			charArr[code]++;
		}
		return charArr;
	}

	public static boolean checkAnagram(String first, String second) {
		int firstArr[] = getCharCount(first);
		int secondArr[] = getCharCount(second);
		if (firstArr.length != secondArr.length) {
			return false;
		}

		for (int i = 0; i < secondArr.length; i++) {
			if (firstArr[i] != secondArr[i])
				return false;
		}
		return true;
	}

	public static int charReqForAnagram(String first, String second) {
		int firstArr[] = getCharCount(first);
		int secondArr[] = getCharCount(second);
		if (firstArr.length != secondArr.length) {
			return -1;
		}
		int a = 0;
		for (int i = 0; i < secondArr.length; i++) {
			a += Math.abs(firstArr[i] - secondArr[i]);
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(checkAnagram("robin singh Panwar", "robin singh panwar"));
		
		System.out.println(charReqForAnagram("robin", "ro"));

	}

}
