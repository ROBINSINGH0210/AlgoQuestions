package algoQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindPairsForGivenSum {
//	[1,3,5, 8,10, 4, 6, 2] target = 8

	public static void main(String[] args) {
		int num = 8;
		List<Integer> arr = Arrays.asList( 1, 2, 3, 4, 5, 6, 8);
		Set<Set<Integer>> list = new HashSet<Set<Integer>>();
		Set<Integer> s = new HashSet<Integer>(arr);
		s.add(0);
//		8 - 1 =7 -2 = 5 , 1,2,5
		int j, k;
		for (int i = 0; i < arr.size(); i++) {
			k = i;
			while (k < arr.size()) {
				Set<Integer> l = new TreeSet<>();
				l.add(arr.get(i));
				if (arr.get(i) == num) {
					list.add(l);
				} else {
					int sum =0 ;
					for (j = k+1; j < arr.size(); j++) {
						l.add(arr.get(j));
						 sum += arr.get(i) + arr.get(j);
						int diff = num - sum;
						if (sum <= num && s.contains(diff) && diff != arr.get(i)
								&& diff != arr.get(j)) {
							if (diff != 0)
								l.add(diff);
							list.add(l);
							break;
						}
					}
				}
				k++;
			}
		}
		System.out.println(list);
	}

}
