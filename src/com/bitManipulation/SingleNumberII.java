package com.bitManipulation;

import java.util.Arrays;

public class SingleNumberII {

	/*
	 * Given an array of integers, every element appears three times exception for one.
	 * Find that single one.
	 * Your algorithm should have a linear runtime complexity.
	 * Could you implement it without using extra memory?
	 */
	/*
	 * Calculate the sum of i_th bit of all numbers and mod 3, 
	 * the result is the single number's i_th value.
	 * Use an array of size 32 (count) to keep track of the total count of i_th bit.
	 */
	public int singleNumber(int[] nums) {
		int[] count = new int[32];
		Arrays.fill(count, 0);
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (((1 << i) & nums[j]) != 0) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		return result;
	}
	
	public int singleNumber2(int[] nums) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < nums.length; i++) {
			twos |= ones & nums[i];
			ones ^= nums[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
