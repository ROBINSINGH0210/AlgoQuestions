package algoQuestions;

import java.util.LinkedList;
import java.util.List;

public class StockBuySell {

	public static void main(String[] args) {
//		int arr[] = new int[]  {100, 180, 260, 310, 40, 535, 695};

		int arr[] = new int[]  {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
		System.out.println(calculateBuySell(arr));
	}
	
	static List<Interval> calculateBuySell(int []arr){
		List<Interval> list = new LinkedList<>();
		
		int i =0;
		while(i< arr.length) {
			while(i< arr.length && arr[i+1] <= arr[i])
				i++;
				
			if(i >=arr.length )
				break;
			
			Interval interval = new Interval();
			interval.buy = i;
			
			while(i< arr.length -1 && arr[i] < arr[i+1])
				i++;
			
			interval.sell = i++;
			
			list.add(interval);
			
		}
		
		
		
		return list;
	}
}

class Interval{
	int buy;
	int sell;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Interval [buy=").append(buy).append(", sell=").append(sell).append("]");
		return builder.toString();
	}
	
	
	
}