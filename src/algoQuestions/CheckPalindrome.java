package algoQuestions;

class CheckPalindrome {
	static public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			if (isAlphaNumeric(s.charAt(i))) {
				i++;
				continue;
			} else if (isAlphaNumeric(s.charAt(j))) {
				j--;
				continue;
			} else {
				if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
					return false;
				} else {
					i++;
					j--;
				}
			}
		}
		return true;
	}

	static boolean isAlphaNumeric(char c) {
		return !((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || Character.isDigit(c));
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
	

	public static boolean validPalindrome(String s) {
        int count =0; 
        char []arr = s.toCharArray();
        int i =0;
        int j= arr.length -1;
        while(i<=j){
            if(arr[i]!=arr[j]){
            	return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
            else {
                i++;
            j--;
            }
            if(count>1){
                return false;
            }
            
        }
        return true;
        
    }
	
	private static boolean isPalindrome(String str, int s, int t){
        while (s <= t){
            if (str.charAt(s) == str.charAt(t)){
                s++;
                t--;
            }
            else
                return false;
        }
        
        return true;
    }
}