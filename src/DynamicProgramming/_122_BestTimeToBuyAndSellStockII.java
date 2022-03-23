package DynamicProgramming;

public class _122_BestTimeToBuyAndSellStockII {
   /**
    * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
    * However, you can buy it then immediately sell it on the same day.
    * Find and return the maximum profit you can achieve.
    * Example 1:
    *
    * Input: prices = [7,1,5,3,6,4]
    * Output: 7
    * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    * Total profit is 4 + 3 = 7.
    * Example 2:
    *
    * Input: prices = [1,2,3,4,5]
    * Output: 4
    * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    * Total profit is 4.
    *
    * Example 3:
    *
    * Input: prices = [7,6,4,3,1]
    * Output: 0
    * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
    */
   public int maxProfit(int[] prices) {
      // states: s1, s2
      // s1: state of buying, the max profit we can get after selling
      // s2: state of selling, the max profit we can get after buying

      // s1 = max(s1, s2 - prices[i])
      // s2 = max(s2, s1 + prices[i])

      // s1, 0 = 0 - prices[0]
      // s2, 0 = 0

      // return s2
      int s1 = -prices[0];
      int s2 = 0;

      for (int i = 0; i < prices.length; i++) {
         s1 = Math.max(s1, s2 - prices[i]);
         s2 = Math.max(s2, s1 + prices[i]);
      }
      return s2;
   }

   public int maxProfitBestSolution(int[] prices) {
      // Let's take a look at an example:
      // 1 3 6 9
      // the best solution in this sequence is buy it by 1 and sell it by 9, with a profit of 8
      // but we can tear this down:
      // (buy it by 1, sell it by 3) + (buy it again on 3 and sell it on 6...) until reaching 9
      // So, if there exists a consecutive increasing sequence, res += (p[i+1] - p[i]) can represent
      // maxProfit, since maxProfit(from i to j) = p[k+1] - p[k] for all i <= k <= j
      int res = 0;
      for (int i = 0; i < prices.length - 1; i++) {
         if (prices[i + 1] > prices[i]) res += prices[i+1] - prices[i];
      }
      return res;
   }
}
