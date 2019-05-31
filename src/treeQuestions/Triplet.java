package treeQuestions;

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

	public boolean findTriplets(int arr[], int n) {
		Arrays.sort(arr);
		int zeroIndex = -1;
		int posStartIndex = -1;
		int negEndIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && zeroIndex < 0)
				zeroIndex = i;
			if (arr[i] > 0 && posStartIndex < 0)
				posStartIndex = i;
			if (arr[i] < 0) 
				posStartIndex = i;
			if (zeroIndex > -1 && posStartIndex > -1 && negEndIndex > -1) {
				break;
			}
		}

		if ((posStartIndex > -1 && negEndIndex == -1) || (posStartIndex == -1 && negEndIndex > -1)) {
			return false;
		} else if (posStartIndex == -1 && negEndIndex == -1 && zeroIndex > -1) {
			return true;
		}

//		for() {
//			
//		}
		
		return false;
	}

}
