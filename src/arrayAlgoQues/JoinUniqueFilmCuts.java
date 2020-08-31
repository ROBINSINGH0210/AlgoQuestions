package arrayAlgoQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JoinUniqueFilmCuts {

	public static void main(String[] args) {
		List<String>  s = Arrays.asList("a","b","c","a");
		System.out.println(cutFilms(s)); 

	}
	public static List<Integer> cutFilms(List<String> inputList) {
        List<Integer> result = new ArrayList<>();
        Set<String> lstStr = new HashSet<>();
        int length;
        int i=0;
        int j=0;
        int lastP=0;
        for(i =0; i< inputList.size(); i++){
            length =0;
             lstStr.add(inputList.get(i));
           for( j =i; j< inputList.size(); j++){
               if(lstStr.contains(inputList.get(j))){
            	   lstStr.addAll(inputList.subList(i, j));
                  length = j-i +1;
                  lastP =j;
               } 
               
            }
           if(length > 1){
               i =lastP;
           }
            result.add(length);
            lstStr.clear();     
        }

        return result;
    }
}
