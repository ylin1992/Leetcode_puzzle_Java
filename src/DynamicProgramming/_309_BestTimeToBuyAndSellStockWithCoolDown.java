package DynamicProgramming;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 *     After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 */
public class _309_BestTimeToBuyAndSellStockWithCoolDown {
   // states: s1, s2, s3
   // s1: states of holding a stock
   // s2: states of selling a stock
   // s3: states of resting

   // s1 can either stay at s1 (do nothing) or buy the stock from s3 and go to s2
   // s2 can only sell the stock from s1, and wait for one day to go to s3
   // s3 can either stay resting or update the profit from s2 on yesterday

   // initial state:
   // s1, 0 = 0 - prices[0]
   // s2, 0 = 0
   // s3, 0 = 0

   // previous_s2 = s2 (from the previous loop)
   // s1 = max(s1, s3 - prices[i])
   // s2 = s1 + prices[i]
   // s3 = max(s3, previous_s2)
   public int maxProfit(int[] prices) {
      int s1 = -prices[0];
      int s2 = 0;
      int s3 = 0;
      int res = 0;
      int s2Prev = 0;
      for (int i = 1; i < prices.length; i++) {
         s2Prev = s2;

         s1 = Math.max(s1, s3 - prices[i]);
         s2 = s1 + prices[i];
         // s3 = Math.max(s2, s3); // it won't work, since s2 cannot immediately go to s3,
         // so s3 should be compared to s2 at the previous loop (s2Prev)
         s3 = Math.max(s3, s2Prev);
      }
      return Math.max(s2, s3);
   }
}
