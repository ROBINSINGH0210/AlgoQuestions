package microsoft;

public class LargestSquare {
/* i = coulmn 
 j [1, 1, 0, 1, 0] 
  [0, 1, 1, 1, 0] 
  [1, 1, 1, 1, 0] 
  [0, 1, 1, 1, 1]
  */
	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 } };
		System.out.println(maxCount(arr));
	}

	static int maxCount(int arr[][]) {
		int temp[][] = new int[arr.length][arr[0].length];
		int coulmn = arr[0].length;
		int row = arr.length;
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < coulmn; j++) {
				if (i == 0 || j == 0 || arr[i][j] == 0) {
					temp[i][j] = arr[i][j];
				} else {
					int min = Math.min(temp[i - 1][j], Math.min(temp[i - 1][j - 1], temp[i][j - 1]));
					temp[i][j] = min + arr[i][j];
					if (result < temp[i][j]) {
						result = temp[i][j];
					}
				}

			}
		}
		return result;
	}

}
