package arrayAlgoQues;

import java.util.*;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfit(2, arr));
	}

	public static int maxProfit(int k, int[] prices) {
		int i = 0;
		int max = 0;
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		while (i < prices.length) {
			while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
				i++;
			}
			if (i >= prices.length - 1) {
				break;
			}
			int buy = prices[i];
			i++;
			while (i < prices.length && prices[i] > prices[i - 1]) {
				i++;
			}
			int sell = prices[i - 1];
			q.offer(sell - buy);
		}
		while (!q.isEmpty() && k > 0) {
			max += q.poll();
			k--;
		}
		return max;
	}

	public static int maxProfitdp(int k, int[] prices) {
		int sell[] = new int[k + 1];
		int buy[] = new int[k + 1];
		Arrays.fill(buy, Integer.MIN_VALUE);

		for (Integer price : prices) {
			for (int i = 1; i < k + 1; i++) {
				buy[i] = Math.max(buy[i], sell[i - 1] - price);
				sell[i] = Math.max(sell[i], buy[i] + price);
			}
		}
		return sell[k];

	}

}
