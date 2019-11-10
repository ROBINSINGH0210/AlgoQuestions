package algoQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PairsWithAGivenSum {

	public static void main(String[] args) {
		int arr1[] = new int[] {-20, 4, -2,58,55, -4, 8,7, 6, 22, 10, -12};
//		System.out.println(findPairs(arr1, arr2, 9));
		
		
		System.out.println(getPairsWithSumFarToZero(arr1));

	}

	public static Set<String> findPairs(int arr1[], int arr2[], int sum) {
		Set<String> set = new TreeSet<>();
		Set<Integer> numSet = new HashSet<>();
		for (Integer integer : arr1) {
			numSet.add(integer);
		}

		for (Integer integer : arr2) {
			if (numSet.contains(sum - integer))
				set.add(sum - integer + " " + integer);
		}

		return set;

	}
	
	
	
	static Set<Pair> getPairsWithSumZero(int []arr){
	    Set<Pair> list = new HashSet<>();
	    Set<Integer> set = new HashSet<>();
	    for(Integer i: arr){
	        set.add(i);
	    }
	    
	    for(Integer a : arr){
	        if(set.contains(-(a)))
	            list.add(new Pair(a , -a));
	    }
	    
	    return list;
	}


	static Set<Pair> getPairsWithSumNearToZero(int []arr){
	    Set<Pair> list = new HashSet<>();
	    Arrays.sort(arr);
	    int i =0;
	    int j= arr.length -1;
	    
	    int min = Integer.MAX_VALUE;
	    while(i < j){
	        if(Math.abs(arr[i] + arr[j]) < min){
	            min = Math.abs(arr[i] + arr[j]);
	            list.clear();
	            list.add(new Pair(arr[i] , arr[j]));
	            i++;
	        } else if (Math.abs(arr[i] + arr[j]) == min){
	            list.add(new Pair(arr[i] , arr[j]));
	            i++;
	        }else{ 
	            j--;
	        }    
	    }
	    
	    return list;
	}


	static Set<Pair> getPairsWithSumFarToZero(int []arr){
	    Set<Pair> list = new HashSet<>();
	    Arrays.sort(arr);
	    int i =0;
	    int j= arr.length -1;
	    
	    int max = Integer.MIN_VALUE;

	    while(i < j){
	        if(Math.abs(arr[i] + arr[j]) > max){
	            max = Math.abs(arr[i] + arr[j]);
	            list.clear();
	            list.add(new Pair(arr[i] , arr[j]));
	            j--;
	        } else if (Math.abs(arr[i] + arr[j]) == max){
	            list.add(new Pair(arr[i] , arr[j]));
	            j--;
	        }else{ 
	            i++;
	        }    
	    }
	    
	    return list;
	}

}

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pair [x=").append(x).append(", y=").append(y).append("]");
		return builder.toString();
	}
    
}
