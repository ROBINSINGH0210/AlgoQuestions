package algoQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteArrayWithDuplicates {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30 };

		ArrayList<int[]> list = new ArrayList<int[]>();
		permuteArray(0, arr, list);
		for (int[] is : list) {
			System.out.println(Arrays.asList(is));
		}
		
//		List<List<Integer>> permute = pa.permute(arr);
//
//		
//		for (List<Integer> perm : permute) {
//			System.out.println(perm);
//		}

	}

	public List<List<Integer>> permute(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(arr);
		permuteHelper(list, new ArrayList<>(), arr, new boolean[arr.length]);
		return list;
	}

	private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr, boolean[] used) {

		// Base case
		if (resultList.size() == arr.length) {
			list.add(new ArrayList<>(resultList));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (used[i] || i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
					// If element is already used
					continue;
				}
				// choose element
				used[i] = true;
				resultList.add(arr[i]);

				// Explore
				permuteHelper(list, resultList, arr, used);

				// Unchoose element
				used[i] = false;
				resultList.remove(resultList.size() - 1);
			}
		}
	}

	public static void permuteArray(int start, int[] arr, List<int[]> list) {
		if (start >= arr.length) {
			list.add(arr.clone());
		}

		for (int i = start; i < arr.length; i++) {
			swap(arr, start, i);
			permuteArray(start + 1, arr, list);
			swap(arr, start, i);
		}

	}

	private static void swap(int[] arr, int start, int i) {
		int temp = arr[start];
		arr[start] = arr[i];
		arr[i] = temp;
	}

}