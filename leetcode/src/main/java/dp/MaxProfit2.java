package dp;

public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0; //0 当天不持股
        dp[0][1] = -prices[0]; //1 当天持股
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
