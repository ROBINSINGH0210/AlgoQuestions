package microsoft;

public class FindMissingNumber {
	public static void main(String... strings) {
		int arr[] = { 1, 2, 3, 4, 5, 8, 9, 6, 7, 12, 11 };
		int num = 12;
		int sum = num * (num + 1) / 2;
		int ss =0;
		for(int i = 0; i< arr.length ; i++){
			sum -= arr[i];
		}
		System.out.println(getMissingNo(arr, arr.length));
		
		System.out.println(sum);
	}
	static int getMissingNo (int a[], int n)
    {
        int x1 = a[0]; 
        int x2 = 1; 
         
        /* For xor of all the elements 
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];
              System.out.println(x1);   
        /* For xor of all the elements 
           from 1 to n+1 */        
        for (int i = 2; i <= n+1; i++)
            x2 = x2 ^ i;         
         
        System.out.println(x2);
        return (x1 ^ x2);
    }
}
