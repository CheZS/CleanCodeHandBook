package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n <= 1) {
			return 1;
		}
		if (map.containsKey(n)) return map.get(n);
		int way1 = climbStairs(n - 1);
		int way2 = climbStairs(n - 2);
		map.put(n, way1 + way2);
		return way1 + way2;
	}
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public int climbStairs2(int n) {
		int p = 1, q = 1;
		for (int i = 2; i <= n; i++) {
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
}
