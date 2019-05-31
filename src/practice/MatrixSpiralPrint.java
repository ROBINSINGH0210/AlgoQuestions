package practice;

public class MatrixSpiralPrint {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
		printSpiral(2, 5, arr);

	}

	static void printSpiral(int lastRow, int lastColumn, int[][] arr) {
		int i, startRow = 0, startColumn = 0;

		while (lastRow > startRow && lastColumn > startColumn) {
			for (i = startColumn; i < lastColumn; i++) {
				System.out.println(arr[startRow][i]);
			}
			startRow++;
			for (i = startRow; i < lastRow; i++) {
				System.out.println(arr[i][lastColumn - 1]);
			}
			lastColumn--;

			if (startRow < lastRow) {
				for (i = lastColumn; i > startColumn; i--) {
					System.out.println(arr[lastRow - 1][i - 1]);
				}
				lastRow--;
			}
			if (startColumn < lastColumn) {
				for (i = lastRow; i > startRow; i--) {
					System.out.println(arr[i][startColumn]);
				}
				startColumn++;
			}
		}
	}

	static void rotateMatrix(int N, int mat[][]) 
    { 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) 
        { 
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++) 
            { 
                // store current cell in temp variable 
                int temp = mat[x][y]; 
       
                // move values from right to top 
                mat[x][y] = mat[y][N-1-x]; 
       
                // move values from bottom to right 
                mat[y][N-1-x] = mat[N-1-x][N-1-y]; 
       
                // move values from left to bottom 
                mat[N-1-x][N-1-y] = mat[N-1-y][x]; 
       
                // assign temp to left 
                mat[N-1-y][x] = temp; 
            } 
        } 
    } 
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void dfs(char[][] arr, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nx = dx[k] + i;
			int ny = dy[k] + j;
			if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && visited[nx][ny] == false
					&& arr[nx][ny] == 'X')
				dfs(arr, nx, ny, visited);

		}
	}
}
