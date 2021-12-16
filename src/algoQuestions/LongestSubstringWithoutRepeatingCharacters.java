package algoQuestions;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String  s = "";
		System.out.println(lengthOfLongestSubstring(s));
		
	}
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set =  new HashSet<>();
        int start =0;
        int end = 0;
        int max = 0;
        while(start<=end && end <s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                max = Math.max((end - start +1), max);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
                
            }
        }
        return max;
    }

}
