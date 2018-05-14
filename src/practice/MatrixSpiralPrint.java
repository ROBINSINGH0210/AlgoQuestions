package practice;

public class MatrixSpiralPrint {

	public static void main(String[] args) {
		int arr[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		printSpiral(2, 5, arr);

	}

	static void printSpiral(int lastRow, int lastColumn, int[][] arr) {
		int i,startRow=0,startColumn =0; 
		
		while(lastRow > startRow && lastColumn > startColumn){
			for(i = startColumn; i< lastColumn ; i++) {
				System.out.println(arr[startRow][i]);
			}
			startRow++;
			for(i = startRow; i< lastRow; i++) {
				System.out.println(arr[i][lastColumn-1]);
			}
			lastColumn--;
			
			if(startRow < lastRow) {
				for(i = lastColumn; i> startColumn; i--) {
					System.out.println(arr[lastRow-1][i-1]);
				}
				lastRow--;
			}
			if(startColumn < lastColumn) {
				for(i = lastRow; i> startRow; i--) {
					System.out.println(arr[i][startColumn]);
				}
				startColumn++;
			}
		}
	}
}
