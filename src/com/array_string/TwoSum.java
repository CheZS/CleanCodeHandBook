package com.array_string;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/**
	 * Given an array of integers, find two numbers 
	 * such that they add up to a specific target number.
	 * The function should return indices of the two numbers that they add up to the target,
	 * where index1 must be less than index2.
	 * Please note that your returned answers are not zero-based.
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int x = target - numbers[i];
			if (map.containsKey(x)) {
				return new int[]{map.get(x) + 1, i + 1};
			}
			map.put(numbers[i], i);
		}
		throw new IllegalArgumentException("No tow sum solution");
	}
	
	/**
	 * Similar to Question 1, 
	 * except that the input array is already sorted in ascending order.
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[]{numbers[i], numbers[j]};
			}
		}
		throw new IllegalArgumentException("No tow sum solution");
	}
	
	/**
	 * Design and implement a class. It should support the following operations:
	 * add(input) : Add the number input to an internal data structure.
	 * find(valve) : Find if there exists any pair of numbers which sum is equal to the value.
	 * @param numbers
	 * @param target
	 * @return
	 */
	@SuppressWarnings("unused")
	private class TwoSum3 {
		Map<Integer, Integer> map = null;
		
		TwoSum3() {
			this.map = new HashMap<Integer, Integer>();
		}
		TwoSum3(int[] inputs) {
			this();
			for (int i = 0; i < inputs.length; i++) {
				this.add(inputs[i]);
			}
		}
		
		void add(int input) {
			int count = map.containsKey(input) ? map.get(input) : 0;
			this.map.put(input, count + 1);
		}
		
		boolean find(int value) {
			if (map.isEmpty() || map.size() < 2) {
				return false;
			}
			for (Map.Entry<Integer, Integer> e : map.entrySet()) {
				int x = value - e.getKey();
				if (x == e.getKey()) {
					if (e.getValue() >= 2) {
						return true;
					}
				} else if (map.containsKey(x)) {
					return true;
				}
			}
			return false;
		}
	}
}
