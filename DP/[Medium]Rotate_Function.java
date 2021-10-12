class Solution {
    public int maxRotateFunction(int[] nums) {
        // F(k) = F(k-1) + sum - nBK[0]; Math function lol
        if(nums == null || nums.length == 1) return 0;

        if(nums.length == 1) return Math.max(nums[0], nums[1]);

        int n = nums.length;

        int [] dp = new int[nums.length+1];
        int sum = 0, dp0 = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            dp0 += i * nums[i];
        }

        dp[0] = dp0;
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + sum - n * nums[n-i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
