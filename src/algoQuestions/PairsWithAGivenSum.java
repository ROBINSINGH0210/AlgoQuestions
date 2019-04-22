package algoQuestions;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PairsWithAGivenSum {

	public static void main(String[] args) {
		int arr1[] = new int[] { 1, 2, 4, 5, 7 };
		int arr2[] = new int[] { 5, 6, 3, 4, 8 };
		System.out.println(findPairs(arr1, arr2, 9));

	}

	public static Set<String> findPairs(int arr1[], int arr2[], int sum) {
		Set<String> set = new TreeSet<>();
		Set<Integer> numSet = new HashSet<>();
		for (Integer integer : arr1) {
			numSet.add(integer);
		}

		for (Integer integer : arr2) {
			if (numSet.contains(sum - integer))
				set.add(sum - integer + " " + integer);
		}

		return set;

	}

}
