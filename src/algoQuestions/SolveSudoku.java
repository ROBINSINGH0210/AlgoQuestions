package algoQuestions;

public class SolveSudoku {

	public static void main(String[] args) {

	}

	private static boolean solveSudoku(int board[][]) {

		int row = -1;
		int col = -1;
		boolean isEmpty = true;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty)
				break;
		}

		if (isEmpty)
			return true;

		for (int num = 1; num <= 9; num++) {
			if (isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(board)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}

		}

		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == num)
				return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num)
				return false;
		}
		// Check the 3*3 box for uniqueness
		int boxRowStart = row - row % 3;
		int boxColStart = col - col % 3;
		for (int i = boxRowStart; i < boxRowStart + 3; i++) {
			for (int j = boxColStart; j < boxColStart + 3; j++) {
				if (board[i][j] == num)
					return false;
			}
		}
		return true;
	}
}
