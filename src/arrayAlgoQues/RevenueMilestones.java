package arrayAlgoQues;

import java.util.*;

public class RevenueMilestones {

	public static void main(String[] args) {
	    int revenues_1[] = {100, 200, 300, 400, 500};
	    int milestones_1[] = {300, 800, 1000, 1400};
	    int expected_1[] = {2, 4, 4, 5};
	    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
	    System.out.println(Arrays.toString(output_1));
	    int revenues_2[] = {700, 800, 600, 400, 600, 700};
	    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
	    int expected_2[] = {5, 4, 2, 3, 2};
	    int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
	    System.out.println(Arrays.toString(output_2));
	}

	static int[] getMilestoneDays(int[] revenues, int[] milestones) {
		int res[] = new int[milestones.length];
		int rev[] = new int[revenues.length];
		int prev = 0;
		for (int i = 0; i < revenues.length; i++) {
			rev[i] = revenues[i] + prev;
			prev = rev[i];
		}
		for (int i = 0; i < milestones.length; i++) {
			search(rev, milestones[i], res, i);
		}
		return res;
	}

	private static void search(int[] rev, int val, int[] res, int index) {
		int start = 0;
		int end = rev.length;
		int s = searchIndex(rev, start, end, val);
		res[index] = s+1;
	}

	private static int searchIndex(int[] rev, int start, int end, int val) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (rev[mid] == val) {
			return mid;
		} else if (val > rev[mid] && (mid + 1) <= end && val <= rev[mid + 1]) {
			return mid + 1;
		} else if (val < rev[mid] && (mid - 1) >= start && val > rev[mid - 1]) {
			return mid;
		} else if (val > rev[mid]) {
			return searchIndex(rev, mid + 1, end, val);
		} else
			return searchIndex(rev, start, mid - 1, val);
	}
}
