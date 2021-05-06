package algoQuestions;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PairsOfGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int k_2 = 6;
	    int[] arr_2 = {1, 5, 3, 3, 3};
	    int expected_2 = 4;
	    int output_2 = numberOfWays(arr_2, k_2);
	    System.out.println(output_2);
	}

	static int numberOfWays(int[] arr, int k) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int count = 0;
		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else
				map.put(a, 1);
		}
		for (int a : arr) {
			if (map.containsKey(Math.abs(k - a))) {
				if (a != k - a) {
					count += Math.min(map.get(a), map.get(Math.abs(k - a)));
					map.remove(a);
					map.remove(Math.abs(k - a));
				} else if (map.get(a) > 1) {
					count += (map.get(a)* (map.get(a) -1)) / 2;
					map.remove(a);
				}
			}
		}

		return count;
	}
}
