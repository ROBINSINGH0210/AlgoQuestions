package microsoft;

import java.util.*;

public class IntersectionsBetweenArray {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 4, 6, 9, 16, 12 };
		int arr2[] = { 10, 15, 7, 6, 9, 26, 62 };
		int arr3[] = { 31, 22, 94, 6, 9, 46, 72 };
		Map<Integer, Integer> map = find(arr1, arr2, arr3);
		System.out.println(map);
		System.out.println(intersection(map));
		System.out.println(union(map));

	}

	static Map<Integer, Integer> find(int[] arr1, int[] arr2, int arr3[]) {
		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i]))
				map.put(arr1[i], map.get(arr1[i]) + 1);
			else
				map.put(arr1[i], 1);

			if (map.containsKey(arr2[i]))
				map.put(arr2[i], map.get(arr2[i]) + 1);
			else
				map.put(arr2[i], 1);

			if (map.containsKey(arr3[i]))
				map.put(arr3[i], map.get(arr3[i]) + 1);
			else
				map.put(arr3[i], 1);
		}
		return map;
	}
	
	
	static Set<Integer> intersection(Map<Integer,Integer> map){
		Set<Integer> el = new LinkedHashSet<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 3) {
				el.add(entry.getKey());
			}
		}
		return el;
	}
	
	

	static Set<Integer> union(Map<Integer,Integer> map){
		return map.keySet();
	}

}
