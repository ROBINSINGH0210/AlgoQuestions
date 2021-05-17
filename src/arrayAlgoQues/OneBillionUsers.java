package arrayAlgoQues;

public class OneBillionUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] test_1 = { 1.1f, 1.2f, 1.3f };
		int expected_1 = 79;
		int output_1 = getBillionUsersDay(test_1);
		System.out.println(output_1);
	}

	static int getBillionUsersDay(float[] growthRates) {
		int start = 1;
		int end = 2_000; // considering this to be the upper_limit; can be discussed with the interviewer
		double target = 1_000_000_000;

		while (start < end) {
			double total = 0;
			int mid = start + (end - start) / 2;

			// calculate mid value
			for (float growthRate : growthRates) {
				total += userOnDay(growthRate, mid);
			}

			if (total == target) {
				return mid;
			}
			if (total > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	private static double userOnDay(float rate, int day) {
		return Math.pow(rate, day);
	}
}
