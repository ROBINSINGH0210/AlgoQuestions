package microsoft;

public class LongestString {

	public static void main(String[] args) {
		String str = "1111";
		System.out.println(longestStringLen(str));

	}

	static int longestStringLen(String str) {
		if (str == null || str.trim().equals(""))
			return 0;
		String s[] = str.split("0", 0);
		int max = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null && !"".equals(s[i]) && s[i].contains("1")) {
				if (s[i].length() > max)
					max = s[i].length();
			}
		}
		return max;
	}
}
