package com.dynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author che
 *
 */
public class BestTimeToBuyAndSellStockIV {

	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2) return 0;
		if (k >= prices.length / 2) return new BestTimeToBuyAndSellStockII().maxProfit(prices);
		/*
		 * K represents the most transactions time(2).
		 * maxBefore[k][i] represents the max profit up until prices[i] use at most k transactions.
		 * maxBefore[k][i] = max(maxBefore[k][i-1], prices[i] - prices[j] + maxBefore[k-1][j])
		 *                 = max(maxBefore[k][i-1], prices[i] + max(maxBefore[k-1][j] - prices[j]))
		 *                 = max(maxBefore[k][i-1], prices[i] + lastTransactionsMaxBefore)
		 */
		int K = k;
		int maxProfit = 0;
		int[][] maxBefore = new int[K + 1][prices.length];
		
		for (k = 1; k <= K; k++) {
			int lastTransactionsMaxBefore = maxBefore[k - 1][0] - prices[0];
			for (int i = 1; i < prices.length; i++) {
				maxBefore[k][i] = Math.max(maxBefore[k][i-1], 
						prices[i] + lastTransactionsMaxBefore);
				lastTransactionsMaxBefore = Math.max(
						lastTransactionsMaxBefore, 
						maxBefore[k - 1][i] - prices[i]);
				maxProfit = Math.max(maxProfit, maxBefore[k][i]);
			}
		}
		
		return maxProfit;
	}
}
