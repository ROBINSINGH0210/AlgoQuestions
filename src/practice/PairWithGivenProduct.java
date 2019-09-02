package practice;

public class PairWithGivenProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 10, 20, 9, -30 };
		int x = -400;
		System.out.println(isPairPresent(arr, x));

	}

	private static boolean isPairPresent(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (x == (arr[i] * arr[j])) {
						return true;
					}
				}
			}

		}
		return false;
	}

}
