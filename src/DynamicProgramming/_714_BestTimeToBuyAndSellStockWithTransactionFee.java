package DynamicProgramming;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 */
public class _714_BestTimeToBuyAndSellStockWithTransactionFee {
   // s1: max profit we get if we are holding a stock. s1 can come from s2 by s2 - prices[i]
   // s2: max profit we get if we are not holding a stock. s2 can come from s1 by (s1 + prices[i] - transaction fee)

   // s1 = max(s1, s2 - prices[i])
   // s2 = max(s2, s1 + prices[i] - transaction fee)

   // return s2

   // init: s1: -prices[0], s2 = 0;

   public int maxProfit(int[] prices, int fee) {
      int s1 = -prices[0];
      int s2 = 0;
      for (int i = 1; i < prices.length; i++) {
         s1 = Math.max(s1, s2 - prices[i]);
         s2 = Math.max(s2, s1 + prices[i] - fee);
      }
      return s2;
   }
}
