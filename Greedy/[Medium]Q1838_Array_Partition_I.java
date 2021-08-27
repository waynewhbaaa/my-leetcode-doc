class Solution {
    public int maxFrequency(int[] nums, int k) {
        // O(nlogn)
        // This sort is not stable and take a lot of spaces?
        Arrays.sort(nums);
        // sliding approach
        int i = 0, j = 0;
        int cur_sum = 0;
        int max = 0;
        while(j < nums.length && i < nums.length){
            int target = nums[j];
            cur_sum += nums[j];
            int diff = nums[j] * (j - i + 1) - cur_sum;
            if(target * (j - i + 1) - cur_sum <= k){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else{
                cur_sum -= nums[i] + nums[j];
                i++;
            }
        }

        return max;
    }
}
