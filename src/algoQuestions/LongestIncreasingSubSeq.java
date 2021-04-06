package algoQuestions;

import java.util.*;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60,70,3 }; 
		System.out.println(getLongest(arr));
	}
	
	public static int getLongest(int arr[]) {
		Queue<Integer> q = null ;
		for(int i =0; i< arr.length; i++) {
			Queue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
			temp.add(arr[i]);
			for(int j =i+1; j< arr.length; j++) {
				if(temp.peek() < arr[j]) 
					temp.add(arr[j]);
			}
			if(q.size() < temp.size()) {
				q = temp;
			}
		}
		return q.size();
		
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
