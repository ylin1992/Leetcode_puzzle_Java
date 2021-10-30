package _Array;

public class _188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) {
            return 0;
        }

        int[][] dp = new int[k + 1][prices.length];
        for (int trans = 1; trans <= k; trans++) {
            // if the first transaction is going to be made,
            // the first maxRemaing would be the first price * -1
            // since we need to buy the stock first so that
            // we can "complete a transaction" after selling it
            int maxRemaining = -1 * prices[0];
            for (int day = 1; day < prices.length; day++) {
                // max profit made "after" each transaction is the maximum of two scenarios
                // 1 - if we do not make transaction today, the max profit remains as yesterday's
                //     max[trans][day] = max[trans][day - 1]
                // 2 - if we made a decision to make a transaction, we must "sell" it to make
                //     this transaction done, so whatever the cost of the stock is, we will gain
                //     prices[day] in our pocket.
                //     As for the cost, it would be max ( max[trans - 1][day from 0 ~ today] )
                //     So, we update maxRemaining = max[trans - 1][day from 0 ~ today] for each column
                //     after that, we add maxRemaining + prices[day], which is the potential max profit
                //     of the given t and d

                dp[trans][day] = Math.max(dp[trans][day - 1], maxRemaining + prices[day]);
                maxRemaining = Math.max(dp[trans - 1][day] - prices[day], maxRemaining);
            }
        }
        return dp[k][prices.length - 1];
    }
}
