package _Array;

public class _309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0;
        int maxHold = Integer.MIN_VALUE;
        int maxSold = 0;
        int maxRest = 0;
        for (int price : prices) {
            int prevSold = maxSold;
            maxHold = Math.max(maxHold, maxRest - price);
            maxSold = maxHold + price;
            maxRest = Math.max(prevSold, maxRest);
            maxProfit = Math.max(maxRest, maxSold);

        }

        return maxProfit;
    }
}
