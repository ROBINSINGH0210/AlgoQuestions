package arrayAlgoQues;

import java.util.*;

public class MinimumCostForTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] memo = new int[366];
	Set<Integer> dayset = new HashSet<Integer>();

	public int mincostTickets(int[] days, int[] costs) {
		Arrays.stream(days).forEach(d -> dayset.add(d));
		return dp(days, costs, 0);
	}

	int dp(int[] days, int[] costs, int day) {
		if (day > 365) {
			return 0;
		}
		if (memo[day] != 0) {
			return memo[day];
		}
		int ans = 0;

		if (dayset.contains(day)) {
			ans = Math.min(Math.min(dp(days, costs, day + 1) + costs[0], dp(days, costs, day + 7) + costs[1]),
					dp(days, costs, day + 30) + costs[2]);
		} else
			ans = dp(days, costs, day + 1);

		memo[day] = ans;
		return ans;
	}

}
