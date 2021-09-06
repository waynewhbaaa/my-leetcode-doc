class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        // Still, convert to Q416 problem.

        // Suppose the sum of positive is x, sum of negative is y;
        // sum of all int is sum; we know that target = x + y;
        // x - (target - x) = sum;
        // x = (sum + target) / 2;

        int sum = 0;

        for(int i : nums){
            sum += i;
        }
        if(target > sum) return 0;

        if((sum + target) % 2 == 1) return 0;

        int x = (sum + target) / 2;
        if(x < 0) return 0;
        int [] dp = new int[x+1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = x; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
                System.out.println(dp[j]);
            }
        }

        return dp[x];
    }
}
