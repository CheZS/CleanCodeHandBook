package com.bitManipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	/*
	 * Given an array of integers, every element appears two times exception for one.
	 * Find that single one.
	 */
	public int singleNumber(int[] nums) {
		int num = 0;
		for (int x : nums) {
			num ^= x;
		}
		return num;
	}
	
	public int singleNumber2(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int x : nums) {
			boolean flag = map.containsKey(x) ? false : true;
			map.put(x, flag);
		}
		for (int x : nums) {
			if (map.get(x) == true) return x;
		}
		throw new IllegalArgumentException("No single element.");
	}
}
