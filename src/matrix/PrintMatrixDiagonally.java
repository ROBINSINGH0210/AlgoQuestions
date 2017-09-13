package matrix;
public class PrintMatrixDiagonally {

	public static void main(String[] args) {
		new PrintMatrixDiagonally();
	}

	public PrintMatrixDiagonally() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

		printMatrixDiagonally(matrix);
	}

	private void printMatrixDiagonally(int[][] matrix) {

		int rowCount = matrix.length;
		int columnCount = matrix[0].length;

		for (int r = 0; r < rowCount; r++) {
			for (int row = r, col = 0; row >= 0 && col < columnCount; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}

		for (int c = 1; c < columnCount; c++) {
			for (int row = rowCount - 1, col = c; row >= 0 && col < columnCount; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}

	}

}