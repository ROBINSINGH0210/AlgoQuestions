package algoQuestions;

public class PainterPartitionProb {

	public static void main(String[] args) {
		int arr[] = { 100, 200, 300, 400, 500, 600, 700, 800, 900 };
		int k = 3;
		System.out.println(partition(arr, k));
	}

	static int partition(int arr[], int k) {

		int lo = low(arr);
		int hi = sum(arr);

		while (lo < hi) {
			int mid = lo + ((hi -lo) / 2);
			int x = findPainters(arr, mid);
			if (x <= k)
				hi = mid;
			else
				lo = mid + 1;
		}

		return lo;
	}

	private static int findPainters(int[] arr, int mid) {
		int count = 1;
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
			if (total > mid) {
				count++;
				total = arr[i];
			}
		}

		return count;
	}

	private static int sum(int[] arr) {
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			i += arr[j];
		}
		return i;
	}

	private static int low(int[] arr) {
		int i = Integer.MIN_VALUE;
		for (int j = 0; j < arr.length; j++) {
			if (i < arr[j]) {
				i = arr[j];
			}
		}
		return i;
	}

}
