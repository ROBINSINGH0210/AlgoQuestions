package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcab";
		List<Integer> s2 = new ArrayList<Integer>();
		s2.add(2);
		s2.add(33);
		s2.add(56);
		
		String str = s2.toString();
		System.out.println(s2.toString().replace("[", "").replace("]", ""));
//		
//		System.out.println( countSubstringWithEqualEnds(s));
//		

	}
	static int countSubstringWithEqualEnds(String s)
	{
	    int result = 0;
	    int n = s.length();
	    char[] s1 = s.toCharArray();
	 
	    // Iterating through all substrings in
	    // way so that we can find first and last
	    // character easily
	    for (int i=0; i<n; i++)
	        for (int j=i; j<n; j++)
	            if (s1[i] == s1[j])
	                result++;
	 
	    return result;
	}

}
