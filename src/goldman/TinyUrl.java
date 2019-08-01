package goldman;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TinyUrl {
	private static String charStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static AtomicLong atomicNum = new AtomicLong();
	private static int base = charStr.length();
	private static Map<Long, String> urlMap = new HashMap<Long, String>(100);

	public static String generateTinyUrl(String url) {
		long num = getNewNumber();
		String tinyUrl = createURL(num);
		urlMap.put(num, url);
		return tinyUrl;
	}

	private static long getNewNumber() {
		return Long.parseLong("" + System.currentTimeMillis() + atomicNum.incrementAndGet());
	}

	public static void main(String[] args) {
		String url = generateTinyUrl("www.google.com");
		System.out.println(url);
		System.out.println(reverseUrl(url));

	}

	private static String createURL(long num) {
		System.out.println(num);
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			 int rem = (int) (num % base);
			System.out.println("num -> "+ num +" , rem-> " +rem);
			sb.append(charStr.charAt(rem));
			num = num / base;
		}
		return sb.toString();

	}
	private static String reverseUrl(String tinyUrl) {
		long num = 0;
		char arr[] = tinyUrl.toCharArray(); 
		for (int i = arr.length -1 ; i >= 0; i--) {
			int index = charStr.indexOf(arr[i]);
			num += index * (long) Math.pow(base, i);
		}
		return urlMap.get(num);
	}
}
