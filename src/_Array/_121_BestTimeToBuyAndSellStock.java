package _Array;

public class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice);
        }

        return res < 0 ? 0 : res;
    }
}
