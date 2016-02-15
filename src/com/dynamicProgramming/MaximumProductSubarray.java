package com.dynamicProgramming;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = new int[]{2, -5, -2, -4, 3};
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(nums));
	}
	public int maxProduct(int[] nums) {
		int maxEndingHere = nums[0], maxSoFar = nums[0], minEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = maxEndingHere * nums[i];
			maxEndingHere = Math.max(nums[i], Math.max(temp, minEndingHere * nums[i]));
			maxSoFar = Math.max(maxSoFar, Math.max(maxEndingHere, minEndingHere * nums[i]));
			minEndingHere = Math.min(nums[i], Math.min(minEndingHere * nums[i], temp));
		}
		return maxSoFar;
	}
	
	public int maxProduct2(int[] nums) {
		assert nums.length > 0;
		int max = nums[0], min = nums[0], maxAns = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int mx = max, mn = min;
			max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
			min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
			maxAns = Math.max(max, maxAns);
		}
		return maxAns;
	}
}
