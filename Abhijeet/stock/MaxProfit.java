public class MaxProfit {
    
    public int maxProfit(int[] prices) {
        int minStockPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++ ) {
            maxProfit = Math.max(maxProfit, prices[i]-minStockPrice);
            minStockPrice = Math.min(minStockPrice, prices[i]);
        }

        return maxProfit > 0 ? maxProfit: 0;
    }
}