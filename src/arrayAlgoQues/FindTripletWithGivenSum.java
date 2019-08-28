package arrayAlgoQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author robin FindTripletWithGivenSum Space complexity O(n), Time complexity
 *         O(nlogn)
 */
public class FindTripletWithGivenSum {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 4, 90, 99, 1000 };

		System.out.println(findTriplet(arr, 1003));
	}

	static List<Integer> findTriplet(int arr[], int value) {
		List<Integer> list = new ArrayList<Integer>(4);
		Arrays.parallelSort(arr);
		Set<Integer> s = new HashSet<Integer>();
		Arrays.stream(arr).forEach(s::add);
		int i = 0, j = arr.length - 1;

		while (i < j) {
			int k2 = value - (arr[i] + arr[j]);
			if (arr[i] != k2 && arr[j] != k2 && s.contains(k2)) {
				list.add(arr[i]);
				list.add(arr[j]);
				list.add(k2);
				break;
			} else if ((arr[i] + arr[j]) < value)
				i++;
			else
				j--;
		}

		return list;
	}
}
