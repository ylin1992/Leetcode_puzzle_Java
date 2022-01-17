package DynamicProgramming;

public class _121_BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            res = Math.max(res, prices[i] - minPrice);
        }

        return  res > 0 ? res : 0;
    }
}
