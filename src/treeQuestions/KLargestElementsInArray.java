package treeQuestions;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;


public class KLargestElementsInArray {
	
	public static void main(String...strings){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i< 100000; i ++){
			list.add(ThreadLocalRandom.current().nextInt(1, 999999 + 1));
		}
		System.out.println("Array List Data");
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		getKLargestElement(5, list);
		
		
	}
	
	public static List<Integer> getKLargestElement(int k, List<Integer> list){
		Collections.sort(list,Collections.reverseOrder());
		for(int i = 0; i< k; i++){
			System.out.println(list.get(i));
		}
		return null;
		
	}
	
	
}
