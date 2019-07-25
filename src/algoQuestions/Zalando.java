package algoQuestions;

import java.util.*;

public class Zalando {

	public static void main(String[] args) {
		 Integer N =55555555;
		
		 int num =1;
		 int len = String.valueOf(N).length();
		
		 while(len > 1){
		
		 num *=10;
		 len --;
		 }
		 System.out.println(num);

		 
		 
		 
		int A = 90;
		int B = 990;
		int count = 0;
		int x = 1;
		int y = 0;
System.out.println("");
		while ((y = x * (x + 1)) <= B) {
			System.out.println(y + "  "+x);
			if (y >= A && y <= B) {
				count++;
			}
			x++;
		}
//		System.out.println(count);

	}

}
