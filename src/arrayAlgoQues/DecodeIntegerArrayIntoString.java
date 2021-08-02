package arrayAlgoQues;

import java.util.*;

public class DecodeIntegerArrayIntoString {

	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 2, 2 };
		System.out.println(countDecodeIntArrToString(arr));
		HashSet<String> set = new HashSet<String>();
		printDecode("", arr, 0, set);
		System.out.println(set);
	}

	static int countDecodeIntArrToString(int[] arr) {
		int count[] = new int[arr.length + 1];
		count[0] = 1;
		count[1] = 1;
		if (arr[0] == 0)
			return 0;

		for (int i = 2; i <= arr.length; i++) {
			if (arr[i - 1] > 0) {
				count[i] = count[i - 1];
			}

			if (arr[i - 2] == 1 || (arr[i - 2] == 2 && arr[i - 1] < 7)) {
				count[i] += count[i - 2];
			}

		}
		return count[arr.length];
	}

	static void printDecode(String str, int[] arr, int i, Set<String> set) {
		if (i == arr.length)
			set.add(str);
		if (arr[0] == 0) {
			set.add("");
			return;
		}


		if (i < arr.length - 1 && (arr[i] > 0 || (arr[i] == 2 && arr[i] < 7))) {
			printDecode(str + ((char) ((arr[i] * 10 + arr[i + 1]) + 'a' - 1)), arr, i + 2, set);

		}
		if (i < arr.length && arr[i] > 0) {
			printDecode(str + ((char) (arr[i] + 'a' - 1)), arr, i + 1, set);
		}

	}
}
