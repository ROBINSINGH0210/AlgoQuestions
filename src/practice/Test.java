package practice;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcab";
		System.out.println( countSubstringWithEqualEnds(s));
		

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
