package algoQuestions;

import java.util.*;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		System.out.println(getLongestSq(arr));
	}
	
	public static int getLongest(int arr[]) {
		int max= Integer.MIN_VALUE;
		List<Queue<Integer>> list = new  LinkedList<Queue<Integer>>();
		for(int i =0; i< arr.length; i++) {
			Queue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
			que.add(arr[i]);
			for(int j =i+1; j< arr.length; j++) {
				if(que.peek() < arr[j]) 
					que.add(arr[j]);
			}
			list.add(que);
		}
		
		for(Queue<Integer> quer:list) {
			if(quer.size() > max)
				max = quer.size();
		}
		
		return max;
		
	}
	
	public static int getLongestSq(int arr[]) {
		int max= Integer.MIN_VALUE;
		
		int count[] = new int[arr.length];
		
		for(int i =0; i< arr.length; i++) {
			count[i] =1;
			int maxSoFar = arr[i];
			for(int j =i+1; j< arr.length; j++) {
				if(maxSoFar < arr[j]) { 
					maxSoFar = arr[j];
					count[i] = count[i]+ 1;
				}
			}
		}
		
		for(Integer quer:count) {
			if(quer > max)
				max = quer;
		}
		return max;
	}

}
