package algoQuestions;

import java.util.*;

public class ModularExponentiation {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int testCase = sc.nextInt();
		 for(int i =0; i< testCase; i++) {
		 int a = sc.nextInt();
		 int b = sc.nextInt();
		 int c = sc.nextInt();
		
		 System.out.println(calaculateExp(a,b,c));
		 }
		
		System.out.println(calaculateExp(450, 768, 517));
	}

	private static long calaculateExp(int a, int b, int c) {
		long s = 1;
		for (int i = 0; i < b; i++) {
			s = ((s % c) * (a % c)) % c;
		}
		return s;
	}

}
