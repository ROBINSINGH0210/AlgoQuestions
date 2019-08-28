package algoQuestions;

import java.util.Scanner;

class CombinationfromABCChar {
	public static void main (String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            t--;
            int n=sc.nextInt();
            int ans=n*((n*n)+3);
            ans=(ans/2)+1;
            System.out.println(ans);
        }
	}
	
	static void  solve(Integer N){
	    int total = 1;
	    total = total +  N ;// just b 
	    total = total +  N ;// just c
	    total = total + (N * (N -1)) / 2; //two cc
	    total = total + ((N * (N -1)) / 2 ) * (N - 2);//two cc 1 b
	    total = total + (N ) * (N - 1); // 1 b  1 c
	    System.out.println(total);
	}
}