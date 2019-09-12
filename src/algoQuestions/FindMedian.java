package algoQuestions;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedian {

	static Queue<Integer> higher = new PriorityQueue<>();
	static Queue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) {
		PriorityQueue<Integer> highsser = new PriorityQueue<>();
//		Scanner sc = new Scanner(System.in);
//		int testCase = sc.nextInt();
//		for (int k = 0; k < testCase; k++) {
//				System.out.println(median(sc.nextInt()));
//		}
		int arr[] = {9384,887};
		for (int i : arr) {
			System.out.println(median(i));
		}
	}

	static int median(Integer number) {
		if(lower.isEmpty() || number < lower.peek()) 
			lower.add(number);
		else
			higher.add(number);
		
		balanceHeap(higher,lower);
		return getMedian(higher,lower);
	}

	private static int getMedian(Queue<Integer> higher2, Queue<Integer> lower2) {
		if(higher2.size()==lower2.size()) {
			return (higher2.peek()+lower2.peek())/2;
		}else if(higher2.size() > lower2.size()) {
			return higher2.peek();
		}else
			return lower2.peek();
		
	}

	private static void balanceHeap(Queue<Integer> higher, Queue<Integer> lower) {
		Queue<Integer> highSize = (higher.size() > lower.size()) ? higher : lower;
		Queue<Integer> lowSize = (higher.size() > lower.size()) ? lower : higher; 
		
		if((highSize.size() - lowSize.size()) >= 2) 
			lowSize.add(highSize.poll());
	}
}
