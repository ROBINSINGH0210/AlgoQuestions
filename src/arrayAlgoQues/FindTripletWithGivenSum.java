package arrayAlgoQues;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author robin FindTripletWithGivenSum Space complexity O(n), Time complexity
 *         O(nlogn)
 */
public class FindTripletWithGivenSum {

	public static void main(String[] args) {
		int arr[] = new int[] { -1,0,1,2,-1,-4 };

//		System.out.println(findTriplet(arr, 20));
		System.out.println(threeSumEqualZero(arr));
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
	
	public static List<List<Integer>> threeSumEqualZero(int[] nums) {

		if (nums.length < 3) {
			return Collections.emptyList();
		}

		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				break;
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int target = -nums[i];
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				if (nums[j] + nums[k] == target) {
					set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				} else if (nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}
		}

		return set.stream().collect(Collectors.toList());
	}
}
