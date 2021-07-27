package arrayAlgoQues;

public class MinimumFlipsToShiftAll1toRight {

	public static void main(String[] args) {
		MinimumFlipsToShiftAll1toRight m = new MinimumFlipsToShiftAll1toRight();
		int arr[] = { 0, 0, 0, 0, 1 };
		System.out.println(m.minShift(arr));
	}

	public int minShift(int arr[]) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int flip = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				flip++;
			left[i] = flip;
		}
		flip = 0;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 1)
				flip++;
			right[i] = flip;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (left[i - 1] + right[i] < min) {
				min = left[i - 1] + right[i];
			}
		}

		return min;
	}

}
