package arrayTest;

import java.util.Arrays;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
		int arr[] = { 12, 1, 2, 3, 6, 7, 8, 10 };
		System.out.println(findMinElement(arr, 3));
	}

	static int findMinElement(int[] arr, int element) {
		int max = arr.length;
		int pivot = -1;
		pivot = findPivot(arr, 0, arr.length - 1);
		System.out.println(pivot);
		if (pivot > -1 && arr[pivot] == element)
			return pivot;
		else if (arr[pivot] < element && arr[max - 1] > element)
			return Arrays.binarySearch(arr, pivot, max - 1, element);
		else
			return Arrays.binarySearch(arr, 0, pivot - 1, element);

	}

	static int findPivot(int arr[], int start, int end) {
		if (end < start)
			return -1;
		else if (start == end)
			return start;

		int mid = (end + start) / 2;
		if (arr[mid] < arr[mid - 1]) {
			return mid;
		} else if (arr[mid] > arr[mid + 1]) {
			return mid + 1;
		} else {
			if (arr[mid] > arr[end])
				return findPivot(arr, mid, end);
			else
				return findPivot(arr, start, mid - 1);

		}
	}

}
