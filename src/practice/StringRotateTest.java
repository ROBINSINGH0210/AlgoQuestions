package practice;

public class StringRotateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "geeks";
	    String str2 = "eksge";
	   System.out.println(isRotateted(str1,str2,3));
	}
	private static boolean  isRotateted(String str1,String str2,int n){
		String s , s2;
		int len =str2.length();
		s = str2.substring(n)+ str2.substring(0, n);
		s2 = str2.substring(len-n, len) + str2.substring(0,len-n);
		if(s.equals(str1) || s2.equals(str1)){
			return true;
		}
		
		return false;
	}
}
