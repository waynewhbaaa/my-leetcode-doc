class Solution {
    public int lastStoneWeightII(int[] stones) {
        // this could actually be similar to Q416
        // we can try to divide the stone into 2 piles and try to make as small possible.

        int sum = 0;
        for(int i : stones) sum += i;

        int target = sum / 2;

        int [] dp = new int[target + 1];
        for(int i = 0; i < stones.length ;i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j - stones[i]] + stones[i], dp[j]);
            }
        }
        return sum - dp[target] * 2;
    }
}
