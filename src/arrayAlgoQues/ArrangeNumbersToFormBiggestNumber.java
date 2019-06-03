package arrayAlgoQues;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeNumbersToFormBiggestNumber {

	public static void main(String[] args) {
		Integer arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
		
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = ""+o1+o2;
				String s2 = ""+o2+o1;
				return s2.compareTo(s1);
			}
		});
		
		for (Integer integer : arr) {
			System.out.print(integer);
		}
	}

}
