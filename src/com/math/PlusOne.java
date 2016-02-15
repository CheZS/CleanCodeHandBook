package com.math;

import java.util.List;

public class PlusOne {

	public void plusOne(List<Integer> digits) {
		int carry = 1;
		for (int i = digits.size() - 1; i >= 0 && carry > 0; i--) {
			int d = digits.get(i);
			carry = (d + 1) / 10;
			digits.set(i, (d + 1) % 10);
		}
		if (carry > 0) {
			digits.add(0, carry);
		}
	}
	
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
			carry = (digits[i] + 1) / 10;
			digits[i] = (digits[i] + 1) % 10;
		}
		if (carry == 0) {
			return digits;
		} else {
			int[] res = new int[digits.length + 1];
			res[0] = carry;
			for (int i = 0; i < digits.length; i++) {
				res[i + 1] = digits[i];
			}
			return res;
		}
	}
}
