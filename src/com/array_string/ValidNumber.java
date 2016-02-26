package com.array_string;

public class ValidNumber {

	public boolean myValidNumber(String str) {
		int len = str.length();
		int i = 0;
		boolean dot = false;
		boolean e = false;
		boolean eDot = false;
		boolean num = false;
		
		while (i < len && Character.isWhitespace(str.charAt(i))) {
			i++;
		}
		if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
			i++;
		}
		if (i == len) {
			return false;
		}
		
		while (i < len) {
			if (Character.isDigit(str.charAt(i))) {
				i++;
				num = true;
				continue;
			}
			if (str.charAt(i) == '.' && dot == false && e == false) {
				dot = true;
				i++;
				num = false;
				continue;
			} else if (str.charAt(i) == '.' && dot == true && e == false){
				return false;
			}
			if (str.charAt(i) == 'e' && e == false) {
				e = true;
				i++;
				num = false;
				continue;
			} else if (str.charAt(i) == 'e' && e == true) {
				return false;
			}
			if (str.charAt(i) == '.' && e == true && eDot == false) {
				eDot = true;
				i++;
				num = false;
				continue;
			} else if (str.charAt(i) == '.' && e == true && eDot == true) {
				return false;
			}
			/* tail white space */
			while (i < len && Character.isWhitespace(str.charAt(i))) {
				i++;
			}
			if (i < len) {
				return false;
			}
		}
		return num;
	}
	
	public boolean validNumber(String str) {
		int i = 0;
		int len = str.length();
		while (i < len && Character.isWhitespace(str.charAt(i))) {
			i++;
		}
		if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
			i++;
		}
		boolean num = false;
		while (i < len && Character.isDigit(str.charAt(i))) {
			i++;
			num = true;
		}
		if (i < len && str.charAt(i) == '.') {
			i++;
			num = false;
			while (i < len && Character.isDigit(str.charAt(i))) {
				i++;
				num = true;
			}
		}
		if (num && i < len && str.charAt(i) == 'e') {
			i++;
			num = false;
			if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
				i++;
			}
			while (i < len && Character.isDigit(str.charAt(i))) {
				i++;
				num = true;
			}
			if (i < len && str.charAt(i) == '.') {
				i++;
				num = false;
				while (i < len && Character.isDigit(str.charAt(i))) {
					i++;
					num = true;
				}
			}
		}
		while (i < len && Character.isWhitespace(str.charAt(i))) {
			i++;
		}
		return num && i == len;
	}
}
