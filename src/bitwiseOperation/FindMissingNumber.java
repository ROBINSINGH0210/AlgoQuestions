package bitwiseOperation;

public class FindMissingNumber {
	static int missingNumber(int arr[]) {
		int x =1 ;
		int y = arr[0];
		for(int i = 2; i <= arr.length+1; i++) {
			x ^= i;
		}
		for (int i = 1; i < arr.length; i++) {
			y ^=arr[i];
		}
		return x^y;
		
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,11,10,12,13,14};
		System.out.println(missingNumber(arr));
	}

}
