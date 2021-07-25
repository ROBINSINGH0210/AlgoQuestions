package arrayAlgoQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] { 1, 1, 1, 2, 2, 3,3,3,3 };
		System.out.println(remove(arr));

	}

	static List<Integer> remove(int arr[]) {
		List<Integer> list = new ArrayList<>();
//		removeUtil(arr, 0, arr.length - 1, list);
//		removeUtilPrint2(arr, 0, arr.length - 1, list, 1);
//		removeDuplicates(arr);
		List<List<Integer>> list1 = new ArrayList<>();
		removeU(arr, 0, arr.length-1, list1, 0);
		System.out.println(list1);
		return list;
	}

	static void removeUtil(int[] arr, int start, int end, List<Integer> list) {
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

	static void removeUtilPrint2(int[] arr, int start, int end, List<Integer> list, int count) {
		if (start > end) {
			return;
		}
		int mid = (start + end) / 2;
		if (arr[start] == arr[mid] && ((mid < arr.length - 1 && arr[mid + 1] != arr[start]) || mid == arr.length - 1)) {
			list.add(arr[start]);
			if (count >= 2 || (mid - start + 1) >= 2) {
				list.add(arr[start]);
			}
			if (mid < arr.length)
				removeUtilPrint2(arr, mid + 1, arr.length - 1, list, 1);
		} else if (arr[start] < arr[mid]) {
			removeUtilPrint2(arr, start, mid - 1, list, count);
		} else if (arr[start] == arr[mid]) {
			removeUtilPrint2(arr, mid + 1, end, list, count + 1);
		}

	}

	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int a : nums) {
			if (i < 2 || a > nums[i - 2]) {
				nums[i++] = a;
			}
		}

		return i;
	}

	static void removeU(int[] arr, int start, int end, List<List<Integer>> list, int count) {
		if (start > end) {
			return;
		}
		int mid = (start + end) / 2;
		if ((arr[start] == arr[mid]) && ((mid < arr.length - 1 && arr[mid + 1] != arr[start]) || mid == arr.length - 1)) {
			list.add(Arrays.asList(start, mid));
			if (mid < arr.length)
				removeU(arr, mid + 1, arr.length - 1, list, 1);
		} else if (arr[start] < arr[mid]) {
			removeU(arr, start, mid - 1, list, count);
		} else if (arr[start] == arr[mid]) {
			removeU(arr, start, mid+1+end, list, count + 1);
		}

	}
}
