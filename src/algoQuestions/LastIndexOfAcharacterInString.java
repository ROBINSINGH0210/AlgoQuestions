package algoQuestions;

public class LastIndexOfAcharacterInString {

	private static int maxIndex = Integer.MIN_VALUE;
	static int count =0;

	public static void main(String[] args) {
		String str = "Hello world!";

		System.out.println(getLastIndex(str.toCharArray(), 'e', 0, str.length() - 1));
		System.out.println(count);
	}

	public static int getLastIndex(char[] str, char c, int start, int end) {
		if (start >= end) {
			if (start == end && str[start] == c) {
				return start;
			}
			return -1;
		} else if (maxIndex > end) {
			return maxIndex;
		} else {
			count++;
			int mid = (start + end) / 2;
			if (str[mid] == c && maxIndex < mid) {
				maxIndex = mid;
				return mid;
			} else
				return Math.max(getLastIndex(str, c, mid + 1, end), getLastIndex(str, c, start, mid));
		}
	}
	
	public static int getLastIndex(char[] str, char c) {
		for(int i = str.length -1; i>=0; i--) {
			if(str[i] == c)
				return i;
		}
		return -1;
	}
}
