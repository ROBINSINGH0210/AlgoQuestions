package arrayAlgoQues;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, arr));
	}

	static int minSubArrayLen(int target, int[] arr) {
		int sum = 0;
		int i = 0;
		int start = 0;
		int res = Integer.MAX_VALUE;
		for (i = 0; i < arr.length; i++) {
			sum += arr[i];
			while (sum >= target) {
				res = Math.min(res, (i - start + 1));
				sum -= arr[start++];
			}

		}
		return res;
	}
}
