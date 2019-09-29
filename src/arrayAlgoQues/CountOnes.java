package arrayAlgoQues;

class CountOnes {
	int countOnes(int arr[], int low, int high) {
		if (high >= low) {
			int mid = low + (high - low) / 2;

			if ((mid == high || arr[mid + 1] == 0) && (arr[mid] == 1))
				return mid + 1;

			if (arr[mid] == 1)
				return countOnes(arr, (mid + 1), high);

			return countOnes(arr, low, (mid - 1));
		}
		return 0;
	}

	public static void main(String args[]) {
		CountOnes ob = new CountOnes();
		int arr[] = { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 };
		int n = arr.length;
		System.out.println("Count of 1's in given array is " + ob.countOnes(arr, 0, n - 1));
	}
}