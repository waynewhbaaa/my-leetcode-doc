class Solution {
    public int maxSubArray(int[] nums) {
        // Method 1: Greedy ?
//         int max = Integer.MIN_VALUE, count = 0;

//         for(int i = 0; i < nums.length; i++){
//             count += nums[i];
//             if(count > max) {
//                 max = count;
//             }
//             if(count <= 0) count = 0;
//         }

        // Method 2: Dynamic Programming
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(dp[i] > max) max = dp[i];
        }

        return max;
    }
}
