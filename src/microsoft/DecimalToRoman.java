package microsoft;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class DecimalToRoman {
	static Map<Integer, String> numberMap = new TreeMap<Integer, String>(Collections.reverseOrder());

	static {
		numberMap.put(1, "I");
		numberMap.put(4, "IV");
		numberMap.put(5, "V");
		numberMap.put(9, "IX");
		numberMap.put(10, "X");
		numberMap.put(40, "XL");
		numberMap.put(50, "L");
		numberMap.put(90, "XC");
		numberMap.put(100, "C");
		numberMap.put(400, "CD");
		numberMap.put(500, "D");
		numberMap.put(900, "CM");
		numberMap.put(1000, "M");
	}

	public static void main(String[] args) {
		System.out.println(decimalToRomanConv(549));
	}

	static String decimalToRomanConv(int num) {
		int quotient;
		StringBuilder sb = new StringBuilder();
		if (num == 0) {
			return "";
		} else {
			while (num > 0) {
				int divideNum = 1;
				for (Integer set : numberMap.keySet()) {
					if (num >= set) {
						divideNum = set;
						break;
					}
				}
				quotient = num / divideNum;
				while (quotient > 0) {
					sb.append(numberMap.get(divideNum));
					quotient--;
				}
				num = num % divideNum;
			}
		}
		return sb.toString();
	}

}
