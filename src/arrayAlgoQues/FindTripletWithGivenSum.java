package arrayAlgoQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTripletWithGivenSum {

	public static void main(String[] args) {
		int arr[] = new int[] {1,5,9,11,20,15};
		System.out.println(findTriplet(arr, 40));
	}

	static List<Integer> findTriplet(int arr[], int value) {
		List<Integer> list = new ArrayList<Integer>(4);
		Arrays.parallelSort(arr);
		Set<Integer> s = new HashSet<Integer>();
		Arrays.stream(arr).forEach(s::add);
		int i = 0, j = arr.length - 1, k = 1;

		while (i < j) {
			if (s.contains(value - (arr[i] + arr[j]))) {
				list.add(arr[i]);
				list.add(arr[j]);
				list.add(value - (arr[i] + arr[j]));
				break;
			} else if ((arr[i] + arr[j] + arr[k]) < value) {
				i++;
				k++;
			}else 
				j--;
		}

		return list;
	}
}
