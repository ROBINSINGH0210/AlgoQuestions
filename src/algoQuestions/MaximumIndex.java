package algoQuestions;

public class MaximumIndex {

	public static void main(String[] args) {
		int arr[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		System.out.println(maxIndex(arr));
	}

	public static int maxIndex(int arr[]) {

		int maxSoFar = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] >= arr[i] && (j - i) > maxSoFar)
					maxSoFar = j - i;

		return maxSoFar;
	}
	
}
