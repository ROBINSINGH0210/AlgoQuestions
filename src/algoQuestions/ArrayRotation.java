package algoQuestions;

public class ArrayRotation {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		printArr(arr);
		leftRotateArray(arr, 3, arr.length);
		printArr(arr);

	}

	static void leftRotate(int arr[], int d, int n) {
		for (int i = 0; i < d; i++)
			leftRotateByOne(arr, n);
	}

	static void leftRotateByOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}

	static void printArr(int arr[]) {
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println("");
	}

	static void leftRotateArray(int arr[], int d, int n) {
		d = d % n;

		int gcd = getGCD(d, n);
		int i, j = 0, k, temp;

		for (i = 0; i < gcd; i++) {
			temp = arr[i];
			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}

				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}

	}

	private static int getGCD(int d, int n) {
		if (n == 0)
			return d;
		return getGCD(n, d % n);
	}

}
