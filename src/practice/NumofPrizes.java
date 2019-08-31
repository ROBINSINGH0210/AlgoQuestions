package practice;

import java.util.*;


public class NumofPrizes {

	public static void main(String[] args) {
		List<Integer> l= new ArrayList<>();
		l.add(20);
		l.add(40);
		l.add(60);
		l.add(80);
		l.add(100);
		System.out.println(numofPrizes(4, l));
	}
	
	 public static int numofPrizes(int k, List<Integer> marks) {
	        List<Integer> rankList= new ArrayList<>();
	        int count=0, rank=0 ;
	        int lastMark=0;
	        int total=0;
	        Collections.sort(marks,Collections.reverseOrder());
	        for(Integer e: marks){
	            if(e>0 && e==lastMark){
	                rankList.add(rank);
	                count++;
	            }else if(e >0 && e!=lastMark){
	                rankList.add(++count);
	                rank = count;
	                lastMark = e;
	            }
	        }
	        for(Integer l: rankList){
	            if(l<=k){
	                total++;
	            }else
	            break;
	        }

	        return total;
	    }
	 // 8 - 2222 , 422,44
	 //10 - 22222,442,224
	 //12 - 222222,102,84,66,
}
