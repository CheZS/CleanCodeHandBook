package com.misc;

public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		String s = "MXCVI";
		System.out.println(r.romanToInt(s));
	}
	public int romanToInt(String roman) {
		int len = roman.length();
		int num = 0;
		int i = 0;
		for (int j = 0; j < len; ) {
			if (symbols[i].length() == 1) {
				if (roman.substring(j, j + 1).equals(symbols[i])) {
					num += values[i];
					j += 1;
				} else {
					i++;
				}
			} else {
				if (j + 1 < len && roman.substring(j, j + 2).equals(symbols[i])) {
					j += 2;
					num += values[i];
				} else {
					i++;
				}
			}
		}
		return num;
	}
	private static final int[] values = {
		1000, 900, 500, 400, 
		100, 90, 50, 40, 
		10, 9, 5, 4, 
		1
	};
	private static final String[] symbols = {
		"M", "CM", "D", "CD", 
		"C", "XC", "L", "XL", 
		"X", "IX", "V", "IV", 
		"I"
	};
}
