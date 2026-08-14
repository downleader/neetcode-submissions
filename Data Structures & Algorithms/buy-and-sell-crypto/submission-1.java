class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;

        int minLeft = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minLeft > 0) {
                profit = Math.max(profit, prices[i] - minLeft);
            }
            minLeft = Math.min(minLeft, prices[i]);
        }

        return profit;
    }
}
