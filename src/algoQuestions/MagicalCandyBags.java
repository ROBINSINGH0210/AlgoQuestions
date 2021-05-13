package algoQuestions;

import java.util.*;
import java.util.stream.IntStream;

public class MagicalCandyBags {

	public static void main(String[] args) {

		int n_1 = 5, k_1 = 3;
	    int[] arr_1 = {2, 1, 7, 4, 2};
	    int expected_1 = 14;
	    int output_1 = maxCandies(arr_1, k_1);
	    System.out.println(output_1);
	}
	
	static  int maxCandies(int[] arr, int k) {
		Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		IntStream.of(arr).forEach(e -> q.add(e));
		int j = k;
		int count = 0;
		while(j >0 && !q.isEmpty()) {
			Integer el = q.poll();
			count+=el;
			q.add(Math.floorDiv(el, 2));
			j--;
		}
		return count;
	    
	  }

}
