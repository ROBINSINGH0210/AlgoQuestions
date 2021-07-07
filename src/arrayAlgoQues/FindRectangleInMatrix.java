package arrayAlgoQues;

public class FindRectangleInMatrix {

	public static void main(String[] args) {
		int m[][] = new int[][]{
			      {1,0,0,1,0},
			      {0,0,1,0,1},
			      {0,0,0,1,0},
			      {1,0,1,0,1}};
			      
		System.out.println(isRectanglePresent(m));	      

	}

	static boolean isRectanglePresent(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			int index1 = -1, index2 = -1;
			for (int j = 0; j < arr[i].length; j++) {
				if (index1 == -1 && arr[i][j] == 1) {
					index1 = j;
				} else if (index2 == -1 && arr[i][j] == 1) {
					index2 = j;
				}

				if (index1 != -1 && index2 != -1) {
					// check next row for 
					if (checkNextRows(arr, i + 1, j, index1, index2))
						return true;
					index1 = index2;
					index2 = -1;
				}

			}
		}

		return false;
	}

	static boolean checkNextRows(int[][] arr, int i, int j, int index1, int index2) {

		while (i < arr.length) {
			if (arr[i][index1] == 1 && arr[i][index2] == 1) {
				return true;
			}
			i++;
		}
		return false;
	}

}
