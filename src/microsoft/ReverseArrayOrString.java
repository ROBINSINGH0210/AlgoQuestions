package microsoft;

public class ReverseArrayOrString {

	static int[] reverse(int[] arr) {
		int size = arr.length -1;
		for (int i = 0; i < arr.length/2; i++) {
			int s = arr[i];
			arr[i] = arr[size];
			arr[size] = s;
			size--;
		}
		return arr;
	}
	
	static String reverseString(String str) {
		char arr[] = str.toCharArray();
		int size = arr.length -1;
		for (int i = 0; i < arr.length/2; i++) {
			char s = arr[i];
			arr[i] = arr[size];
			arr[size] = s;
			size--;
		}
		return new String(arr);
	}
	
	
	public static void main(String[] args) {
		int arr[] = {4, 5, 1, 2};
		reverse(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		
		System.out.println(reverseString("robin"));
	}

}
