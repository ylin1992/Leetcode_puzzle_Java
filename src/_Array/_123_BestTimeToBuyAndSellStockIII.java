package _Array;

public class _123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int minFirstBuy = Integer.MAX_VALUE;
        int maxFirstSell = 0;
        int minSecondBuy = Integer.MAX_VALUE;
        int maxSecondSell = 0;

        for (int i = 0; i < prices.length; i++) {
            minFirstBuy = Math.min(minFirstBuy, prices[i]);
            maxFirstSell = Math.max(maxFirstSell, prices[i] - minFirstBuy);
            minSecondBuy = Math.min(minSecondBuy, prices[i] - maxFirstSell);
            maxSecondSell = Math.max(maxSecondSell, prices[i] - minSecondBuy);
        }
        return maxSecondSell;
    }
}
