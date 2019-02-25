package algoQuestions;

import java.util.Scanner;

public class UglyNumbers {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int n =  sc.nextInt();
//		
//		while(n>0) {
//			System.out.println(uglyNum(sc.nextInt()));
//			n--;
//		}
		
		System.out.println(getNthUglyNo(1692));
		System.out.println(uglyNum(1692));
	}

	private static long uglyNum(int n) {

		long count = 1;
		long num = 1;
		while (n > count) {
			num++;
			if (isUgly(num))
				count++;

		}

		return num;
	}

	private static boolean isUgly(long num) {

		num = maxDivide(num, 2);
		num = maxDivide(num, 3);
		num = maxDivide(num, 5);
		if (num == 1)
			return true;

		return false;
	}

	private static long maxDivide(long num, int i) {
		while (num % i == 0)
			num = num / i;
		return num;
	}
	
	static long getNthUglyNo(int n) 
    { 
		long ugly[] = new long[n];  // To store ugly numbers 
        int i2 = 0, i3 = 0, i5 = 0; 
        long next_multiple_of_2 = 2; 
        long next_multiple_of_3 = 3; 
        long next_multiple_of_5 = 5; 
        long next_ugly_no = 1; 
          
        ugly[0] = 1; 
          
        for(int i = 1; i < n; i++) 
        { 
            next_ugly_no = Math.min(next_multiple_of_2, 
                                  Math.min(next_multiple_of_3, 
                                        next_multiple_of_5)); 
              
            ugly[i] = next_ugly_no; 
            if (next_ugly_no == next_multiple_of_2) 
            { 
               i2 = i2+1; 
               next_multiple_of_2 = ugly[i2]*2; 
            } 
            if (next_ugly_no == next_multiple_of_3) 
            { 
               i3 = i3+1; 
               next_multiple_of_3 = ugly[i3]*3; 
            } 
            if (next_ugly_no == next_multiple_of_5) 
            { 
               i5 = i5+1; 
               next_multiple_of_5 = ugly[i5]*5; 
            } 
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no; 
    } 

}
