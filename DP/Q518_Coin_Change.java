class Solution {
    public int change(int amount, int[] coins) {
        // dp[j] represents the number of total combinations when you have
        int [] dp = new int[amount + 1];

        dp[0] = 1;

        // the outer has to be loop for the amount, since we are only dealing with the combination rather than permutation
        // to best determine what will be printed out, just try out printing something for the loop. No need to overthinking on the dp array
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
