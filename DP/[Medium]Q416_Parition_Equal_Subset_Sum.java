class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 == 1) return false;
        int target = sum / 2;

        int n = nums.length;
        // convert to a 0/1 nackpack problem
        int [] dp = new int[target + 1];

        for(int i = 0; i < n; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
            }
        }

        return dp[target] == target;
    }
}
