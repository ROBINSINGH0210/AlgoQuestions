package arrayAlgoQues;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] { 1, 1, 2, 2, 2, 3, 4, 4, 4, 4 };
		System.out.println(remove(arr));

	}

	static List<Integer> remove(int arr[]) {
		List<Integer> list = new ArrayList<>();
		removeUtil(arr, 0, arr.length - 1, list);
		return list;
	}

	private static void removeUtil(int[] arr, int start, int end, List<Integer> list) {
		if (start > end) {
			return;
		}
		int mid = (start + end) / 2;
		if (arr[start] == arr[mid] && ((mid < arr.length - 1 && arr[mid + 1] != arr[start]) || mid == arr.length - 1)) {
			list.add(arr[start]);
			if (mid < arr.length)
				removeUtil(arr, mid + 1, arr.length - 1, list);
		} else if (arr[start] < arr[mid]) {
			removeUtil(arr, start, mid - 1, list);
		} else if (arr[start] == arr[mid]) {
			removeUtil(arr, mid + 1, end, list);
		}

	}
	
	

}
