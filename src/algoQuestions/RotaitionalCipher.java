package algoQuestions;

public class RotaitionalCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(115 % 90);
//		System.out.println((char) (90));
//		System.out.println((char) (64 + (115 % 90)));
		System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200));
	}

	static String rotationalCipher(String input, int rotationFactor) {
		// Write your code here
		char c[] = input.toCharArray();
		char res[] = new char[input.length()];
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 65 && c[i] <= 90) {
				res[i] = (char) (((c[i] - 'A' + rotationFactor) % 26) + 'A');
			} else if (c[i] >= 48 && c[i] <= 57) {
					res[i] =(char) (((c[i] - '0' + rotationFactor) % 10) + '0');
			} else if (c[i] >= 97 && c[i] <= 122) {
					res[i] = (char) (((c[i] - 'a' + rotationFactor) % 26) + 'a');
			} else {
				res[i] = c[i];
			}
		}
		return new String(res);
	}
}
