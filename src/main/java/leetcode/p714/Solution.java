package leetcode.p714;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        final int n = prices.length;
        int optimal = 0;
        int maxOptMinusPrice = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            // If I don't sell here, my result is like previous.
            // I will just try to improve it by selling at current point
            final int ifISellNow = prices[i] + maxOptMinusPrice;
            optimal = Math.max(optimal, ifISellNow);
            maxOptMinusPrice = Math.max(maxOptMinusPrice, optimal - prices[i] - fee);
        }

        return optimal;
    }
}
