package practice;

public class FindTwoMissingNum {
	// , 4, 3
	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 2, 7, 12, 6 , 10, 11};
		getMissingNo(arr, 10);
	}

	static int getMissingNo(int a[], int n) {
		int x1 = a[0];
		int x2 = 1;
		int tosum = 1;
		int arrSum = a[0];
		int j = n + 2;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < n; i++) {
			x1 = x1 ^ a[i];
			arrSum += a[i];
		}
		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= n + 2; i++) {
			x2 = x2 ^ i;
			tosum += i;
		}

		System.out.println(arrSum + " ," + tosum + " - =" + (tosum - arrSum));
		int diff = tosum - arrSum;
		for (int i = (diff - j); i <= j; i++, j--) {
			if ((x1 ^ i) == 0 || i ==0) {
				continue;
			}
			if ((x2 ^ ((x1 ^ i) ^ j)) == 0) {
				System.out.println("Missing number i =" + i + " J=" + j);
				break;
			}
		}
		return (x1 ^ x2);
	}
}
