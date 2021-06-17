package arrayAlgoQues;

import java.util.*;


/**
 * @author robin FindTripletWithGivenSum Space complexity O(n), Time complexity
 *         O(nlogn)
 */
public class FindTripletWithGivenSum {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 6, 10, 11 };

		System.out.println(findTriplet(arr, 20));
	}

	static List<Integer> findTriplet(int arr[], int value) {
		List<Integer> list = new ArrayList<Integer>(4);
		Arrays.sort(arr);
		int i = 0, j = 1, k = arr.length - 1;

		while (j < k) {
			if (arr[i] + arr[j] + arr[k] == value) {
				list.add(arr[i]);
				list.add(arr[j]);
				list.add(arr[k]);
				break;
			} else if ((arr[i] + arr[j] + arr[k]) > value)
				k--;
			else if (i >= j - 1)
				j++;
			else
				i++;
		}

		return list;
	}
}
