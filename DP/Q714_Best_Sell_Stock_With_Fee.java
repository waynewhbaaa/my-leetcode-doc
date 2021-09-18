class Solution {
    public int maxProfit(int[] prices, int fee) {
//         // method 1: greedy
//         int result = 0;

//         int min = prices[0];

//         for(int i = 0; i < prices.length; i++){
//             if(prices[i] < min) min = prices[i];

//             if(prices[i] >= min && prices[i] <= min + fee){
//                 continue;
//             }

//             if(prices[i] > min + fee){
//                 result += prices[i] - min - fee;
//                 min = prices[i] - fee;
//             }
//         }
//         return result;
        // method 2: dp
        int n = prices.length;
        int [][] dp = new int[prices.length][2];
        dp[0][0] -= prices[0];

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);

            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + prices[i] - fee);
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
