package com.array_string;

import java.math.BigInteger;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * @author che
 *
 */
public class StringtoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.valueOf("-2147483648"));
		System.out.println(Integer.valueOf("+1"));
		System.out.println(Integer.valueOf("010"));
//		System.out.println(Integer.valueOf("+-2"));
//		System.out.println(Integer.valueOf("+"));
//		System.out.println(new StringtoInteger().myAtoi("-2147483648"));
//		System.out.println(new StringtoInteger().myAtoi("+1"));
//		System.out.println(new StringtoInteger().myAtoi(" 010"));
		System.out.println(new StringtoInteger().myAtoi("21474836480"));
//		System.out.println(new StringtoInteger().myAtoi("+-2"));
//		System.out.println(new StringtoInteger().myAtoi("+"));
//		System.out.println(new StringtoInteger().myAtoi("  -0012a42"));
	}

	public int myAtoi(String str) {
		if (str==null || str.isEmpty()) {
			return 0;
		}
		int start;
		int end;
		char tmp;
		for (start = 0; start < str.length(); start++) {
			tmp = str.charAt(start);
			if (tmp == ' ') {
				continue;
			}
			if (tmp == '+' || tmp == '-') {
				end = start + 1;
			} else {
				end = start;
			}
			for (; end < str.length() && ((str.charAt(end)>='0' && 
					str.charAt(end) <= '9')); end++) {}
			if (start > 0 && str.charAt(start-1) != ' ') {
				start--;
			}
			int out;
			try {
				BigInteger b = new BigInteger(str.substring(start, end));
				System.out.println(b);
				if (b.compareTo(new BigInteger("2147483648")) >= 0) {
					out = 2147483647;
				} else if (b.compareTo(new BigInteger("-2147483648")) < 0) {
					out = -2147483648;
				} else {
					out = b.intValue();
				}
			} catch (Exception e) {
				out = 0;
			}
			return out;
			
		}
		return 0;
    }
	
	private static final int MAX_DIV_10 = Integer.MAX_VALUE / 10;
	
	public int atoi(String str) {
		int i = 0;
		int len = str.length();
		int sign = 1;
		int num = 0;
		while (i < len && Character.isWhitespace(str.charAt(i))) {
			i++;
		}
		if (i < len && str.charAt(i) == '+') {
			i++;
		} else if (i < len && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		while (i < len && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			if (num > MAX_DIV_10 || (num == MAX_DIV_10 && digit >= 8)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
}
