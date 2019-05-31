package goldman;

public class MergeSortTest {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 1, 2, 34, 4, 121, 4, 12, 111 };

		for (int i : mergeSort(arr, 0, arr.length - 1, new int[arr.length])) {
			System.out.println(i);
		}

	}

	static int[] mergeSort(int arr[], int start, int end, int temp[]) {
		if (start >= end) {
			return arr;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid, temp);
		mergeSort(arr, mid + 1, end, temp);
		merge(arr, start, mid, end, temp);
		return arr;
	}

	static void merge(int[] arr, int start, int mid, int end, int[] temp) {
		for (int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}
		int i = start;
		int j = mid + 1;
		int k = start;
		while (i <= j && j <= end) {
			if (temp[i] <= temp[j]) {
				arr[k++] = temp[i++];
			} else {
				arr[k++] = temp[j++];
			}
		}
		while (i <= mid) {
			arr[k++] = temp[i++];
		}
		while (j <= mid) {
			arr[k++] = temp[j++];
		}

	}

}
