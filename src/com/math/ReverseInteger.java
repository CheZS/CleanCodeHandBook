package com.math;

public class ReverseInteger {

	public int reverse(int x) {
		int maxDual10 = Integer.MAX_VALUE / 10;
		int res = 0;
		while (x != 0) {
			if (Math.abs(res) > maxDual10 && Math.abs(x) > 6) {
				return 0;
			}
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}
}
