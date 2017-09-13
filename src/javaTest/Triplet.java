package javaTest;

import java.util.*;

public class Triplet {

	/**
	 * 
	 * a^2 + b^2 = c^2.
	 * 
	 */
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(10, 4, 6, 12, 5);
		// Arrays.asList(3, 1, 4, 6, 5);
		containTriplet(l);

	}

	private static void containTriplet(List<Integer> list) {
		Set<Integer> l2 = new TreeSet<Integer>();
		Collections.sort(list);
		for (Integer item : list) {
			l2.add(item * item);
		}

		for (int i = 0; i < list.size() - 1; i++) {
			System.out.println(list.get(i) + " " + list.get(i + 1));
			System.out.println(l2.contains(list.get(i) + list.get(i + 1)));
			if (l2.contains(list.get(i) + list.get(i + 1))) {
				System.out.println("Contains ");
				break;
			}
		}
	}

}
