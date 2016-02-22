package com.dynamicProgramming;

/**
 * Similar to Maximum sub array.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author che
 *
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * DP
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int maxEndingHere = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			int tempProfit = prices[i] - prices[i - 1];
			maxEndingHere = Math.max(maxEndingHere + tempProfit, tempProfit);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	
	
}
