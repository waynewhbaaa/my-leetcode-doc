class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        // dp[i] represents the max product you can get at integer i;
        for(int i = 3; i <= n; i++){
            // used to cut?
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
            }
        }

        return dp[n];
    }
}
