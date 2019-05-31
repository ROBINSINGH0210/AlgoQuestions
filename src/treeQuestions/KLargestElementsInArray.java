package treeQuestions;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class KLargestElementsInArray {

	public static void main(String... strings) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			list.add(ThreadLocalRandom.current().nextInt(1, 20 + 1));
		}
		// System.out.print("Array List Data" + list);
		getKLargestElementUsingArray(5, list);
		getKLargestElementUsingMap(5, list);

	}

	public static List<Integer> getKLargestElement(int k, List<Integer> list) {
		LinkedList<Integer> s = new LinkedList<>();
		Collections.sort(s);
		Collections.sort(list, Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			System.out.println(list.get(i));
		}
		return null;

	}

	public static void getKLargestElementUsingMap(int k, List<Integer> list) {
		System.out.println();
		Map<Integer, Integer> map = new TreeMap<>();
		// for (Integer value : list) {
		// if (trie.containsKey(value))
		// trie.put(value, trie.get(value) + 1);
		// else
		// trie.put(value, 1);
		// }
		list.parallelStream().forEach(e -> {
			if (map.containsKey(e)) {
				map.put(e, map.get(e) + 1);
			} else {
				map.put(e, 1);
			}
		});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= k) {
				System.out.println("Largest Element " + entry.getKey());
				break;
			} else
				k -= entry.getValue();
		}

		// Collections.sort(list);
		// System.out.println(list);
	}

	public static void getKLargestElementUsingArray(int k, List<Integer> list) {
		System.out.println();
		int max = list.parallelStream().mapToInt(e -> e).max().getAsInt() + 1;
		int temp[] = new int[max];
		int maxVal = Integer.MIN_VALUE;
		for (Integer value : list) {
			temp[value]++;
			if (maxVal < value)
				maxVal = value;
		}

		for (int i = 0; i <= maxVal; i++) {
			if (temp[i] >= k) {
				System.out.println("Largest Element " + i);
				break;
			} else
				k -= temp[i];
		}

	}

}
